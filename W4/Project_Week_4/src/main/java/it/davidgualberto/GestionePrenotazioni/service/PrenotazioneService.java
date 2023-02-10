package it.davidgualberto.GestionePrenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.davidgualberto.GestionePrenotazioni.entity.Edificio;
import it.davidgualberto.GestionePrenotazioni.entity.Prenotazione;
import it.davidgualberto.GestionePrenotazioni.entity.Utente;
import it.davidgualberto.GestionePrenotazioni.repository.PostazioneRepository;
import it.davidgualberto.GestionePrenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	@Autowired
	private PrenotazioneRepository prRepo;
	
	public void insert(Prenotazione e) {
		if (prRepo.trovaByDataEid(e.getData(), e.getUtente().getId()).size() > 0) {
			System.out.println("Hai già una prenotazione per il " + e.getData());
		} else if (prRepo.trovaByPostazione(e.getPostazione().getId(), e.getData()).size() > 0){
			System.out.println("Postazione non disponibile per la data richiesta");
		}
		else {
			prRepo.save(e);
			System.out.println("Prenotazione inserita con successo");};
	}
	
	public Optional<Prenotazione> getById(int id) {
		return prRepo.findById(id);
	}
	
	

}
