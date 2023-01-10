
public class Rettangolo {
	// Variabili
	double height;
	double lenght;

	// Costruttore
	public Rettangolo(double height, double lenght) {
		this.height = height;
		this.lenght = lenght;
	}

	// Perimetro
	double perimeter() {
		return ((this.height * 2) + (this.lenght * 2));
	}

	// Area
	double area() {
		return (this.height * this.lenght);
	}

	// Output Rettangolo
	void stampRettangolo() {
		System.out.println("Il perimetro del rettangolo è: " + perimeter());
		System.out.println("L'area del rettangolo è: " + area());
	}

	// Output Rettangolo1 + Rettangolo2
	void stampDueRettangoli(Rettangolo y) {
		stampRettangolo();
		System.out.println("--------------------------");
		System.out.println("Il perimetro del secondo rettangolo è:" + y.perimeter());
		System.out.println("L'area del secondo rettangolo è:" + y.area());
		System.out.println("--------------------------");
		System.out.println("La somma dei due perimetri è: " + (perimeter() + y.perimeter()));
		System.out.println("La somma delle due aree è: " + (area() + y.area()));

	}

}
