package praktikum4.soal2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Pilih jenis hewan yang ingin diinputkan:");
		System.out.println("1 = Kucing");
		System.out.println("2 = Anjing");
		System.out.print("Masukkan pilihan: ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		
		if(pilihan == 1) {
			System.out.print("Nama hewan peliharaan: ");
			String nama = scan.nextLine();
			System.out.print("Ras: ");
			String ras = scan.nextLine();
			System.out.print("Warna Bulu: ");
			String warnaBulu = scan.nextLine();
			System.out.println();
			
			Kucing kucing = new Kucing(nama, ras, warnaBulu);
			kucing.displayDetailKucing();
		}
		else if(pilihan == 2){
			System.out.print("Nama hewan peliharaan: ");
			String nama = scan.nextLine();
			System.out.print("Ras: ");
			String ras = scan.nextLine();
			System.out.print("Warna Bulu: ");
			String warnaBulu = scan.nextLine();
			System.out.print("Kemampuan: ");
			String kemampuan = scan.nextLine();
			
			String[] kemampuanArr = Arrays.stream(kemampuan.split(","))
		            						.map(String::trim)
		            						.toArray(String[]::new);
			
			System.out.println();
			
			Anjing anjing = new Anjing(nama, ras, warnaBulu, kemampuanArr);
			anjing.displayDetailAnjing();
		}
		else {
			System.out.println("Pilihan tidak valid");
		}
		
		scan.close();
	}

}
