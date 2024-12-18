package praktikum5.soal1;

public abstract class Shape {
	protected String shapeName;
	
	public Shape(String name) {
		this.shapeName = name;
	}
	
	protected abstract double area();
	
	public String toString() {
		return shapeName;
	}
}
