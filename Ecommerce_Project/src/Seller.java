
public class Seller extends User {
	private Product [] productListed;
	public Boolean verifyUser() {
		return true;
	}
	public Product[] getProductListed() {
		return productListed;
	}
	public void setProductListed(Product[] productListed) {
		this.productListed = productListed;
	}
}
