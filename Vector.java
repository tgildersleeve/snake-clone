package snakeySnake;

public class Vector {

	/**
	 * instance variables
	 */
	private double deltaX, deltaY; 

	/**
	 * constructor
	 * @param deltaX
	 * @param deltaY
	 */
	public Vector(double deltaX, double deltaY) {
		super();
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	/**
	 * textual description of object
	 */
	public String toString() { // part 5
		return "(" + deltaX + ", " + deltaY + ")";
	}

	/**
	 * getter
	 * @return
	 */
	public double getDeltaX() {
		return deltaX;
	}

	/**
	 * setter
	 * @param deltaX
	 */
	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}

	/**
	 * getter
	 * @return
	 */
	public double getDeltaY() {
		return deltaY;
	}

	/**
	 * setter
	 * @param deltaY
	 */
	public void setDeltaY(double deltaY) {
		this.deltaY = deltaY;
	}

	/**
	 * method to find magnitude of vector
	 * @return
	 */
	public double magnitude() {
		return Math.sqrt( deltaX*deltaX +deltaY*deltaY );
	}

	/**
	 * method to deflect deltaX
	 * @return
	 */
	public Vector deflectX() { 
		if (this.deltaX > 0) {
			return new Vector(this.deltaX*(-1), this.deltaY);
		}
		else {
			return new Vector(Math.abs(this.deltaX), this.deltaY);
		}
	}

	/**
	 * method to deflect deltaY
	 * @return
	 */
	public Vector deflectY() {
		if (this.deltaY > 0) {
			return new Vector(this.deltaX, this.deltaY*(-1));
		}
		else {
			return new Vector(this.deltaX, Math.abs(this.deltaY));
		}
	}

	/**
	 * method to add vectors
	 * @param in
	 * @return
	 */
	public Vector plus(Vector in) { 
		return new Vector(this.deltaX + in.deltaX, this.deltaY + in.deltaY);
	}

	/**
	 * method to subtract vectors
	 * @param in
	 * @return
	 */
	public Vector minus(Vector in) {
		return new Vector(this.deltaX - in.deltaX, this.deltaY - in.deltaY);
	}

	/**
	 * method to scale vector
	 * @param factor
	 * @return
	 */
	public Vector scale(double factor) {
		return new Vector(this.deltaX*factor, this.deltaY*factor);
	}


	/**
	 * method to scale vector based on input magnitude
	 * @param magnitude
	 * @return
	 */
	public Vector rescale(double magnitude) {
		if (this.magnitude() == 0){
			return new Vector(magnitude, 0);
		}
		else {
			double currentMag = this.magnitude();
			return scale(magnitude/currentMag);
		}
	}
}
