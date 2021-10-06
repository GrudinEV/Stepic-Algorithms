package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateInput {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("input.txt"));
        int n = 100000;
        writer.println(n);
        int value = 500000000;
        for (int i = 0; i < n; i++) {
//            writer.print(((int) (Math.random() * 1000000000) + 1) + " ");
//            writer.print(value-- + " ");
            writer.print(value + " ");
        }
        writer.close();
    }
}
