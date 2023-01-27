package catalogo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;

import org.apache.commons.io.FileUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "getByTitolo", query="SELECT p FROM CatalogoBiblioteca p WHERE p.titolo LIKE :n")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class CatalogoBiblioteca {
		
		private static final String ENCODING = "utf-8";
		
		@Id
		@GeneratedValue
		protected int codiceISBN;
		protected String titolo;
		@Column(name="anno_pubblicazione")
		protected int anno;
		protected int numPag;
		public CatalogoBiblioteca(String titolo, int anno, int numPag) {
			this.titolo = titolo;
			this.anno = anno;
			this.numPag = numPag;
		}


}
