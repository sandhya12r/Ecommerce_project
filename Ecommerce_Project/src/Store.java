import java.util.Scanner;

public class Store {
	public static void main(String[] args) {
		System.out.println("*****WELCOME TO THE STORE*****");
		System.out.println("------------------------------");
		System.out.println("Choose an option: 1.Customer 2.Seller 3.Admin ");
		try (Scanner userInput = new Scanner(System.in)) {
			int choice = userInput.nextInt();
			String typeOfUser;
			if (choice == 1) {
				typeOfUser = "Customer";
				Customer current = new Customer();
				System.out.println("What is your user id: ");
				userInput.nextLine();
				current.setUserId(userInput.nextLine());
				System.out.println("What is your password: ");
				current.setUserPassword(userInput.nextLine());
				if (current.verifyUser() == true) {
					System.out.println("User Verified!!!");
					while (true) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println("Do you want to 1.View Products 2.View Cart 3.Contact Us 4.Log out");
						choice = userInput.nextInt();
						if (choice == 1) {
							System.out.println("Product List is here:-");
							Catalog catalog = new Catalog();
							Product[] allProducts = catalog.getListOfAllProducts();
							for (int i = 0; i < allProducts.length; i++) {
								System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
										+ " " + allProducts[i].getProductCost());
							}
							System.out.println("Do you want to add any product in the cart Y/N: ");
							userInput.nextLine();
							String addToCart = userInput.nextLine();
							if (addToCart.equals("y") || addToCart.equals("Y")) {
								System.out.println("Enter the product id: ");
								String productId = userInput.nextLine();
								Product[] cartProducts = new Product[1];
								for (int i = 0; i < allProducts.length; i++) {
									if (allProducts[i].getProductId().equals(productId))
										cartProducts[0] = allProducts[i];
								}

								Cart cart = new Cart();
								cart.setCartId("1");
								cart.setListOfProducts(cartProducts);
								current.setCart(cart);
								System.out.println("Product is added to the cart successfully!!!");
							}

						} else if (choice == 2) {
							Product[] cartProducts = current.getCart().getListOfProducts();
							for (int i = 0; i < cartProducts.length; i++) {
								System.out.println(cartProducts[i].getProductId() + " "
										+ cartProducts[i].getProductName() + " " + cartProducts[i].getProductCost());
							}
							System.out.println("Do you want to checkout Y/N:");
							userInput.nextLine();
							String checkout = userInput.nextLine();
							Order order = new Order();
							order.setOrderId(Math.random());
							if (checkout.equals("y") || checkout.equals("Y")) {
								if (current.getCart().checkout()) {
									System.out.println("Your Order is Placed Successfully!!!");
									System.out.println("Your Order Id is " + order.getOrderId());

								}
							}
						} else if (choice == 3) {
							System.out.println(" ----------------------------------");
							System.out.println("|  Contact us on contact@store.com |");
							System.out.println(" ----------------------------------");
						} else if (choice == 4) {
							break;
						} else {
							System.out.println("| Wrong Choice. Try Again! |");
						}
					}
					System.out.println("Logged out.");
					System.out.println(" ===================================");
					System.out.println("| Thankyou! for using our services. |");
					System.out.println(" ===================================");
				}
			} else if (choice == 2) {
				typeOfUser = "Seller";
				Seller current = new Seller();
				System.out.println("What is your user id: ");
				userInput.nextLine();
				current.setUserId(userInput.nextLine());
				System.out.println("What is your password: ");
				current.setUserPassword(userInput.nextLine());
				if (current.verifyUser() == true) {
					System.out.println("User Verified!!!");
					while (true) {
						System.out.println("----------------------------------------------------------");
						System.out.println("Do you want to 1. Add Products 2. View Products 3. Log out");
						
						int choose = userInput.nextInt();

						Catalog catalog = new Catalog();
						Product addProduct = new Product();

						if (choose == 1) {

							System.out.println("Enter the product id: ");
							userInput.nextLine();
							String productId = userInput.nextLine();
							addProduct.setProductId(productId);

							System.out.println("Enter the product name: ");
							String productName = userInput.nextLine();
							addProduct.setProductName(productName);

							System.out.println("Enter the product cost: ");
							String productCost = userInput.nextLine();
							addProduct.setProductCost(productCost);

							System.out.println("Product updated successfully!!");
							System.out.println("------------------------------");
							System.out.println("The added product is:-");

							System.out.println(addProduct.getProductId() + " " + addProduct.getProductName() + " "
									+ addProduct.getProductCost());

						} else if (choose == 2) {
							System.out.println("Product List is here:-");
							
							Product[] allProducts = catalog.getListOfAllProducts();
							for (int i = 0; i < allProducts.length; i++) {
								System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
										+ " " + allProducts[i].getProductCost());
							}
						} else if (choose == 3) {
							break;
						} else {
							System.out.println("Wrong Choice. Try Again!");
						}
					}
					System.out.println("Logged out");
					System.out.println(" ===================================");
					System.out.println("| Thankyou! for using our services. |");
					System.out.println(" ===================================");
				}

			} else if (choice == 3) {
				typeOfUser = "Admin";
				Administration current = new Administration();
				System.out.println("What is your user id: ");
				userInput.nextLine();
				current.setUserId(userInput.nextLine());
				System.out.println("What is your password: ");
				current.setUserPassword(userInput.nextLine());
				if (current.verifyUser() == true) {
					System.out.println("User Verified!!!");
					while (true) {
						System.out.println("---------------------------------------------------------------");
						System.out.println("Choose an option: 1. Modify Catalog 2. View Products 3. Log Out");

						int choose = userInput.nextInt();
						Catalog catalog = new Catalog();
						if(choose ==1 ) {
							String newName ="";
							String newCost="";
							Product[] products = catalog.getListOfAllProducts();
							for (int i = 0; i < products.length; i++) {
								System.out.print(products[i].getProductName()+"\t");							
							}
							System.out.println("\n");
							System.out.println("Which Product do you want to modify: 1, 2, 3, 4, 5");
							userInput.nextLine();
							int index = userInput.nextInt();
							for (int i = 0; i < products.length; i++) {
								if(products[index].getProductId()==products[i].getProductId()) {
									System.out.println("What do you want to modify: 1.Name 2. Cost");
									userInput.nextLine();
									int option= userInput.nextInt();
									if(option ==1) {
										System.out.println("Enter new name: ");
										userInput.nextLine();
										newName= userInput.nextLine();
									}
									if(option ==2) {
										System.out.println("Enter new cost: ");
										userInput.nextLine();
										newCost= userInput.nextLine();
									}
								}								
							}
							System.out.println("Product "+index+" updated successfully!!!");
							
						}
						else if(choose ==2) {
							System.out.println("Product List is here:-");
							Product[] allProducts = catalog.getListOfAllProducts();
							for (int i = 0; i < allProducts.length; i++) {
								System.out.println(allProducts[i].getProductId() + " " + allProducts[i].getProductName()
										+ " " + allProducts[i].getProductCost());
							}
						}
						else if(choose ==3) {
							break;
						}else {
							System.out.println("Wrong Choice. Try Again!");
						}
					}
					
					System.out.println(" ============================");
					System.out.println("| Logged Out Successfully!!! |");
					System.out.println(" ============================");
				}
			}

			else
				System.out.println("Wrong choice. Try again!");
		}
		
	}
}
