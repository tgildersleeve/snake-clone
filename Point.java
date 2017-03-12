package snakeySnake;

public class Point {

	/**
	 * instance variables
	 */
	int x;
	int y;

	/**
	 * constructor
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * getter
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * setter
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getter
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * setter
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * textual description of object
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * method, subtract points to make vector
	 * @param in
	 * @return
	 */
	public Vector minus(Point in) {
		return new Vector(x-in.x, y-in.y);
	}

	/**
	 * distance between points
	 * @param in
	 * @return
	 */
	public double distance(Point in) {
		return Math.sqrt(Math.pow(x-in.x, 2) + Math.pow((y - in.y),2));

	}


}
