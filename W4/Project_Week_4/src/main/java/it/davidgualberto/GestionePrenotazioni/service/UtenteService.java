package it.davidgualberto.GestionePrenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.entity.Utente;
import it.davidgualberto.GestionePrenotazioni.repository.EdificioRepository;
import it.davidgualberto.GestionePrenotazioni.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utRepo;
	
	public void insert(Utente u) {
		utRepo.save(u);
		System.out.println("Utente inserito con successo");
	}
	
	public Optional<Utente> getById(int id) {
		return utRepo.findById(id);
	}
	
}


