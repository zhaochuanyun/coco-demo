package thinking.in.java.io;

//: io/BasicFileOutput.java
import java.io.*;

public class BasicFileOutput {
    static String file = "D:\\tmp\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile
                                .read(".\\src\\thinking\\in\\java\\thinking\\in\\java\\io\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) */// :~
