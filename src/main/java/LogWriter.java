import java.io.*;

public class LogWriter {
    private static FileWriter writer;
    private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new FileWriter(new File("output.csv"));
        } catch (IOException e) {
            System.out.println("No file");
        }
    }

    public static void write(String module, double x, double result) {
        try {
            writer.write(module + "," + x + "," + result  + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Write error");
        }

    }

    public static void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Close error");
        }
    }
}
