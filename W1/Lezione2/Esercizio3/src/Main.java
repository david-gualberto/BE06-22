
public class Main {

	public static void main(String[] args) {
		//Istanza articoli
		Articolo a1 = new Articolo(102, "penna", 10.5, 10);
		Articolo a2 = new Articolo(145, "mouse", 15.5, 8);
		Articolo a3 = new Articolo(145, "monitor", 30, 9);
		
		//Array articoli
		Articolo[] arrayPieno = new Articolo[3];
		arrayPieno[0] = a1;
		arrayPieno[1] = a2;
		arrayPieno[2] = a3;
		//istanza cliente
		Cliente c1 = new Cliente(1, "Mario Rossi", "aaa@aaa.com", "13/10/2005");
		//istanzza carrello
		Carrello carrello1 = new Carrello (c1.id, arrayPieno);
		
		//Output tot. carrello
		System.out.println("Tot: " + carrello1.totPrice);
	}	
}
