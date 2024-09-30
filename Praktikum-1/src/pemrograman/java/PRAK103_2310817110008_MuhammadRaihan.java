package pemrograman.java;

import java.util.Scanner;

public class PRAK103_2310817110008_MuhammadRaihan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int bilAwal = scan.nextInt();
		int i = 0;
		do {
			if(bilAwal % 2 == 1) {
				System.out.print(bilAwal);
				if(i != n-1) System.out.print(",");
				i++;
			}
			bilAwal++;
		} while(i < n);
		
		scan.close();
	}

}
