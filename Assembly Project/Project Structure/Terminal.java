import java.util.ArrayList;

abstract class Terminal {
    private boolean separateCommands;
    private Thread terminalThread;
    private ArrayList<String> commands;
    private String output;
    private int exitCode;
    private ThreadInstructions instructions;
    public Terminal () {}

    public Terminal (String command) {}

    /**
     * Write commands into the terminal
     * @param command shell command written in the terminal
     * */
    abstract public void write (String command);

    /**
     * run the commands written in the terminal
     * */
    abstract public void run ();

    /**
     * wait for the process to exit
     * @return int exit code of process or 1 if failed to wait for the thread
     * */
    abstract public int waitFor ();

    /**
     * output of the program that would have been printed to the terminal
     * you must call waitFor before calling get
     * @return String output from terminal
     * */
    abstract public String get ();
}