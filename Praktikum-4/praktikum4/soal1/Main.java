package praktikum4.soal1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nama Hewan Peliharaan: ");
		String nama = scan.nextLine();
		System.out.print("Ras: ");
		String ras = scan.nextLine();
		System.out.println();
		
		HewanPeliharaan hewan1 = new HewanPeliharaan(nama, ras);
		hewan1.display();
		
		scan.close();
	}

}
