package it.epicode.be;

public class Esercizio2 {

	public static void main(String[] args) {
		System.out.println(Moltiplica(4,5));
		System.out.println(Concatena(c,10));
		System.out.println(java.util.Arrays.toString(inserisciInArray(elenco, "nuovo elemento")));
	}
	
	//Moltiplica
	
	int a;
	int b;
	static int Moltiplica(int a, int b) {
		return a*b;
	}
	
	//Concatena
	static  String c = "Hai scelto il valore";
	
	static String Concatena(String c, int a) {
		return c + ": " + a;
	}
	 //Array
	static String[] elenco = {"1", "2", "3", "4", "5"};
	static String[] inserisciInArray(String[] elenco, String newString ) {
			String[] newArray = new String[6];
			newArray[0] = elenco[0];
			newArray[1] = elenco[1];
			newArray[2] = newString;
			newArray[3] = elenco[2];
			newArray[4] = elenco[3];
			newArray[5] = elenco[4];
			return newArray; 
				};
}
