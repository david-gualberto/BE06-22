
public class Main {

	public static void main(String[] args) {
		Rettangolo r1 = new Rettangolo(4, 18);
		Rettangolo r2 = new Rettangolo(5, 21);

		r1.stampRettangolo();
		System.out.println("--------------------------");
		r2.stampRettangolo();
		System.out.println("--------------------------");
		r1.stampDueRettangoli(r2);

	}

}
