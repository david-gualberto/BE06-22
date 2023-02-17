package it.davidgualberto.gestionedispositivi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.repository.UtenteRepo;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepo utRepo;
	
	public Utente salva(Utente u) {
		utRepo.save(u);
		return u;
	}

	public Optional<Utente> getById(int id) {
		return utRepo.findById(id);
	}
	
	public List<Utente> findAll() {
		return utRepo.findAll();
	}
	
	public void delete(Utente e) {
		utRepo.delete(e);
	}
}
