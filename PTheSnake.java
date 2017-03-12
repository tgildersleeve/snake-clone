package snakeySnake;

import java.awt.Color;
import java.util.LinkedList;

import sedgewick.StdDraw;

public class PTheSnake {

	public LinkedList<Point> snake;
	public int direction;
	public boolean gameOver;

	/**
	 * Start snake with 3 points
	 * direction is set to noDirection, game is not over yet.
	 * @param snake
	 */
	public PTheSnake() {
		this.snake = new LinkedList<Point>();
		snake.add(new Point(GSnakeCanvas.boxWidth*3 , GSnakeCanvas.boxHeight *5));
		snake.add(new Point(GSnakeCanvas.boxWidth*3 , GSnakeCanvas.boxHeight *4));
		snake.add(new Point(GSnakeCanvas.boxWidth*3 , GSnakeCanvas.boxHeight *3));
		
		this.direction = 0;
		this.gameOver = false;
	}


	/**
	 * Get Direction method
	 * @return
	 */
	public int getDirection() {
		return direction;
	}


	/**
	 * Set Direction method
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}


	/**
	 * check if GameOver is true or false
	 * @return
	 */
	public boolean isGameOver() {
		return gameOver;
	}


	/**
	 * method to set gameOver to true or false
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}


	/**
	 * Draws the snake
	 */
	public void drawSnake() {
		for (Point p : snake) {
			StdDraw.setPenColor(Color.green);
			StdDraw.filledRectangle(p.x , p.y , GSnakeCanvas.boxWidth/2, GSnakeCanvas.boxHeight/2);
			StdDraw.setPenColor(new Color(20,100,100));
			StdDraw.rectangle(p.x , p.y , GSnakeCanvas.boxWidth/2, GSnakeCanvas.boxHeight/2);
		}
	}


	/**
	 * changes snake direction in response to appropriate arrow key clicks
	 */
	public void changeDir() {
		if (StdDraw.isKeyPressed(38)) { // up arrow
			setDirection(1);
		}
		if (StdDraw.isKeyPressed(40)) { // down arrow
			setDirection(2);
		}
		if (StdDraw.isKeyPressed(37)) { // left arrow
			setDirection(3);
		}
		if (StdDraw.isKeyPressed(39)) { // right arrow
			setDirection(4);
		}
	}



	/**
	 * "moves" the snake by adding point to head of snake and deleting last point
	 * and determines when game is over
	 */
	public void move() {
		Point head = snake.peekFirst();
		Point newPoint = head;

		if (getDirection() == SnakeDirection.north) {
			newPoint = new Point(head.x, head.y + 5);
		}
		else if (direction == SnakeDirection.south) {
			newPoint = new Point(head.x,head.y-5);
		}
		else if (direction == SnakeDirection.west) {
			newPoint = new Point(head.x-5,head.y);
		}
		else if (direction == SnakeDirection.east) {
			newPoint = new Point(head.x+5,head.y);
		}

		if(getDirection() != SnakeDirection.noDirection) {
			snake.remove(snake.peekLast());
		}

		// game over scenarios:
		if (newPoint.x < 5 || newPoint.x > GSnakeCanvas.gridWidth * GSnakeCanvas.boxWidth-5) {
			// went oob, reset game
			setGameOver(true);
		}
		else if (newPoint.y < 5 || newPoint.y > GSnakeCanvas.gridHeight * GSnakeCanvas.boxHeight-5) {
			// went oob, reset game
			setGameOver(true);
		}

		for (int i = 1; i < snake.size(); i++) {
			// if snake hits itself:
			if (snake.getFirst().x == snake.get(i).x && snake.getFirst().y == snake.get(i).y) {
				setGameOver(true);
			}
		}

		// if we reach this point, we're still good & playing
		snake.push(newPoint); // push means add first

	}


	/**
	 * had to make an add point to snake method to use in the main
	 * @param point
	 */
	public void add(Point point) {
		snake.add(point);
	}


	/**
	 * makes eyes for head point
	 * @param eyeX
	 * @param eyeY
	 */
	public void eyes(double eyeX, double eyeY) {
		if (direction == 1) {
			StdDraw.filledCircle(eyeX + 1.5, eyeY-5, .5);
			StdDraw.filledCircle(eyeX - 1.5, eyeY-5, .5);
		}
		if (direction == 2) {
			StdDraw.filledCircle(eyeX + 1.5, eyeY + 5, .5);
			StdDraw.filledCircle(eyeX - 1.5, eyeY + 5, .5);
		}
		if (direction == 3) {
			StdDraw.filledCircle(eyeX + 5, eyeY + 1.5, .5);
			StdDraw.filledCircle(eyeX + 5, eyeY - 1.5, .5);
		}
		if (direction == 4) {
			StdDraw.filledCircle(eyeX-5, eyeY + 1.5, .5);
			StdDraw.filledCircle(eyeX-5, eyeY - 1.5, .5);
		}
	}


}
