
public class BancaException extends RuntimeException {
		public BancaException(String message) {
			super(message);
		}
	
	public void printStackTrace() {
		System.out.println("Saldo non disponibile");
	}

}
