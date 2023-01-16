import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Inserire il numero di KM");
			double km = scanner.nextDouble();
			
			if( km <1) {
				throw new ErrorMessage("Inserire un valore superiore a 0");
			}
			System.out.println("Inserire i litri consumati");
			double liter = scanner.nextDouble();
			if (liter < 1) {
				throw new ErrorMessage("Inserire un valore superiore a 0");
			}
			double operation = km/liter;
			System.out.printf("Hai percorso %.1f Km a litro", operation );
			}
		catch(NumberFormatException en) {
			System.out.println("Inserire un numero!");
			}
		catch(ArithmeticException e) {
			System.out.println("Non è possibile dividere per 0");
			} 
		catch (ErrorMessage e) {
			System.out.println(e.showMessage());
			} 
		catch(InputMismatchException e) {
			System.out.println("Inserire un numero!");	
			}
		finally {
			scanner.close();
		}
	}

}
