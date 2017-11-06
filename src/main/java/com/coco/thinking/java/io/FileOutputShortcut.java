package com.coco.thinking.java.io;

//: io/FileOutputShortcut.java
import java.io.*;

public class FileOutputShortcut {
    static String file = "D:\\tmp\\FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(
                BufferedInputFile.read(".\\src\\thinking\\in\\java\\thinking\\in\\java\\io\\FileOutputShortcut.java")));
        // Here's the shortcut:
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) */// :~
