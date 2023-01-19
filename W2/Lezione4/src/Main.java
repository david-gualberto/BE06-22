import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		
			Customer c1 = new Customer(1, "Mario Rossi", 2);
			Customer c2 = new Customer(2, "Carlo Bianchi", 2);
			Customer c3 = new Customer(3, "Luigi Verdi", 1);
			
		ArrayList<Product> products = new ArrayList<>() {{
			//Books
			add(new Product(11,"Il Signore degli anelli", categoryEnum.Books,15.5));
			add(new Product(28,"Harry Potter", categoryEnum.Books,16.0));
			add(new Product(35,"I Robot e l'impero", categoryEnum.Books,102));
			add(new Product(4,"Un capitano", categoryEnum.Books,18.5));
			add(new Product(35,"I cavalieri dello zodiaco", categoryEnum.Books,120));
			//Baby
			add(new Product(7,"Triciclo", categoryEnum.Baby,25));
			add(new Product(6,"Biberon", categoryEnum.Baby,8));
			add(new Product(5,"Pallone", categoryEnum.Baby,11));
			add(new Product(1,"Bambola", categoryEnum.Baby,10));
			//Boys
			add(new Product(21,"Maglietta", categoryEnum.Boys,30));
			add(new Product(31,"Felpa", categoryEnum.Boys,50));
			add(new Product(41,"Sneakers", categoryEnum.Boys,75));
			add(new Product(70,"Jeans", categoryEnum.Boys,60));
		}};
		
			ArrayList<Product> cart1 = new ArrayList<>() {{
				add(products.get(3)); 
				add(products.get(7));
			}};
			ArrayList<Product> cart2 = new ArrayList<>() {{
				add(products.get(3)); 
				add(products.get(5));
				add(products.get(6));
				add(products.get(8));
			}};
			ArrayList<Product> cart3 = new ArrayList<>() {{
				add(products.get(4)); 
				add(products.get(1));
				add(products.get(2));
			}};
			
			ArrayList<Order> Order = new ArrayList<>() {{
				add(new Order(1, "Spedito", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 7), cart1, c1));
				add(new Order(2, "Spedito", LocalDate.of(2022, 1, 2), LocalDate.of(2022, 1, 4), cart2, c2));
				add(new Order(3, "Spedito", LocalDate.of(2019, 3, 31), LocalDate.of(2019, 4, 3), cart3, c3));
			}};

			System.out.println("---Prodotti Baby---");
			filter(categoryEnum.Baby, products);
			System.out.println("---Prodotti Boys con sconto del 10%---");
			discount(categoryEnum.Boys, products);
			System.out.println("---Libri con prezzo superiore a 100---");
			filter(categoryEnum.Books, products, 100);
			System.out.println("---");
			filterByDate(Order);
			
	}
	
			public static void filter(categoryEnum b, ArrayList<Product> x){
			Predicate<Product> categoryFilter = product -> product.getCategory() == b;
			x.stream()
				.filter( categoryFilter)
				.forEach( p -> System.out.println(p.stampProduct()));
			}
			
			//Overload
			public static void filter(categoryEnum b, ArrayList<Product> x, double price){
				Predicate<Product> categoryFilter = product -> product.getCategory() == b;
				Predicate<Product> priceFilter = product -> product.getPrice() >= price;
				x.stream()
					.filter( categoryFilter)
					.filter( priceFilter)
					.forEach( p -> System.out.println(p.stampProduct()));
				}
			//Filtraggio per categoria con aggiunta di sconto
			public static void discount(categoryEnum b, ArrayList<Product> x){
				Predicate<Product> categoryFilter = product -> product.getCategory() == b;
				x.stream()
					.filter( categoryFilter)
					.forEach( p -> {
							p.discount(10);
							System.out.println(p.stampProduct());
						});
			}	
			
			
			public static void filterByDate(ArrayList<Order> o) {
				LocalDate dataInizio = LocalDate.of(2021, 2, 1);
				LocalDate dataFine = LocalDate.of(2021, 4, 1);
				Predicate<Order> dateFilter = order -> (order.getOrderDate().isAfter(dataInizio)) && (order.getOrderDate().isBefore(dataFine));
				o.stream()
				.filter(dateFilter).
				forEach( p -> System.out.println());
			}
			
			
}



