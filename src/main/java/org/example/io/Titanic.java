package org.example.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Titanic {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/titanic.csv"));
        String line;
        while ((line = bf.readLine()) != null) {
            String[] fields = line.split(";");
            if ("male".equalsIgnoreCase(fields[3])) continue;
            System.out.println(fields[2] + " : " + fields[4]);
        }
        bf.close();
    }

}
