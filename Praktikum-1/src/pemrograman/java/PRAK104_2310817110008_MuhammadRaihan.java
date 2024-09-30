package pemrograman.java;

import java.util.Scanner;

public class PRAK104_2310817110008_MuhammadRaihan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char[] tanganAbu = new char[3];
		char[] tanganBagas = new char[3];
		
		System.out.print("Tangan Abu: ");
		for(int i = 0; i < 3; i++) {
			tanganAbu[i] = scan.next().charAt(0);
		}
		System.out.print("Tangan Bagas: ");
		for(int i = 0; i < 3; i++) {
			tanganBagas[i] = scan.next().charAt(0);
		}
		
		int nilaiAbu = 0;
		int nilaiBagas = 0;
		for(int i = 0; i < 3; i++) {
			if(tanganAbu[i] == 'G') {
				if(tanganBagas[i] == 'B') {
					nilaiBagas++;
				}
				else if(tanganBagas[i] == 'K') {
					nilaiAbu++;
				}
			}
			else if(tanganAbu[i] == 'B') {
				if(tanganBagas[i] == 'K') {
					nilaiBagas++;
				}
				else if(tanganBagas[i] == 'G') {
					nilaiAbu++;
				}
			}
			else if(tanganAbu[i] == 'K') {
				if(tanganBagas[i] == 'G') {
					nilaiBagas++;
				}
				else if(tanganBagas[i] == 'B') {
					nilaiAbu++;
				}
			}
		}
		
		if(nilaiBagas > nilaiAbu) {
			System.out.println("Bagas");
		}
		else if(nilaiAbu > nilaiBagas) {
			System.out.println("Abu");
		}
		else {
			System.out.println("Seri");
		}
		
		scan.close();
	}

}
