package evento;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="locations")
@ToString
@Getter
@Setter
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String Nome;
	String Citta;
}
