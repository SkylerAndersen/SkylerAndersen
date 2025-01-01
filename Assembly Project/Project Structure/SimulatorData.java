import java.util.HashMap;
import java.util.Stack;

abstract public class SimulatorData {
    public Register R0;
    public Register R1;
    public Register R2;
    public Register R3;
    public Register R4;
    public Register R5;
    public Register R6;
    public Register R7;
    public Register R8;
    public Register R9;
    public Register TP;
    public Register CL;
    public Register ST;
    public Register CN;
    public Register PK;
    public Stack<Integer> PS;
    public HashMap<Integer,Integer> stack; // ironic
    public SimulatorData () {}
    abstract public String getRegisterName (int number);
    abstract public int getRegisterNumber (String name);
}
