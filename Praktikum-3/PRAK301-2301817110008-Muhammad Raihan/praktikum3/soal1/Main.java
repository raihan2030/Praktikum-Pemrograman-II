package praktikum3.soal1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int jumlahDadu = scan.nextInt();
		int totalNilai = 0;
		
		for(int i = 0; i < jumlahDadu; i++) {
			Dadu dadu1 = new Dadu();
			System.out.printf("Dadu ke-%d bernilai %d\n", i+1, dadu1.getAngkaDadu());
			totalNilai += dadu1.getAngkaDadu();
		}
		
		System.out.println("Total nilai dadu keseluruhan " + totalNilai);
		
		scan.close();
	}

}
