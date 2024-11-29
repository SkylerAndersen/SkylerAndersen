import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultithreadingPractice {
    public static void main (String[] args) throws Exception {
        System.out.print(Thread.currentThread().getId() + ": ");
        System.out.println("I'm going to make a new Thread!");
        Thread otherThread = new Thread(() -> {
            String command = "cd " + System.getProperty("user.home") +
                    "/desktop && pwd";
            ProcessBuilder builder = new ProcessBuilder();
            String[] builderCommand = {"/bin/bash","-c",command};
            builder.command(builderCommand);
            System.out.print(Thread.currentThread().getId() + ": ");
            System.out.println("Separate Thread!");
            try {
                Process process = builder.start();
                System.out.print(Thread.currentThread().getId() + ": ");
                System.out.println("Running some commands");
                int exitCode = process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String temp;
                while ((temp = reader.readLine()) != null) {
                    output.append(temp);
                    output.append('\n');
                }
                reader.close();
                System.out.print(Thread.currentThread().getId() + ": ");
                System.out.println("-----Output from terminal-----");
                System.out.println(output);
                System.out.println("Exit code: " + exitCode);
                System.out.print(Thread.currentThread().getId() + ": ");
                System.out.println("-----Output from terminal-----");
            } catch (Exception e) {
                System.out.print(Thread.currentThread().getId() + ": ");
                System.out.println("Failed to run process.");
            }
        });
        otherThread.start();
        otherThread.join();
        System.out.print(Thread.currentThread().getId() + ": ");
        System.out.println("Other thread has died, and we are in main thread.");
        System.out.println("Ending main Thread!");
    }
}