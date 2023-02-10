package it.davidgualberto.GestionePrenotazioni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {
	
	@Autowired
	private EdificioRepository edRepo;
	
	public void insert(Edificio e) {
		edRepo.save(e);
		System.out.println("Edifico inserito con successo");
	}
	
	public Optional<Edificio> getById(int id) {
		return edRepo.findById(id);
	}
	
	public List<Edificio> findAll() {
		return edRepo.findAll();
	}
	
	
}
