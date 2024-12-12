import java.util.*;
public class User {
/*class:User class
 *Author Arda Baran 
 * Description:
 * this class represents a customer in an e-commerce platform.
 * 
 */	
String name,surname,username,mailAddress;
double balance;
List<Product>cart;
MailBox mailBox;
boolean subscribedForNotifications;
public User(String name,String surname,String username,String mailAddress,double balance) {
	this.name=name;
	this.surname=surname;
	this.username=username;
	this.mailAddress=mailAddress;
	this.balance=balance;
    this.cart=new ArrayList<>();
    this.mailBox=new MailBox(mailAddress);
    this.subscribedForNotifications=true;
    
}
public void addToCart(Product product) {
    cart.add(product);
}
public void deductBalance(double amount) {
    this.balance -= amount;
}
public void showCart() {
    System.out.println("Shopping Cart");
    for (Product product : cart) {
        System.out.println("- " + product.getProductName() + " (" + product.getPrice() + ")");
    }
}
public double shoppingCartCost() {
	double sum = 0.0;
	for(Product p:getCart()) {
		sum = sum + p.getPrice();
	}
return sum;

}

public boolean isBalanceSufficient(double cost) {
	if(cost < getBalance()) {
		return true;
		
	}else {
		return false;
	}
}


public boolean isSubscribedForNotifications() {
	return subscribedForNotifications;
}


public void setSubscribedForNotifications(boolean subscribedForNotifications) {
	this.subscribedForNotifications = subscribedForNotifications;
}


@Override
public String toString() {
String subscribedStatus = "";	
	if(isSubscribedForNotifications()) {
		subscribedStatus = "Subscribed";
	}else {
		subscribedStatus = "Not Subscribed";
	}
	return "Username: "+getUsername()+" | Name: "+getName()+" | Surname: "+getSurname()+" | E-mail: "+getMailAddress()+" | Subscribion Status: "+subscribedStatus+" | Balance: "+getBalance();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMailAddress() {
	return mailAddress;
}
public void setMailAddress(String mailAddress) {
	this.mailAddress = mailAddress;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public List<Product> getCart() {
	return cart;
}
public void setCart(List<Product> cart) {
	this.cart = cart;
}
public MailBox getMailBox() {
	return mailBox;
}
public void setMailBox(MailBox mailBox) {
	this.mailBox = mailBox;
}
}
