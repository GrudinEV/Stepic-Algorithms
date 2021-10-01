package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateInput {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("input.txt"));
        int n = 10000;
        writer.write(n + "\n");
        for (int i = 0; i < n; i++) {
            writer.write(((int) (Math.random() * 10) + 1) + " ");
        }
        writer.close();
    }
}
