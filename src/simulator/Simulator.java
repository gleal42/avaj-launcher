package simulator;

import java.io.*;
import java.util.logging.Logger;

class Simulator
{
    public static void readFile(String filePath)
    {
        File file = new File("file.txt");
        if (filePath == null || filePath.trim().isEmpty())
        {
            System.exit(1);
        }
        try (LineNumberReader reader = new LineNumberReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidLine(line, reader.getLineNumber())) {
                    processLine(line, reader.getLineNumber());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    private static boolean isValidLine(String line, int lineNb) {
        // Add validation logic here
        return true;
    }
    private static void processLine(String line, int lineNb) {
        // Process the line here
        System.out.println(line);
    }
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Wrong number of arguments");
            System.exit(1);
        }
        readFile(args[0]);
    }

}