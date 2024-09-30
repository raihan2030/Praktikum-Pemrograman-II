package pemrograman.java;

import java.util.Scanner;

public class PRAK102_2310817110008_MuhammadRaihan {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int batas = n + 10;
		
		while(n <= batas) {
			int bilangan = n;
			if(bilangan % 5 == 0) {
				bilangan = bilangan / 5 - 1;
			}
			System.out.print(bilangan);
			if(n != batas) System.out.print(',');
			n++;
		}
		
		scan.close();
	}
}
