package it.davidgualberto.GestionePrenotazioni.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.davidgualberto.GestionePrenotazioni.entity.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prenotazioni WHERE data = :d AND utente_id = :id"
		)
		List<Prenotazione> trovaByDataEid(@Param("d") LocalDate d,@Param("id") int id);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM prenotazioni WHERE postazione_id = :id AND data = :d"
		)
		List<Prenotazione> trovaByPostazione(@Param("id") int id,@Param("d") LocalDate d);
}


