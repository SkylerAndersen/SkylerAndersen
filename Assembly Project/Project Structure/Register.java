abstract class Register {
    private int value;
    public Register () {}
    public Register (Register value) {}
    public Register (int value) {}
    public Register (long value) {}
    public Register (String value) {}
    abstract public void setValue (Register otherRegister);
    abstract public void setValue (int value);
    abstract public void setValue (long value);
    abstract public void setValue (String asciiBinary);
    abstract public int getValue ();
    abstract public String getBinaryValue ();
}