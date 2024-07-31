package com.example.java1final;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileHandler {
    private File file

    public FileHandler(String fileName)
            throws IOException {
        BufferedWriter charOut = new BufferedWriter(new FileWriter(fileName));
        charOut.write("Test");
        charOut.close();
    }
}


