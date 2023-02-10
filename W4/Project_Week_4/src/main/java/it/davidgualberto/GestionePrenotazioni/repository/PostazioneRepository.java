package it.davidgualberto.GestionePrenotazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.davidgualberto.GestionePrenotazioni.entity.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM postazioni p INNER JOIN edifici e ON e.id = p.edificio_id WHERE p.tipo = :t AND e.citta = :c"
		)
		List<Postazione> trovaByTipoECitta(@Param("t") String t, @Param("c") String c);
	
}
