package pemrograman.java;

import java.util.Scanner;

public class PRAK101_2310817110008_MuhammadRaihan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Masukkan Nama Lengkap: ");
		String nama = scan.nextLine();
		System.out.print("Masukkan Tempat Lahir: ");
		String tempatLahir = scan.next();
		System.out.print("Masukkan Tanggal Lahir: ");
		int tanggalLahir = scan.nextInt();
		System.out.print("Masukkan Bulan Lahir: ");
		int bulanLahir = scan.nextInt();
		System.out.print("Masukkan Tahun Lahir: ");
		int tahunLahir = scan.nextInt();
		System.out.print("Masukkan Tinggi Badan: ");
		int tinggiBadan = scan.nextInt();
		System.out.print("Masukkan Berat Badan: ");
		float beratBadan = scan.nextFloat();
		
		String bulanLahir_str = null;
		switch(bulanLahir) {
		case 1:
			bulanLahir_str = "Januari";
			break;
		case 2:
			bulanLahir_str = "Februari";
			break;
		case 3:
			bulanLahir_str = "Maret";
			break;
		case 4:
			bulanLahir_str = "April";
			break;
		case 5:
			bulanLahir_str = "Mei";
			break;
		case 6:
			bulanLahir_str = "Juni";
			break;
		case 7:
			bulanLahir_str = "Juli";
			break;
		case 8:
			bulanLahir_str = "Agustus";
			break;
		case 9:
			bulanLahir_str = "September";
			break;
		case 10:
			bulanLahir_str = "Oktober";
			break;
		case 11:
			bulanLahir_str = "November";
			break;
		case 12:
			bulanLahir_str = "Desember";
			break;
		default:
			break;
		}
		
		System.out.printf("\nNama Lengkap %s, Lahir di %s pada Tanggal %d %s %d\n", nama, tempatLahir, tanggalLahir, bulanLahir_str, tahunLahir);
		System.out.printf("Tinggi Badan %d cm dan Berat Badan %.2f kilogram", tinggiBadan, beratBadan);
		
		scan.close();
	}

}
