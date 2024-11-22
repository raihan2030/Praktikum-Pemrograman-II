package praktikum3.soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
		int pilihan;
		
		do {
			System.out.println("Menu:");
			System.out.println("1. Tambah Mahasiswa");
			System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
			System.out.println("3. Cari Mahasiswa berdasarkan NIM");
			System.out.println("4. Tampilkan Daftar Mahasiswa");
			System.out.println("0. Keluar");
			System.out.print("Pilihan: ");
			pilihan = scan.nextInt();
			scan.nextLine();
			
			switch (pilihan) {
			case 1: {
				System.out.print("Masukkan Nama Mahasiswa: ");
				String nama = scan.nextLine();
				String nim;
				
				boolean unik;
				do {
					unik = true;
					System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
					nim = scan.next();
					for(Mahasiswa mhs : daftarMahasiswa) {
						if(mhs.getNim().equals(nim)) {
							unik = false;
							System.out.println("NIM sudah ada");
							break;
						}
					}
				} while(!unik);
				
				daftarMahasiswa.add(new Mahasiswa(nama, nim));
				System.out.println("Mahasiswa " + nama + " ditambahkan.\n");
				break;
			}
			
			case 2: {
				System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
				String nim = scan.next();
				boolean ketemu = false;
				
				for(int i = 0; i < daftarMahasiswa.size(); i++) {
					if(daftarMahasiswa.get(i).getNim().equals(nim)) {
						ketemu = true;
						daftarMahasiswa.remove(i);
						break;
					}
				}
				
				if(ketemu) {
					System.out.println("Mahasiswa dengan NIM " + nim + " dihapus.\n");
				}
				else {
					System.out.println("Data Mahasiswa tidak ditemukan.\n");
				}
				break;
			}
			
			case 3: {
				System.out.print("Masukkan NIM Mahasiswa yang ingin dicari: ");
				String nim = scan.next();
				
				boolean ketemu = false;
				for(Mahasiswa mhs : daftarMahasiswa) {
					if(mhs.getNim().equals(nim)) {
						ketemu = true;
						System.out.println("Data Mahasiswa:");
						System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama() + "\n");
						break;
					}
				}
				
				if(!ketemu) {
					System.out.println("Data Mahasiswa tidak ditemukan.\n");
				}
				
				break;
			}
			
			case 4: {
				System.out.println("Daftar Mahasiswa:");
				for(Mahasiswa mhs : daftarMahasiswa) {
					System.out.println("NIM: " + mhs.getNim() + ", Nama: " + mhs.getNama());
				}
				System.out.println();
				break;
			}
			
			case 0:{
				System.out.println("Terima kasih sudah menggunakan program ini.\n");
				break;
			}
			
			default:
				System.out.println("Pilihan tidak valid\n");
				break;
			}
			
		} while(pilihan != 0);
		
		scan.close();
	}

}