

public class Main {

	public static void main(String[] args) {
		try {
			Array.genArray();
			Array.addNumber();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Indice non riconosciuto");
		} catch(NumberError e) {
		e.errorMess();
		}
	}
}
