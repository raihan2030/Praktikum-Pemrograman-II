package praktikum2.soal2;

public class Kopi {
	String namaKopi;
	String ukuran;
	String pembeli;
	double harga;
	
	public void setPembeli(String pembeli) {
		this.pembeli = pembeli;
	}
	
	public double getPajak() {
		double pajak = harga * 11/100;
		return pajak;
	}
	
	public String getPembeli() {
		return pembeli;
	}
	
	public void info() {
		System.out.println("Nama Kopi: " + namaKopi);
		System.out.println("Ukuran: " + ukuran);
		System.out.println("Harga: Rp. " + harga);
	}
}
