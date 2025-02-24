package pcd.lab01.ex01;

import static org.fusesource.jansi.Ansi.*;
import static pcd.lab01.ex01.AuxLib.*;

public class TestAuxLib {

	public static void main(String[] args) throws InterruptedException {
		
		var sentence = "This is a simple sentence with words ready to fall";

		Screen screen = Screen.getInstance();
		screen.clear();

		var wordList = getWordsPos(sentence);

		screen.writeStringAt(1, 0, Color.RED, sentence);
		Thread.sleep(2000);
		screen.clear();

		for (var wp: wordList) {
			var word = wp.word();
			var pos = wp.pos();
			Thread w = new Word(word, pos);
			w.start();
		}

	}

}
