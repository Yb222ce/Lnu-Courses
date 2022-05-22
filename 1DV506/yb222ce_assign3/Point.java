package yb222ce_assign3;

public class Point {
	private int x = 0;
	private int y = 0;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void setX(int x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public double getDistance(Point point) {
		return Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
	}

	public String toString() {
		String x = Integer.toString(this.x);
		String y = Integer.toString(this.y);

		return ("(" + x + "," + y + ")");

	}

	public void moveToXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public boolean isEqualTo(Point point) {
		return this.x == point.x && this.y == point.y;

	}

	
}
