package praktikum5.soal1;

import java.text.DecimalFormat;

public class PaintThings {

	public static void main(String[] args) {
		
		final double COVERAGE = 350;
		Paint paint = new Paint(COVERAGE);
		Rectangle deck;
		Sphere bigBall;
		Cylinder tank;
		double deckAmt, ballAmt, tankAmt;

		deck = new Rectangle(20, 30);
		bigBall = new Sphere(15);
		tank = new Cylinder(10, 30);
		
		System.out.println("Computing amount for Rectangle of length " + deck.getLength() + " and width " + deck.getWidth());
		deckAmt = paint.amount(deck);
		
		System.out.println("Computing amount for Sphere of radius " + bigBall.getRadius());
		ballAmt = paint.amount(bigBall);
		
		System.out.println("Computing amount for Cylinder of radius " + tank.getRadius() + " and height " + tank.getHeight());
		tankAmt = paint.amount(tank);

		DecimalFormat fmt = new DecimalFormat("0.#");
		System.out.println ("\nNumber of gallons of paint needed...");
		System.out.println ("Deck " + fmt.format(deckAmt));
		System.out.println ("Big Ball " + fmt.format(ballAmt));
		System.out.println ("Tank " + fmt.format(tankAmt));
		
	}

}
