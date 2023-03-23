
public class Catalog {
	private Product [] listOfAllProducts;

	public Product [] getListOfAllProducts() {
		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName("Product 1");
		product1.setProductCost("1000");
		
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("Product 2");
		product2.setProductCost("2000");
		
		Product product3 = new Product();
		product3.setProductId("3");
		product3.setProductName("Product 3");
		product3.setProductCost("350");
		
		Product product4 = new Product();
		product4.setProductId("4");
		product4.setProductName("Product 4");
		product4.setProductCost("400");
		
		Product product5 = new Product();
		product5.setProductId("5");
		product5.setProductName("Product 5");
		product5.setProductCost("200");
		
		listOfAllProducts= new Product[5];
		listOfAllProducts[0]= product1;
		listOfAllProducts[1]= product2;
		listOfAllProducts[2]= product3;
		listOfAllProducts[3]= product4;
		listOfAllProducts[4]= product5;
	
		return listOfAllProducts;
	}

	public void setListOfAllProducts(Product [] listOfAllProducts) {
		this.listOfAllProducts = listOfAllProducts;
	}
}
