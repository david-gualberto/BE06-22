
public class Carrello {
			int idCli;
			Articolo[] articoli;
			double totPrice;
			
			public Carrello(int idCli, Articolo[] articoli) {
				this.idCli = idCli;
				this.articoli = articoli;
				this.totPrice = totPrice();
				}
				//Metodo Tot prezzo carrello
				double totPrice() {
				int i;
				double tot = 0;
				
				for( i=0 ; i < this.articoli.length; i++) {
					tot += articoli[i].price;
				}
				return tot;
				}
			
		}
		
	

