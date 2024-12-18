package praktikum5.soal1;

public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double l, double w) {
		super("Rectangle");
		this.length = l;
		this.width = w;
	}

	@Override
	public double area() {
		return this.length * this.width;
	}
	
	public String toString() {
		return super.toString() + " with a length of " + this.length + " and a width of " + this.width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
}
