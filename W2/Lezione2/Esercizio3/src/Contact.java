import java.util.HashMap;

public class Contact {

		
		public static void addContact(String n, String t, HashMap<String, String> r) {
			r.put(n, t);
		}
		
		public static void deleteContact(String n, HashMap<String, String> r) {
			r.remove(n);
		}
		
		public static void searchContact(String n, HashMap<String, String> r) {
			String user = r.get(n);
			System.out.printf("Nome: %s - Numero: %s%n", n, user );
		}
}
