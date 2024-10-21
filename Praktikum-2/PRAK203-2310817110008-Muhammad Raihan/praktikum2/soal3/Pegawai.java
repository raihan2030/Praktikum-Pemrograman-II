package praktikum2.soal3;

public class Pegawai {
	public String nama;
	
	//Seharusnya atribut asal menggunakan tipe data String agar bisa digunakan di dalam method getAsal()
	//public char asal;
	public String asal;
	
	public String jabatan;
	public int umur;
	
	public String getNama() {
		return nama;
	}
	
	public String getAsal() {
		//Pada baris ini terjadi error karena atribut asal bertipe data char
		//Tipe data atribut asal akan diubah menjadi String sehingga errornya akan hilang
		return asal;
	}
	
	//Pada baris ini terjadi error karena tidak ada parameter di dalam method tersebut. Seharusnya dibuat parameter String j
	//public void setJabatan() {
	public void setJabatan(String j) {
		this.jabatan = j;
	}

}
