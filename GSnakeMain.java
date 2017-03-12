package snakeySnake;

import java.awt.Color;
import java.awt.Font;
import sedgewick.StdDraw;

public class GSnakeMain {

	public PTheSnake snake;
	public GSnakeCanvas grid;
	public GFruit fruit;
	public int score;
	public boolean paused;

	/**
	 * constructs a game with a snake, grid, and fruit
	 */
	public GSnakeMain() {
		this.snake = new PTheSnake();
		this.grid = new GSnakeCanvas();
		this.fruit = new GFruit(GSnakeCanvas.boxWidth * 15, GSnakeCanvas.boxHeight * 15);
		this.score = 0;
		this.paused = false;
	}

	
	/**
	 * sets up a new game, reverting everything to original settings
	 */
	public void reset() {
		this.snake = new PTheSnake();
		this.grid = new GSnakeCanvas();
		this.fruit = new GFruit(GSnakeCanvas.boxWidth * 15, GSnakeCanvas.boxHeight * 15);
		this.score = 0;
		this.paused = false;
		snake.setDirection(1);
	}


	/**
	 * draws score
	 */
	public void drawScore() {
		StdDraw.setFont(new Font ("Arial", Font.BOLD, 15));
		StdDraw.setPenColor(Color.black);
		StdDraw.text(135, 0, "Score: " + score);
	}


	public void pauseGame() {
		StdDraw.setPenColor(Color.black);
		StdDraw.setFont(new Font ("Arial", Font.BOLD, 13));
		StdDraw.text(115, 150, "press spacebar to pause game");
		
		if (StdDraw.isKeyPressed(32)) {
			this.paused = true;
			StdDraw.clear();
			StdDraw.setFont(new Font ("Arial", Font.BOLD, 13));
			StdDraw.text(75, 75, "press mousepad to resume game");
			StdDraw.show();
			
			while (!StdDraw.mousePressed()) {
			}
			this.paused = false;
		}
	}


	/**
	 * sets up animation loop
	 * ends when player does a gameOver action
	 * may need to change gameOver stuff
	 * should reset too
	 */
	public void play() {

		int speed = 100;

		// draw everything
		StdDraw.setXscale(0,150);
		StdDraw.setYscale(0,150);
		grid.drawGrid();
		fruit.drawFruit();
		snake.drawSnake();
		drawScore();
		
		System.out.println(snake.snake.peekFirst().x + "  " + snake.snake.peekFirst().y);
		System.out.println(GSnakeCanvas.boxWidth*3 + "  " + GSnakeCanvas.boxHeight*5);


		StdDraw.filledCircle(GSnakeCanvas.boxWidth*3 + 1.5, GSnakeCanvas.boxHeight *5, .5); // starting eyes
		StdDraw.filledCircle(GSnakeCanvas.boxWidth*3 - 1.5, GSnakeCanvas.boxHeight *5, .5);
		StdDraw.setPenColor(Color.black);
		StdDraw.setFont(new Font ("Arial", Font.BOLD, 100));
		StdDraw.text(75, 100, "SNAKE");
		StdDraw.setFont(new Font ("Arial", Font.BOLD, 20));
		StdDraw.text(75, 85, "press mousepad to start");

		// wait for the user to start the game

		while (!StdDraw.mousePressed()) {
		}
		// game starts with snake going north
		snake.setDirection(1);

		// game is playing-- loop
		while (snake.isGameOver() == false && this.paused == false) {

			StdDraw.clear();
			grid.drawGrid();
			fruit.drawFruit();
			snake.drawSnake();
			drawScore();

			snake.changeDir();
			snake.move();


			// if a fruit is hit, snake grows and new fruit randomizes
			if (snake.snake.getFirst().x == fruit.getFruit().x && snake.snake.getFirst().y == fruit.getFruit().y) {
				snake.add(snake.snake.peekLast());
				snake.add(snake.snake.peekLast());
				snake.add(snake.snake.peekLast());
				score = score + 10;
				fruit.newFruit();
			}

			// draw eyes! must face diff ways for diff left/right/up/down
			double eyeX = snake.snake.peekFirst().getX();
			double eyeY = snake.snake.peekFirst().getY();
			snake.eyes(eyeX, eyeY);

			pauseGame();
			
			StdDraw.show(speed);

			if (snake.isGameOver()) {
				StdDraw.setPenColor(Color.black);
				StdDraw.setFont(new Font ("Arial", Font.BOLD, 20));
				StdDraw.text(75, 85, "game over yo");
				StdDraw.text(75, 75, "press mousepad to restart");
				StdDraw.show();
				while (!StdDraw.mousePressed()) {
				}
				reset();
				snake.setGameOver(false);
			}

		}

	}


	public static void main(String[] args) {
		GSnakeMain game = new GSnakeMain();
		game.play();
	}

}

