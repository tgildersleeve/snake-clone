package snakeySnake;

import java.awt.Color;
import sedgewick.StdDraw;

public class GSnakeCanvas {

	public static int boxHeight = 5;
	public static int boxWidth = 5;
	public static int gridHeight = 30;
	public static int gridWidth = 30;
	
	public GSnakeCanvas() {
	}

	/**
	 * Draws grid!
	 */
	public void drawGrid() {
		StdDraw.setPenColor(Color.black);
		// first, draw horizontal lines:
		for (double i = boxHeight - 2.5 ; i < boxHeight * gridHeight; i += boxHeight) {
			StdDraw.line(2.5, i, (boxWidth) * gridWidth - 2.5, i);
		}
		// second, draw vertical lines:
		for (double j = boxWidth - 2.5; j < boxWidth * gridWidth; j += boxWidth) {
			StdDraw.line(j, 2.5, j, (boxHeight) * gridHeight - 2.5);
		}
	}

}
