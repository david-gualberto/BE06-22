
public class Main {

	public static void main(String[] args) {
		
		ClassThread ct1 = new ClassThread("*");
		ClassThread ct2 = new ClassThread("#");
		
		ct1.start();
		//Nel caso si volesse attendere il completamento del primo thread prima di far partire il secondo
		// ct1.join(); 
		ct2.start();
	}
			
}
