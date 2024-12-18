package praktikum5.soal1;

public class Cylinder extends Shape{
	private double radius;
	private double height;
	
	public Cylinder(double r, double h) {
		super("Cylinder");
		this.radius = r;
		this.height = h;
	}
	
	@Override
	public double area() {
		return Math.PI * this.radius * this.radius * this.height;
	}
	
	public String toString() {
		return super.toString() + " with a radius of " + this.radius + " and a height of " + this.height;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double getHeight() {
		return this.height;
	}
}
