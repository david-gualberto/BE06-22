import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static HashMap<String, String> ContactPhone = new HashMap<>();
	static boolean x = true;
	public static void main(String[] args) {
		
		ContactPhone.put("Luca", "651651156651");
		ContactPhone.put("Lorenzo", "651651156651");
		ContactPhone.put("Maria", "651651156651");
		ContactPhone.put("Paolo", "651651156651");
		ContactPhone.put("Frank", "651651156651");
		
		Contact.addContact("Ilaria", "154651894", ContactPhone);
		Contact.deleteContact("Maria", ContactPhone);
		Contact.searchContact("Ilaria", ContactPhone);
		System.out.println("------------");
		for( String nome : ContactPhone.keySet() ) {
			System.out.println("Nome: "+  nome + " - " + "Numero: "+ ContactPhone.get(nome) );
		}
	}
	
	
}
