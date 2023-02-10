package view;

import controller.Controller;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class View {

    private Scanner scanner = new Scanner(in);
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public boolean interact() {
        boolean isAlive = true;
        do {
            show();
            char letter = scanner.next().charAt(0);
            String hidden = controller.check(Character.toUpperCase(letter));
            if (hidden == null){
                show();
                isAlive = false;
            }
            else if (!hidden.contains("_")) {
                show();
                break;
            }
        } while (isAlive);
        out.println(isAlive ? "Won!" : "Died! "+controller.getWord());
        out.println("New game? y/n");
        return scanner.next().charAt(0) == 'y';
    }

    private void show() {
        showGallows();
        out.printf("%23s%n", controller.getHidden());
        for (char ch = 'A'; ch <= 'Z'; ch++) out.print((controller.getAbc().contains(ch) ? ch + " " : "  "));
        out.println();
        for (char ch = 'A'; ch <= 'Z'; ch++) out.print((!controller.getAbc().contains(ch) ? ch + " " : "  "));
        out.println();
    }

    private void showGallows() {
        int life= controller.getLife();
        for (char ch:gallows.toCharArray()) {
            if(ch=='\n') out.println();
            else if(ch-'0'>=life) out.print('o');
            else out.print(' ');
        }
        out.println();
    }

    private String gallows= """
            877777777
            8      6
            8     555
            8     5 5
            8      4
            8    33422
            8      4
            8     1 0
            8    1   0
            8
            """;

}
