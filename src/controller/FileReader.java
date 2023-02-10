package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;

public class FileReader {

    private List<String> words = new ArrayList<>();
    private String file;

    public FileReader(String file) {
        this.file = file;
        readFile();
    }

    public void readFile() {
        try {
            java.io.FileReader fileReader = new java.io.FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) words.add(line);
        } catch (IOException e) {
            err.println("No such file or IO error!");
            exit(0);
        }
    }
    public String getWord() {
        int index = new Random().nextInt(words.size());
        return words.remove(index).toUpperCase();
    }
}
