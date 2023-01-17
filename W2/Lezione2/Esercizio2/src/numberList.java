import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class numberList {
	
	static String evenOdd;
	static List<Integer> numbers = new ArrayList<>();
	
	
	public static void genArray(int x, boolean b) {
		for (int i = 0; i < x; i++) {
			int numRandom = (int) (Math.random() * 100);
			numbers.add(i, numRandom);
			}
		System.out.println("Numeri generati: " + numbers);
		newArray(numbers, b);
		
	} 
	
	public static void newArray(List<Integer> a, boolean b ) {
		List<Integer> reverseNum = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			reverseNum.add(a.get(i));
		}
		Collections.reverse(a);
		for (int i = 0; i <a.size(); i++) {
			reverseNum.add(a.get(i));
		}
		System.out.println("Nuovo Array: " + reverseNum);
		oddEven(reverseNum, b);
		
	}
	
	public static void oddEven(List<Integer> a, boolean b) {
		List<Integer> evenOddNum = new ArrayList<>();
		if (b == true) {
			for (int i = 0; i < a.size(); i+=2) {
				evenOddNum.add(a.get(i));
				evenOdd = "pari";
				
			}
		} else {
			for (int i = 1; i<a.size(); i+=2) {
				evenOddNum.add(a.get(i));
				evenOdd = "dispari";
			}
		}
		System.out.printf("I numeri in posizione %s sono: ", evenOdd);
		System.out.println(evenOddNum);
	}
}
