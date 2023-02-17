package it.davidgualberto.gestionedispositivi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.entities.Utente;
import it.davidgualberto.gestionedispositivi.enums.StatoDispositivo;
import it.davidgualberto.gestionedispositivi.repository.DispositivoRepo;
import it.davidgualberto.gestionedispositivi.service.DispositivoService;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {

		@Autowired
		DispositivoService disServ;
		
		@Autowired
		DispositivoRepo disRep;
		
		@GetMapping
		@ResponseBody
		public ResponseEntity<List<Dispositivo>> getAll() {
			List<Dispositivo> lista =disServ.findAll();
			
			if( lista.isEmpty() ) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}
		
		@GetMapping("stato={stato}")
		@ResponseBody
		public ResponseEntity<Object> getBystato(@PathVariable String stato) {
			List<Dispositivo> disObj = disRep.trova(stato);
			if( disObj.isEmpty()) {
				return new ResponseEntity<>("DISPOSITIVI NON TROVATI",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(disObj, HttpStatus.OK);
		}
		
		@GetMapping("{id}")
		@ResponseBody
		public ResponseEntity<Object> getById(@PathVariable Integer id) {
			Optional<Dispositivo> utObj = disServ.getById(id);
			if( utObj.isEmpty()) {
				return new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(utObj, HttpStatus.OK);
		}
		
		@PostMapping("nuovo_disp")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<Object> create(@RequestBody Dispositivo d) {
			Dispositivo ut = disServ.salva(d);
			
			return new ResponseEntity<>(ut, HttpStatus.CREATED);
		}
		
		@DeleteMapping("delete/{id}")
		@ResponseBody
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<Object> delete(@PathVariable Integer id) {
			
			Optional<Dispositivo> disObj = disServ.getById(id);
			if( !disObj.isPresent() )  {
				return  new ResponseEntity<>("UTENTE NON TROVATO",HttpStatus.NOT_FOUND);
			} else {
				Dispositivo x = disObj.get();
				disServ.delete(x);
			}
			return new ResponseEntity<>(
					String.format("Dispositivo con id %d cancellato!", id), HttpStatus.OK);	
		}
		
		@PutMapping("cambia_stato_disp={DispId}stato={stato}")
		@PreAuthorize("hasRole('ADMIN')")
		ResponseEntity<Object> cambiaStato(@PathVariable Integer DispId, @PathVariable String stato) { 
			Optional<Dispositivo> disObj = disServ.getById(DispId);
			if( !disObj.isPresent()) {
				return new ResponseEntity<>("DISPOSITIVO NON TROVATO",HttpStatus.NOT_FOUND);
			} else if(disObj.isPresent()) {
				String caso = stato;
				Dispositivo x = disObj.get();
				switch(caso) {
				case "disponibile":
					x.setStato(StatoDispositivo.Disponibile);
					disServ.salva(x);
					break;
				case "in_manutenzione":
					x.setStato(StatoDispositivo.In_Manutenzione);
					disServ.salva(x);
					break;
				case "dismesso":
					x.setStato(StatoDispositivo.Dismesso);
					disServ.salva(x);
					break;
				default:
					return new ResponseEntity<>("STATO NON DISPONIBILE", HttpStatus.BAD_REQUEST);
				}
			}
			return new ResponseEntity<>(
					String.format("Lo stato del dispositivo con id %d  è stato modificato!", DispId), HttpStatus.OK);	
		}
}
