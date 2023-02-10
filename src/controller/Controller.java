package controller;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Controller {
    private String word;
    private char[] hidden;
    private int life = 9;

    public int getLife() {
        return life;
    }

    private List<Character> abc = new ArrayList<>();

    public Controller(String word) {
        this.word = word;
        hidden = "_".repeat(word.length()).toCharArray();
        for (char ch = 'A'; ch <= 'Z'; ch++) abc.add(ch);
    }

    public String getWord() {
        return word;
    }

    public String getHidden() {
        return new String(hidden);
    }

    public List<Character> getAbc() {
        return abc;
    }

    public String check(char letter) {
        if(!abc.contains(letter))
            return new String(hidden);
        boolean good=false;
        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) == letter) {
                hidden[i] = letter;
                good=true;
            }
        abc.remove((Character) letter);
        if(!good) life--;
        return (life == 0) ? null : new String(hidden);
    }
}
