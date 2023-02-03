package entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tram extends Mezzo{

	public Tram(Tratta tratta) {
		super(tratta);
		setCapienza(150);
	}
	
}
