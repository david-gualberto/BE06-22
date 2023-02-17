package it.davidgualberto.gestionedispositivi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.davidgualberto.gestionedispositivi.entities.Dispositivo;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo, Integer> {
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM dispositivi WHERE stato_dispositivo = :s"
		)
		List<Dispositivo> trova(@Param("s") String s);
}
