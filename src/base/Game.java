package base;

import controller.Controller;
import controller.FileReader;
import view.View;

public class Game {
    private FileReader fileReader;

    public Game(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public boolean playNext() {
        Controller controller=new Controller(fileReader.getWord());
        View view=new View(controller);
        return view.interact();
    }
}
