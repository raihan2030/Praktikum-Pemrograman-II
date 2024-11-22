package praktikum3.soal2;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		LinkedList<Negara> daftarNegara = new LinkedList<Negara>();
		
		int jumlahNegara = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < jumlahNegara; i++) {
			String namaNegara = scan.nextLine();
			String jenisKepemimpinan = scan.nextLine();
			String namaPemimpin = scan.nextLine();
			
			int tanggalMerdeka = 0;
			int bulanMerdeka = 0;
			int tahunMerdeka = 0;
			if(!(jenisKepemimpinan.equalsIgnoreCase("monarki"))) {
				tanggalMerdeka = scan.nextInt();
				bulanMerdeka = scan.nextInt();
				tahunMerdeka = scan.nextInt();
				scan.nextLine();
			}
			
			if(jenisKepemimpinan.equalsIgnoreCase("monarki")) {
				daftarNegara.add(new Negara(namaNegara, jenisKepemimpinan, namaPemimpin));
			}
			else {
				daftarNegara.add(new Negara(namaNegara, jenisKepemimpinan, namaPemimpin, tanggalMerdeka, bulanMerdeka, tahunMerdeka));
			}
		}
		System.out.println();
		
		for(int i = 0; i < jumlahNegara; i++) {
			daftarNegara.get(i).tampilkanDetail();
			System.out.println();
		}
		
		scan.close();
	}

}
