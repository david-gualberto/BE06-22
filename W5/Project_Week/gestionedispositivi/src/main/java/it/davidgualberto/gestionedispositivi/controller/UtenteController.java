package it.davidgualberto.gestionedispositivi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.enums.RuoloUtente;
import it.davidgualberto.gestionedispositivi.enums.StatoDispositivo;
import it.davidgualberto.gestionedispositivi.service.DispositivoService;
import it.davidgualberto.gestionedispositivi.service.UtenteService;
@Controller
@RequestMapping("/utente")
public class UtenteController {
	
	@Autowired
	UtenteService utServ;
	@Autowired
	DispositivoService disServ;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Utente>> getAll() {
		List<Utente> lista = utServ.findAll();
		
		if( lista.isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<Object> getById(@PathVariable Integer id) {
		Optional<Utente> utObj = utServ.getById(id);
		if( utObj.isEmpty()) {
			return new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(utObj, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		
		Optional<Utente> utObj = utServ.getById(id);
		if( !utObj.isPresent() )  {
			return  new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
		} else {
			Utente x = utObj.get();
			utServ.delete(x);
		}
		return new ResponseEntity<>(
				String.format("Utente con id %d cancellato!", id), HttpStatus.OK);	
	}
	
	@PostMapping("nuovo_utente")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> create(@RequestBody Utente u) {
		Utente ut = utServ.salva(u);
		
		return new ResponseEntity<>(ut, HttpStatus.CREATED);
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "login success";
	}
	
	@PutMapping("assegna_disp={DispId}utente={UtenteId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> assegnaDisp(@PathVariable Integer DispId, @PathVariable Integer UtenteId) {
		Optional<Utente> utObj = utServ.getById(UtenteId);
		Optional<Dispositivo> disObj = disServ.getById(DispId);
		Utente u = utObj.get();
		if( !disObj.isPresent()) {
			return new ResponseEntity<>("Dispositivo Non Trovato",HttpStatus.NOT_FOUND);
		}  else {
			Dispositivo x = disObj.get();
			if(x.getStato().toString() == "Assegnato" | x.getStato().toString() == "In_Manutenzione" | x.getStato().toString() == "Dismesso") 
			{
			return new ResponseEntity<>("Dispositivo Non Disponibile",HttpStatus.BAD_REQUEST);}
			u.setDisp(x);
			utServ.salva(u);
			x.setStato(StatoDispositivo.Assegnato);
			disServ.salva(x);
			return new ResponseEntity<>(u, HttpStatus.CREATED);
		}
	}
	
	@PutMapping("riconsegnare_dispositivo{Dispid}_utente{Utenteid}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> riconsegnaDisp(@PathVariable Integer Dispid,@PathVariable Integer Utenteid) {
		Optional<Utente> utObj = utServ.getById(Utenteid);
		Optional<Dispositivo> disObj = disServ.getById(Dispid);
		if (!utObj.isPresent()) {
			return  new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
		} else if (!disObj.isPresent()) {
			return  new ResponseEntity<>("DISPOSITIVO NON TROVATO",HttpStatus.NOT_FOUND);
		} else {
			Utente x = utObj.get();
			Dispositivo y = disObj.get();
			if (!x.getDispositivi().contains(y)) {
				return new ResponseEntity<>("DISPOSITIVO NON TROVATO NELLA LISTA DEI DISPOSITIVI DELL'UTENTE",HttpStatus.NOT_FOUND);
			}
			x.getDispositivi().remove(y);
			utServ.salva(x);
			y.setStato(StatoDispositivo.Disponibile);
			disServ.salva(y);
			return new ResponseEntity<>("DISPOSITIVO RESTITUITO E RESONUOVAMENTE DISPONIBILE",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("modifica_utente{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> modificaUt(@PathVariable Integer id, @RequestBody Utente u) {
		Optional<Utente> utObj = utServ.getById(id);
		if (!utObj.isPresent()) {
			return  new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
		} else {
			Utente x = utObj.get();
			x.setNome(u.getNome());
			x.setCognome(u.getCognome());
			x.setUsername(u.getUsername());
			x.setPassword(u.getPassword());
			x.setEmail(u.getEmail());
			x.setRuolo(u.getRuolo());
			utServ.salva(x);
			return  new ResponseEntity<>("UTENTE MODIFICATO",HttpStatus.OK);
		}
	}
	
	@PatchMapping("modifica_ruolo_utente={id}_ruolo={ruolo}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> modificaruolo(@PathVariable Integer id, @PathVariable String ruolo) {
		Optional<Utente> utObj = utServ.getById(id);
		if (!utObj.isPresent()) {
			return  new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
		} else {
			Utente x = utObj.get();
			String nuovoRuolo = ruolo;
			switch (nuovoRuolo) {
			case "admin":
				x.setRuolo(RuoloUtente.ADMIN);
				utServ.salva(x);
				break;
			case "user":
				x.setRuolo(RuoloUtente.USER);
				utServ.salva(x);
				break;
			default:
				return  new ResponseEntity<>("RUOLO NON ESISTENTE",HttpStatus.NOT_FOUND);
			}	
			return  new ResponseEntity<>("RUOLO MODIFICATO",HttpStatus.OK);
		}
	}
}
