package pemrograman.java;

import java.util.Scanner;

public class PRAK105_2310817110008_MuhammadRaihan {

	static final float phi = 3.14f;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukkan jari-jari: ");
		float r = scan.nextFloat();
		System.out.print("Masukkan tinggi: ");
		float t = scan.nextFloat();
		
		float volumeTabung = phi * r * r * t;
		
		System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f cm3.\n", r, t, volumeTabung);
		
		scan.close();
	}

}
