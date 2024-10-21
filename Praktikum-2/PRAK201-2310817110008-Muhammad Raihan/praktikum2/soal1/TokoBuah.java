package praktikum2.soal1;

public class TokoBuah {
	private String buah;
	private double harga;
	private double berat;
	
	public TokoBuah(String buah, double harga, double berat) {
		this.buah = buah;
		this.harga = harga;
		this.berat = berat;
	}
	
	public String getBuah() {
		return buah;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public double getBerat() {
		return berat;
	}
	
	public double hitungTotalHarga(double jumlahBeli) {
		double totalHarga = jumlahBeli / berat * harga;
		return totalHarga;
	}
	
	public double hitungDiskon(double jumlahBeli) {
		double jumlah = jumlahBeli - (jumlahBeli % 4);
		double diskon = jumlah * 0.02 * harga;
		return diskon;
	}
	
	public double hitungHargaSetelahDiskon(double jumlahBeli) {
		double totalHarga = hitungTotalHarga(jumlahBeli) - hitungDiskon(jumlahBeli);
		return totalHarga;
	}
	
	public void cetakInfo(double jumlahBeli) {
		System.out.println("Nama Buah: " + getBuah());
		System.out.println("Berat: " + getHarga());
		System.out.println("Harga: " + getBerat());
		System.out.println("Jumlah Beli: " + jumlahBeli);
		System.out.printf("Harga Sebelum Diskon: Rp%.2f \n", hitungTotalHarga(jumlahBeli));
		System.out.printf("Total Diskon: Rp%.2f \n", hitungDiskon(jumlahBeli));
		System.out.printf("Harga Setelah Diskon: Rp%.2f \n\n", hitungHargaSetelahDiskon(jumlahBeli));
	}
}
