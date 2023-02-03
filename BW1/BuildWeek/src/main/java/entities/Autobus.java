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
public class Autobus extends Mezzo{

	public Autobus(Tratta tratta) {
		super(tratta);
		setCapienza(80);
	}
}
