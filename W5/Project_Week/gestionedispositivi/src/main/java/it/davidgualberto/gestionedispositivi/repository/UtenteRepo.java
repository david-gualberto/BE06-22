package it.davidgualberto.gestionedispositivi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.davidgualberto.gestionedispositivi.entities.Dispositivo;
import it.davidgualberto.gestionedispositivi.entities.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Integer> {
}
