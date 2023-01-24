package app;
import java.time.LocalDate;
import dao.metodi;
import evento.tipo;

public class Main {

	public static void main(String[] args) {
		
		//metodi.save("Festa di laurea", LocalDate.parse("2023-04-21"),"Laurea Marco", tipo.Pubblico, 100);
		metodi.delete(3);
	}

}
