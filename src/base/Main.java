package base;

import controller.FileReader;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("src/base/words.txt");
        Game game = new Game(fileReader);
        while (game.playNext()) ;
    }
}