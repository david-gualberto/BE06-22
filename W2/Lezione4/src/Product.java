
public class Product {
	private long id;
	private String name;
	private categoryEnum category;
	private double price;
	
	public Product(long id, String name, categoryEnum category, double price) {
		this.id = id;
		this.name= name;
		this.category= category;
		this.price = price;
	}
	
	public categoryEnum getCategory() {
		return this.category;
	}
	
	public String stampProduct() {
		String detailsProduct = "Prodotto: " + this.name + ",  " + "Categoria: " +  this.category + ",  " + "Prezzo: "  + this.price;
		return detailsProduct;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void discount(double x) {
		 this.price = (getPrice()- (getPrice()*x/100));
		 
	}
	
}
