
public class NumberError extends RuntimeException {
		private int number;
		
		public NumberError(String s) {
			super(s);
		}
		
		public void errorMess() {
			System.err.println("Il valore inserito non rispetta i parametri richiesti");
		}
}
