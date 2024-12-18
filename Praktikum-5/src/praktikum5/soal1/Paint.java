package praktikum5.soal1;

public class Paint {
	private double coverage;
	
	public Paint(double c) {
		this.coverage = c;
	}
	
	public double amount(Shape s) {
		return s.area()/this.coverage;
	}
}
