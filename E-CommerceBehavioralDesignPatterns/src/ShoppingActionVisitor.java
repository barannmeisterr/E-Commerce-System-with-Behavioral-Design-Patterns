import java.util.*;
 
//=============================================================================================================================

                                         //VISITOR DESIGN PATTERN
//Visitor design pattern in a way that allows a user to shop for a specific category and add the products to the cart.
//In this scenario, each user can take action for a specific product category using a Visitor through the User class. 
//=============================================================================================================================


interface ShoppingVisitor {
/*class:ShoppingVisitor Interface
 * Author:Arda Baran
 *Description:    
 * Visitor interface includes a method for each product category   
 *    
 */
	
	void visit(TechnologyProduct technologyProduct, User user);
    void visit(PetProduct petProduct, User user);
    void visit(BookProduct bookProduct, User user);
    void visit(ClothesProduct clothesProduct, User user);
    void visit(OutdoorProduct outdoorProduct, User user);
}

public class ShoppingActionVisitor implements ShoppingVisitor {
	/*class:ShoppingActionVisitor class
	 * Author:Arda Baran
	 *Description:    
	 * this class that implements the Visitor interface. The user uses this class to add products from the selected category to 
	 * the cart or search. 
	 *    
	 */
    @Override
    public void visit(TechnologyProduct technologyProduct, User user) {
        if (technologyProduct.isInStock()) {
            user.addToCart(technologyProduct);
            System.out.println("Added Technology Product to cart: " + technologyProduct.getProductName());
        }
    }

    @Override
    public void visit(PetProduct petProduct, User user) {
        if (petProduct.isInStock()) {
            user.addToCart(petProduct);
            System.out.println("Added Pet Product to cart: " + petProduct.getProductName());
        }
    }

    @Override
    public void visit(BookProduct bookProduct, User user) {
        if (bookProduct.isInStock()) {
            user.addToCart(bookProduct);
            System.out.println("Added Book Product to cart: " + bookProduct.getProductName());
        }
    }

    @Override
    public void visit(ClothesProduct clothesProduct, User user) {
        if (clothesProduct.isInStock()) {
            user.addToCart(clothesProduct);
            System.out.println("Added Clothes Product to cart: " + clothesProduct.getProductName());
        }
    }

    @Override
    public void visit(OutdoorProduct outdoorProduct, User user) {
        if (outdoorProduct.isInStock()) {
            user.addToCart(outdoorProduct);
            System.out.println("Added Outdoor Product to cart: " + outdoorProduct.getProductName());
        }
    }
}