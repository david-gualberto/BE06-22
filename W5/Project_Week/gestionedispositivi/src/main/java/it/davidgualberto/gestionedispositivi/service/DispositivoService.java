package it.davidgualberto.gestionedispositivi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.repository.DispositivoRepo;

@Service
public class DispositivoService {
	
	@Autowired
	DispositivoRepo disRepo;
	
	public Dispositivo salva(Dispositivo d) {
		disRepo.save(d);
		System.out.println("Dispositivo inserito con successo");
		return d;
	}
	
	public Optional<Dispositivo> getById(int id) {
		return disRepo.findById(id);
	}
	
	public List<Dispositivo> findAll() {
		return disRepo.findAll();
	}
	
	public void delete(Dispositivo e) {
		disRepo.delete(e);
	}

}
