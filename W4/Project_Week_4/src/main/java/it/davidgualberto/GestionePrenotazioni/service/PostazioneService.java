package it.davidgualberto.GestionePrenotazioni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.entity.Postazione;
import it.davidgualberto.GestionePrenotazioni.entity.Prenotazione;
import it.davidgualberto.GestionePrenotazioni.enums.TipoPostazione;
import it.davidgualberto.GestionePrenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository posRepo;
	
	public void insert(Postazione e) {
		posRepo.save(e);
		System.out.println("Postazione inserito con successo");
	}
	
	public Optional<Postazione> getById(int id) {
		return posRepo.findById(id);
	}
	
	public List<Postazione> trovaByTipoeCitta(String t, String c) {
		return posRepo.trovaByTipoECitta( t,  c);
	}
	
	public List<Postazione> findAll() {
		return posRepo.findAll();
	}
	
		
}
