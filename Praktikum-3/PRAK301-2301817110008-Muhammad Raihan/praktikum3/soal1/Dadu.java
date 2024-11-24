package praktikum3.soal1;

import java.util.Random;

public class Dadu {
	private int angkaDadu;
	
	public Dadu() {
		this.angkaDadu = acakNilai();
	}
	
	private int acakNilai() {
		Random rand = new Random();
		int max = 6;
		int min = 1;
		int hasil = rand.nextInt(max - min + 1) + min;
		return hasil;
	}
	
	public int getAngkaDadu() {
		return this.angkaDadu;
	}
}
