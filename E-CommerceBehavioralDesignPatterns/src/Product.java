import java.util.*;
//=============================================================================================================================

                                      //FACTORY DESIGN PATTERN
//Factory design pattern is responsible for creating different type of products for a company and customers.There are five
//different product types in this project.

//1.Technology Products:Consists of laptops,mobile phones,printers,televisions and video games.
//2.Pet Products:Consists of different cat food brands and cat toys.
//3.Book Products:Consists of academic research books ,novels etc.
//4.Clothes Products:Consists of tshirts,jeans and watches which means wearable stuffs.
//5.Outdoor Products:Consists of gym tools etc.

//the factory pattern is used to produce different categories of products based on a provided input. 
//Each product type corresponds to a distinct category, and each category can have its specific implementations.
//=============================================================================================================================
class ProductFactory{
/*class:ProductFactory class
 * Author:Arda Baran
 * Description:
 * 	this class declares a method to create products, which the concrete factories will implement.
 */
	
	
public static Product createProduct(String productId,String productType,String productName,String description,boolean inStock,double price) {	
switch(productType) {
case "Technology": 
return new TechnologyProduct(productId,productType,productName,description,inStock,price);
case "Pet":
	return new PetProduct(productId,productType,productName,description,inStock,price);

case "Book":
return new BookProduct(productId,productType,productName,description,inStock,price);
case "Clothes":
	return new ClothesProduct(productId,productType,productName,description,inStock,price);
case "Outdoor":
	return new OutdoorProduct(productId,productType,productName,description,inStock,price);
default:
	return null;
}
}	
}

public abstract class Product {
/*class:Product class
 * Author:Arda Baran
 * Description:
 * this class represents a standard structure for all products, ensuring uniformity across product categories
 * 
 * 
 */
	
	String productId,ProductType,productName,description;
boolean inStock;
double price;
public Product(String productId,String productType,String productName,String description,boolean inStock,double price) {
	this.productId=productId;
	this.ProductType=productType;
	this.productName=productName;
	this.description=description;
	this.inStock=true;
	this.price=price;
	
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductType() {
	return ProductType;
}
public void setProductType(String productType) {
	ProductType = productType;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isInStock() {
	return inStock;
}
public void setInStock(boolean inStock) {
	this.inStock = inStock;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public abstract void ShowProductDetails();
public abstract void accept(ShoppingVisitor visitor, User user);//To apply visitor design pattern


}
class TechnologyProduct extends Product{
/*class:TechnologProduct class
 * Author:Arda Baran
 * this class represents a technology product in the factory.
 * 
 * 
 */
	public TechnologyProduct(String productId, String productType, String productName, String description,
			boolean inStock, double price) {
		super(productId, productType, productName, description, inStock, price);
		
	}
	@Override
	public void ShowProductDetails() {
		System.out.println("Product ID: "+getProductId()+" Product Type: "+getProductType()+" Product Name: "+getProductName()+" Stock status: "+isInStock()+ " Price: "+ getPrice());
	  System.out.println("Description: "+getDescription());
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
	 @Override
	    public void accept(ShoppingVisitor visitor, User user) {
	        visitor.visit(this, user);
	    }

}
class PetProduct extends Product{
	/*class:PetProduct class
	 * Author:Arda Baran
	 * this class represents a pet product in the factory.
	 * 
	 * 
	 */
	public PetProduct(String productId, String productType, String productName, String description, boolean inStock,
			double price) {
		super(productId, productType, productName, description, inStock, price);
		
	}
	@Override
	public void ShowProductDetails() {
		System.out.println("Product ID: "+getProductId()+" Product Type: "+getProductType()+" Product Name: "+getProductName()+" Stock status: "+isInStock()+ " Price: "+ getPrice());
	  System.out.println("Description: "+getDescription());
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
	 @Override
	    public void accept(ShoppingVisitor visitor, User user) {
	        visitor.visit(this, user);
	    }

}
class BookProduct extends Product{
	/*class:BookProduct class
	 * Author:Arda Baran
	 * this class represents a book product in the factory.
	 * 
	 * 
	 */
	public BookProduct(String productId, String productType, String productName, String description, boolean inStock,
			double price) {
		super(productId, productType, productName, description, inStock, price);
		
	}
	@Override
	public void ShowProductDetails() {
		System.out.println("Product ID: "+getProductId()+" Product Type: "+getProductType()+" Product Name: "+getProductName()+" Stock status: "+isInStock()+ " Price: "+ getPrice());
	  System.out.println("Description: "+getDescription());
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
	 @Override
	    public void accept(ShoppingVisitor visitor, User user) {
	        visitor.visit(this, user);
	    }

}
class ClothesProduct extends Product{
	/*class:ClothesProduct class
	 * Author:Arda Baran
	 * this class represents a wearable item in the factory.
	 * 
	 * 
	 */
	public ClothesProduct(String productId, String productType, String productName, String description, boolean inStock,
			double price) {
		super(productId, productType, productName, description, inStock, price);
		
	}
	@Override
	public void ShowProductDetails() {
		System.out.println("Product ID: "+getProductId()+" Product Type: "+getProductType()+" Product Name: "+getProductName()+" Stock status: "+isInStock()+ " Price: "+ getPrice());
	  System.out.println("Description: "+getDescription());
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
	 @Override
	    public void accept(ShoppingVisitor visitor, User user) {
	        visitor.visit(this, user);
	    }

}
class OutdoorProduct extends Product{
	/*class:PetProduct class
	 * Author:Arda Baran
	 * this class represents an outdoor stuff in the factory.
	 * 
	 * 
	 */
	public OutdoorProduct(String productId, String productType, String productName, String description, boolean inStock,
			double price) {
		super(productId, productType, productName, description, inStock, price);
		
	}
	@Override
	public void ShowProductDetails() {
		System.out.println("Product ID: "+getProductId()+" Product Type: "+getProductType()+" Product Name: "+getProductName()+" Stock status: "+isInStock()+ " Price: "+ getPrice());
	  System.out.println("Description: "+getDescription());
	  System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
	 @Override
	    public void accept(ShoppingVisitor visitor, User user) {
	        visitor.visit(this, user);
	    }
}