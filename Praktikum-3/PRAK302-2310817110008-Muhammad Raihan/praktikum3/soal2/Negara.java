package praktikum3.soal2;

import java.util.HashMap;

public class Negara {
	private String namaNegara;
	private String jenisKepemimpinan;
	private String namaPemimpin;
	private int tanggalKemerdekaan;
	private int bulanKemerdekaan;
	private int tahunKemerdekaan;
	
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalMerdeka, int bulanMerdeka, int tahunMerdeka) {
		this.namaNegara = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
		
		if(tanggalMerdeka >= 1 && tanggalMerdeka <= 31) {
			this.tanggalKemerdekaan = tanggalMerdeka;
		}
		else {
			System.out.println("Tanggal hanya boleh dalam rentang 1-31");
			this.tanggalKemerdekaan = 0;
		}
		
		if(bulanMerdeka >= 1 && bulanMerdeka <= 12) {
			this.bulanKemerdekaan = bulanMerdeka;
		}
		else {
			System.out.println("Bulan hanya boleh dalam rentang 1-12");
			this.bulanKemerdekaan = 0;
		}
		
		if(tahunMerdeka >= 1) {
			this.tahunKemerdekaan = tahunMerdeka;
		}
		else {
			System.out.println("Tahun tidak boleh negatif");
			this.tahunKemerdekaan = 0;
		}
		
	}
	
	public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
		this.namaNegara = nama;
		this.jenisKepemimpinan = jenisKepemimpinan;
		this.namaPemimpin = namaPemimpin;
		this.tanggalKemerdekaan = 0;
		this.bulanKemerdekaan = 0;
		this.tahunKemerdekaan = 0;
	}
	
	public String getJenisPemimpin() {
		if(this.jenisKepemimpinan.equalsIgnoreCase("monarki")) {
			return "Raja";
		}
		else if(this.jenisKepemimpinan.equalsIgnoreCase("perdana menteri")) {
			return "Perdana Menteri";
		}
		else if(this.jenisKepemimpinan.equalsIgnoreCase("presiden")){
			return "Presiden";
		}
		else {
			return "Pemimpin";
		}
	}
	
	public void tampilkanDetail() {
		HashMap<Integer, String> namaBulan = new HashMap<Integer, String>();
		namaBulan.put(1, "Januari");
		namaBulan.put(2, "Februari");
		namaBulan.put(3, "Maret");
		namaBulan.put(4, "April");
		namaBulan.put(5, "Mei");
		namaBulan.put(6, "Juni");
		namaBulan.put(7, "Juli");
		namaBulan.put(8, "Agustus");
		namaBulan.put(9, "September");
		namaBulan.put(10, "Oktober");
		namaBulan.put(11, "November");
		namaBulan.put(12, "Desember");
		
		System.out.println("Negara " + this.namaNegara + " mempunyai " + getJenisPemimpin() + " bernama " + this.namaPemimpin);
		if(!(this.jenisKepemimpinan.equalsIgnoreCase("monarki"))) {
			System.out.println("Deklarasi Kemerdekaan pada Tanggal " + this.tanggalKemerdekaan + " " + namaBulan.get(this.bulanKemerdekaan) + " " + this.tahunKemerdekaan);
		}
		
	}
}
