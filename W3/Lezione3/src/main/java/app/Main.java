package app;
import java.time.LocalDate;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import evento.tipo;

public class Main {

	public static void main(String[] args) {

		//LocationDAO.saveLocation("Stadio Olimpico", "Roma");
		//EventoDAO.saveEvento("Partita Serie A TIM", LocalDate.parse("2023-03-15"), "Lazio - Roma", tipo.Pubblico, 80000, LocationDAO.getLocationById(2));
		//PersonaDAO.savePersona("Luca", "Monteverde", "monte@gmail.com", "m", LocalDate.parse("1989-01-26"));
		PartecipazioneDAO.savePartecipazione(PersonaDAO.getPersonaById(2), EventoDAO.getById(6));
}
}
