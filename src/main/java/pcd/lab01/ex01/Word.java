package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi.*;
import java.util.Random;

public class Word extends Thread {
    private final String word;
    private final int pos;
    private int y;
    private final int finalY;
    private final Random random;

    public Word(final String word, final int pos) {
        this.word = word;
        this.pos = pos;
        this.y = 0;
        this.finalY = 20;
        this.random = new Random();
    }

    public void run() {
        Screen screen = Screen.getInstance();
        while(y < finalY) {
            screen.writeStringAt(y, pos, Color.BLACK, word);
            y += random.nextInt(2);
            screen.writeStringAt(y, pos, Color.RED, word);
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
        screen.writeStringAt(y, pos, Color.BLACK, word);
        screen.writeStringAt(finalY + 1, pos, Color.RED, word);
    }
}
