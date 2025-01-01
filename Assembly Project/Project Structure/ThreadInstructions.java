import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

abstract class ThreadInstructions implements Runnable {
    private String[] commands;
    private StringBuilder output;
    private int exitCode;
    private boolean runSeparate;
    private String oneCommand;

    public ThreadInstructions (String[] commands, boolean separateCommands) {}
    abstract public void run ();

    abstract public String getOutput ();

    abstract public int getExitCode ();
}