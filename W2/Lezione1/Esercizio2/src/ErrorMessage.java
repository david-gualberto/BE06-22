
public class ErrorMessage extends RuntimeException {
	String message;
	
	public ErrorMessage(String message) {
		super(message);
		this.message = message;
	}
	
	public String showMessage() {
		return this.message;
	}
}
