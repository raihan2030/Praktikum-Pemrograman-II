package praktikum2.soal1;

public class Soal1Main {

	public static void main(String[] args) {
		TokoBuah buah1 = new TokoBuah("Apel", 7000, 0.4);
		double jumlahBeli = 40; 
		
		buah1.cetakInfo(jumlahBeli);
		
		TokoBuah buah2 = new TokoBuah("Mangga", 3500, 0.2);
		double jumlahBeli2 = 15;
		
		buah2.cetakInfo(jumlahBeli2);
		
		TokoBuah buah3 = new TokoBuah("Alpukat", 10000, 0.25);
		double jumlahBeli3 = 12;
		buah3.cetakInfo(jumlahBeli3);
	}

}
