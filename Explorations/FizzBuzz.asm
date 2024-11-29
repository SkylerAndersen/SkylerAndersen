# This is FizzBuzz for numbers 1-100 (inclusive).
# This program uses MIPS Assembly Language.
# This should be compatible simulators that may even be missing features such as JAL,
# JR, DIV, and only requires the Print String MARS SYSCALL. Division with remainders,
# and converting Integers to their equivalent ASCII representations via casting has custom
# implementation in this program. Feel free to change $s6's initial value for the first
# digit in FizzBuzz, or $s7's value for the maximum digit (not inclusive).
# This program was made to run on the following online MIPS simulator:
# https://rivoire.cs.sonoma.edu/cs351/wemips/


j STORE_STRINGS
START:
ADDI $s6, $zero, 1 # i = 0 ($s6)
ADDI $s7, $zero, 101 # 100 ($s7)

FOR:
# find i % 3
ADD $v0, $zero, $s6 # param1 = i
ADDI $v1, $zero, 3 # param2 = 3
ADDI $a0, $zero, 1 # call number = 1
j DIV_SUBROUTINE
DIV_RETURN_1:

# find (i % 3 == 0), $s3 == 1: true, $s3 == 0: false
BEQ $a1, $zero, IMOD3_EQZ
# if (i % 3 != 0)
ADDI $s3, $zero, 0 # (i % 3 == 0) is false, $s3 = 0
j END_IF_MOD3
# if (i % 3 == 0)
IMOD3_EQZ:
ADDI $s3, $zero, 1 # (i % 3 == 0) is true, $s3 = 1
END_IF_MOD3:

# find i % 5
ADD $v0, $zero, $s6 # param1 = i
ADDI $v1, $zero, 5 # param2 = 5
ADDI $a0, $zero, 2 # call number = 2
j DIV_SUBROUTINE
DIV_RETURN_2:

# find (i % 5 == 0), $s4 == 1: true, $s4 == 0: false
BEQ $a1, $zero, IMOD5_EQZ
# if (i % 5 != 0)
ADDI $s4, $zero, 0 # (i % 5 == 0) is false, $s4 = 0
j END_IF_MOD5
# if (i % 5 == 0)
IMOD5_EQZ:
ADDI $s4, $zero, 1 # (i % 5 == 0) is true, $s4 = 1
END_IF_MOD5:

# fizzbuzz if block
AND $t0, $s3, $s4 # $t0 = (i % 3 == 0 && i % 5 == 0)
ADDI $t1, $zero, 1
BEQ $t0, $t1, COND_1 # if (i % 3 == 0 && i % 5 == 0) COND_1
BEQ $s3, $t1, COND_2 # else if (i % 3 == 0) COND_2
BEQ $s4, $t1, COND_3 # else if (i % 5 == 0) COND_3
j ELSE # else
COND_1:
ADDI $v0, $zero, 4
ADD $a0, $zero, $s0
SYSCALL
j END_IF
COND_2:
ADDI $v0, $zero, 4
ADD $a0, $zero, $s1
SYSCALL
j END_IF
COND_3:
ADDI $v0, $zero, 4
ADD $a0, $zero, $s2
SYSCALL
j END_IF

ELSE:
# print integer does not work, so the int must be cast to a string
# the ascii number is printed

# cast int to String
ADD $v0, $zero, $s6 # param1 = i
j CAST_INT_TO_STRING
RETURN_FROM_CAST:

# print
ADDI $v0, $zero, 4
SYSCALL

# deallocate memory
ADD $sp, $zero, $a1

END_IF:

# end of loop
ADDI $s6, $s6, 1 # i++
BNE $s6, $s7, FOR # loop
j END # program end after end of loop

# Integer Cast Subroutine
CAST_INT_TO_STRING:
ADD $a2, $zero, $v0 # store int in $a2
ADDU $a3, $zero, $sp # old stack pointer to deallocate the memory later
ADDIU $sp, $sp, -1
SB $zero, 0($sp) # push null to the stack

# while loop
CAST_LOOP:
BEQ $a2, $zero, BREAK_LOOP # while ($a2(int being cast) != 0)

ADD $v0, $zero, $a2 # param1 = int
ADDI $v1, $zero, 10 # param2 = 10
ADDI $a0, $zero, 3 # return to three
j DIV_SUBROUTINE # int / 10 = (a0=quotient,a1=remainder)
DIV_RETURN_3:
ADD $a2, $zero, $a0 # int /= 10
ADDI $a1, $a1, 48 # (last digit or remainder)->ascii value
ADDIU $sp, $sp, -1
SB $a1, 0($sp) # push char to the stack

j CAST_LOOP
BREAK_LOOP:
ADDU $a0, $zero, $sp # return address of string cast
ADDU $a1, $zero, $a3 # return second the old $sp position

j RETURN_FROM_CAST

# Division Subroutine
DIV_SUBROUTINE:
ADD $t1, $zero, $zero

DIV_LOOP:
SLT $t0, $v0, $v1
BNE $t0, $zero, DIV_END # if (param1 < param2) end
SUB $v0, $v0, $v1 # else param1 -= param2
ADDI $t1, $t1, 1 # count++

j DIV_LOOP
DIV_END:
ADD $v1, $zero, $a0 # hold on to $a0 in $v1, subroutine return number
ADD $a1, $zero, $v0 # set remainder return value
ADD $a0, $zero, $t1 # set division return value
ADDI $t0, $zero, 1
BEQ $v1, $t0, DIV_RETURN_1
ADDI $t0, $zero, 2
BEQ $v1, $t0, DIV_RETURN_2
ADDI $t0, $zero, 3
BEQ $v1, $t0, DIV_RETURN_3

# store strings
STORE_STRINGS:
# store fizzbuzz
ADDIU $sp, $sp, -9
ADDU $s0, $sp, $zero
ADDI $t0, $zero, 70 # 'F'
SB $t0, 0($sp)
ADDI $t0, $zero, 105 # 'i'
SB $t0, 1($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 2($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 3($sp)
ADDI $t0, $zero, 66 # 'B'
SB $t0, 4($sp)
ADDI $t0, $zero, 117 # 'u'
SB $t0, 5($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 6($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 7($sp)
SB $zero, 8($sp)

# store fizz
ADDIU $sp, $sp, -5
ADDU $s1, $sp, $zero
ADDI $t0, $zero, 70 # 'F'
SB $t0, 0($sp)
ADDI $t0, $zero, 105 # 'i'
SB $t0, 1($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 2($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 3($sp)
SB $zero, 4($sp)

# store buzz
ADDIU $sp, $sp, -5
ADDU $s2, $sp, $zero
ADDI $t0, $zero, 66 # 'B'
SB $t0, 0($sp)
ADDI $t0, $zero, 117 # 'u'
SB $t0, 1($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 2($sp)
ADDI $t0, $zero, 122 # 'z'
SB $t0, 3($sp)
SB $zero, 4($sp)

j START
END: