package snakeySnake;

import java.awt.Color;
import sedgewick.StdDraw;

public class GFruit {

	public Point a;
	public int x;
	public int y;

	/**
	 * constructor. fruit has-a point made of an x and y coordinate
	 * @param x
	 * @param y
	 */
	public GFruit(int x, int y){
		this.x = x;
		this.y = y;
		this.a = new Point(x,y);
	}

	
	/**
	 * method to get the fruit point
	 * @return
	 */
	public Point getFruit() {
		return a;
	}
	

	/**
	 * draw the fruit!
	 */
	public void drawFruit() {
		StdDraw.setPenColor(Color.red);
		StdDraw.filledEllipse(getFruit().x, getFruit().y, GSnakeCanvas.boxWidth/2, GSnakeCanvas.boxHeight/2);
	}
	

	/**
	 * randomize a new fruit point
	 */
	public void newFruit() {
		int fruitX = (int) ((Math.round((Math.random()*26 + 2)*1))/1 * GSnakeCanvas.boxWidth) ;
		int fruitY = (int) ((Math.round((Math.random()*26 + 2)*1))/1 * GSnakeCanvas.boxHeight);
		Point newF = new Point(fruitX, fruitY);
		this.a = newF;
	}


}
