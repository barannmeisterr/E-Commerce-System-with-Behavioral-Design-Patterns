import java.util.*;

public class Company implements Subject {
/*class:Company class
 * Author:Arda Baran
 * Description:
 * This class represents an e-commerce company.Different types of product is produced by company.Users can register to this
 * 	e-commerce company for shopping.So,this class manages business operations.
 * It tracks and updates the company's revenue, available inventory for each product,and ensures interactions 
 * between the customer, products, and order processing systems.
 * 
 *   Responsibilities:
 * - Maintains the company's revenue.
 * - Manages product inventory levels and ensures stock is updated after purchases.
 * - Produces different types of products by using Factory Design Pattern.
 * - Coordinates with other classes like User, Product, and Order to fulfill purchases.
 * - Implements Mediator and Observer patterns for handling inventory updates 
 *   and notifying subscribed customers about promotions or stock updates.
 *
 *    Design Patterns:
 * - Mediator Pattern: Coordinates between users and product inventory during purchases,updates revenue.
 * - Observer Pattern: Acts as a subject, notifying customers (observers) about updates.
 * 
 */
	
	List<Observer> observers = new ArrayList<>();
	String companyName,companyAddress;
double revenue;
List<User> users;
List<TechnologyProduct>technologyProducts;
List <PetProduct> petProducts;
List<BookProduct>bookProducts;
List<ClothesProduct> clothesProducts;
List <OutdoorProduct> outdoorProducts;
public Company(String companyName,String companyAddress) {
	this.companyName=companyName;
	this.companyAddress=companyAddress;
	this.revenue=0;
	this.users=new ArrayList<>();
	this.technologyProducts=new ArrayList<>();
	this.petProducts=new ArrayList<>();
	this.bookProducts=new ArrayList<>();
    this.clothesProducts=new ArrayList<>();
	this.outdoorProducts=new ArrayList<>();	
}

@Override
public void subscribe(Observer observer) {
    observers.add(observer);
}

@Override
public void unsubscribe(Observer observer) {
    observers.remove(observer);
}

@Override
public void notifyObservers(String message) {
    for (Observer observer : observers) {
        observer.update(message);
    }
}

public void registerSubscribedUsers() {
/*-----------------------------------------------------
 * Summary:adds all subscribed users as observers
 *----------------------------------------------------------------    
 */	
	for (User user : getSubscribedUsers()) {
        subscribe(new NotificationObserver(user));
    }
}
public void addRevenue(double amount) {
    this.revenue += amount;
}
public void applyDiscountToSpecificTypeOfProducts(String productType, double discountRate) {
	/*-----------------------------------------------------
	 * Summary:sends discount message to subscribed users that observers
	 *----------------------------------------------------------------    
	 */	  	
	String message = "";
    switch (productType) {
        case "Technology":
            for (TechnologyProduct t : getTechnologyProducts()) {
                t.setPrice(t.getPrice() * ((100 - discountRate) / 100));
            }
                message = "Good News...%"+discountRate+" Discount Applied For Technology Products";
                notifyObservers(message);
            
            break;
        case "Pet":
            for (PetProduct p : getPetProducts()) {
                p.setPrice(p.getPrice() * ((100 - discountRate) / 100));
            
            }
                message = "Good News...%"+discountRate+" Discount Applied For Pet Products";
                notifyObservers(message);
            
            
            break;
        case "Book":
            for (BookProduct b : getBookProducts()) {
                b.setPrice(b.getPrice() * ((100 - discountRate) / 100));
            }
                message = "Good News...%"+discountRate+" Discount Applied For Book Products";
                notifyObservers(message);
            
            
            break;
        case "Clothes":
            for (ClothesProduct c : getClothesProducts()) {
                c.setPrice(c.getPrice() * ((100 - discountRate) / 100));
            }
                message = "Good News...%"+discountRate+" Discount Applied For Clothes Products";
                notifyObservers(message);
            
            
            break;
        case "Outdoor":
            for (OutdoorProduct o : getOutdoorProducts()) {
                o.setPrice(o.getPrice() * ((100 - discountRate) / 100));
            }
                message = "Good News...%"+discountRate+" Discount Applied For Outdoor Products";
                notifyObservers(message);
            
            
            break;
        default:
            return;
    }
}
public void userRegistration(String name,String surname,String username,String mailAddress,double balance) {
	User newUser = new User(name,surname,username,mailAddress,balance);
users.add(newUser);
}

public List<User> getSubscribedUsers(){
	List<User>subscribedUsers = new ArrayList<>();
	for(User u : getUsers()) {
		if(u.isSubscribedForNotifications()) {
			subscribedUsers.add(u);
		}
	}
return subscribedUsers;
}
public void displayAllUsers() {
	for (User u : getUsers()) {
		
	System.out.println("---------------------------------------------------------");	
		System.out.println(u);
	System.out.println("Inbox");
	u.getMailBox().displayInbox();
	u.showCart();
	}
}
public User getUserByUserName(String userName) {

	for(User u : getUsers()) {
		if(u.getUsername().equals(userName)) {
			return u;
		}
	}
return null;
}

public void displayCompanyInfo() {
System.out.println("========================================================================");
System.out.println("|Company Name: "+getCompanyName());
System.out.println("|Company Address: "+getCompanyAddress());
System.out.println("|Company Revenue: "+getRevenue());
System.out.println("=========================================================================");
	
}
public void addProductToStock(String productId,String productType,String productName,String description,boolean inStock,double price) {
Product newProduct = ProductFactory.createProduct(productId, productType, productName, description, inStock, price);
if (newProduct instanceof TechnologyProduct) {
	TechnologyProduct t = (TechnologyProduct) newProduct;
	getTechnologyProducts().add(t);
}else if(newProduct instanceof PetProduct) {
	PetProduct p = (PetProduct) newProduct;
	getPetProducts().add(p);
	
}else if(newProduct instanceof BookProduct) {
	BookProduct b = (BookProduct) newProduct;
	getBookProducts().add(b);
	
}else if(newProduct instanceof ClothesProduct) {
	ClothesProduct c = (ClothesProduct) newProduct;
	getClothesProducts().add(c);
	
}else if(newProduct instanceof OutdoorProduct) {
	OutdoorProduct o = (OutdoorProduct) newProduct;
	getOutdoorProducts().add(o);
}else {
	System.out.println("Invalid Product...");
}
}
public void displayTechProdc() {
System.out.println("=====================================================");
System.out.println("Displaying All Technology Products...");
	
	for(TechnologyProduct t : getTechnologyProducts()) {
		t.ShowProductDetails();
		
	}
System.out.println("======================================================");
}

public void displayPetProdc() {
System.out.println("=====================================================");
System.out.println("Displaying All Pet Products...");
	
	for(PetProduct p : getPetProducts()) {
		p.ShowProductDetails();
		
	}
System.out.println("======================================================");
}
public void displayBookProdc() {
System.out.println("=====================================================");
System.out.println("Displaying All Book Products...");
	
	for(BookProduct b : getBookProducts()) {
		b.ShowProductDetails();
		
	}
System.out.println("======================================================");
}
public void displayClothesProdc() {
System.out.println("=====================================================");
System.out.println("Displaying All Clothes Products...");
	
	for(ClothesProduct c : getClothesProducts()) {
		c.ShowProductDetails();
		
	}
System.out.println("======================================================");
}
public void displayOutdoorProdc() {
System.out.println("=====================================================");
System.out.println("Displaying All Outdoor Products...");
	
	for(OutdoorProduct o : getOutdoorProducts()) {
		o.ShowProductDetails();
		
	}
System.out.println("======================================================");
}

public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getCompanyAddress() {
	return companyAddress;
}
public void setCompanyAddress(String companyAddress) {
	this.companyAddress = companyAddress;
}
public double getRevenue() {
	return revenue;
}
public void setRevenue(double revenue) {
	this.revenue = revenue;
}
public List<User> getUsers() {
	return users;
}
public void setUsers(List<User> users) {
	this.users = users;
}
public List<TechnologyProduct> getTechnologyProducts() {
	return technologyProducts;
}
public void setTechnologyProducts(List<TechnologyProduct> technologyProducts) {
	this.technologyProducts = technologyProducts;
}
public List<PetProduct> getPetProducts() {
	return petProducts;
}
public void setPetProducts(List<PetProduct> petProducts) {
	this.petProducts = petProducts;
}
public List<BookProduct> getBookProducts() {
	return bookProducts;
}
public void setBookProducts(List<BookProduct> bookProducts) {
	this.bookProducts = bookProducts;
}
public List<ClothesProduct> getClothesProducts() {
	return clothesProducts;
}
public void setClothesProducts(List<ClothesProduct> clothesProducts) {
	this.clothesProducts = clothesProducts;
}
public List<OutdoorProduct> getOutdoorProducts() {
	return outdoorProducts;
}
public void setOutdoorProducts(List<OutdoorProduct> outdoorProducts) {
	this.outdoorProducts = outdoorProducts;
}
}
