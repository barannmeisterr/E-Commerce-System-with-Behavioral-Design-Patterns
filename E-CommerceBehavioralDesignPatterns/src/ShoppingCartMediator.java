import java.util.*;
//=============================================================================================================================

                                              // MEDIATOR DESIGN PATTERN
//The Mediator design pattern is used to manage the connection between objects that need to communicate directly with each other
//through a central intermediary. This reduces dependencies between classes and makes the code more flexible.
//Using the Mediator pattern in this scenario:
//The user's balance will be checked and deducted if the purchase successfully completed.
//The stock of the products will be updated in the company.
//The company's income will be increased after each purchase.
//=============================================================================================================================




interface ShoppingMediator {
 /*class : ShoppingMediator Interface
  * Author:Arda Baran
  * Description:  
  *   this interface defines behaviors that mediator class should communicate with.
  */
	
	boolean purchaseItem(User user, Product product, Company company);
}


public class ShoppingCartMediator implements ShoppingMediator {
	 /*class : ShoppingCartMediator class
	  * Author:Arda Baran
	  * Description:  
	  *   this class represents a concrete implementation of Mediator provides communication between user balance, stock and 
	  *   company income.
	  */
    @Override
    public boolean purchaseItem(User user, Product product, Company company) {
        // returns false if the balance is insufficient
        if (user.getBalance() < product.getPrice()) {
            System.out.println("Insufficient balance for user: " + user.getName());
            return false;
        }

        // returns false if the product is out of stock
        if (!product.isInStock()) {
            System.out.println("Product is out of stock: " + product.getProductName());
            return false;
        }

        
        user.deductBalance(product.getPrice()); // decrease user balance
        product.setInStock(false); // remove the purchased item from stock
        company.addRevenue(product.getPrice()); // increase company revenue
        
        System.out.println("Purchase successful: " + product.getProductName());
        return true;
    }
}

