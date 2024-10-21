package praktikum2.soal3;

public class Soal3Main {

	public static void main(String[] args) {
		Pegawai p1 = new Pegawai();
		//Pada baris ini terjadi error karena tidak ada titik koma (;)
		//p1.nama = "Roi"
		p1.nama = "Roi";
		
		//Pada baris ini terjadi error karena atribut asal di Class Pegawai bertipe data char, seharusnya pakai string
		//Tipe data atribut asal akan diubah menjadi String di Class Pegawai sehingga errornya akan hilang 
		p1.asal = "Kingdom of Orvel";
		
		//Pada baris ini terjadi error karena method setJabatan tidak menerima argument dikarenakan pada Class Pegawai tidak di set parameternya
		//Parameter String akan ditambahkan di method setJabatan di Class Pegawai sehingga errornya akan hilang
		p1.setJabatan("Assasin");
		
		//Ini adalah baris untuk pengisian atribut umur menjadi 17
		p1.umur = 17;
		
		System.out.println("Nama Pegawai: " + p1.getNama());
		System.out.println("Asal: " + p1.getAsal());
		System.out.println("Jabatan: " + p1.jabatan);
		
		//Pada baris ini tidak akan mencetak atribut umur 17 tahun seperti yang diminta karena tidak ada baris yang melakukan pengisian atribut ini
		//Selain itu seharusnya ditambahkan juga string " tahun" setelah mencetak atribut umur
		//System.out.println("Umur: " + p1.umur);
		System.out.println("Umur: " + p1.umur + " tahun");
	}

}
