import java.util.*;
public class Driver {
/*class:Driver class
 * Author:Arda Baran
 * Description:
 * this class is Main class.All design patterns are tested in this class.
 * 
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
	// e-commerce company is created	
   Company c = new Company("Arda Company","Çankaya/Ankara");
   c.displayCompanyInfo();
   
   //-------------------------------------------------------------------------------------------------------
   //Different types of products are created by using factory design pattern.
   //-------------------------------------------------------------------------------------------------------
   
   c.addProductToStock("abc12", "Technology", "ASUS Laptop", "12 GB Ram,Nvidia 940 MX GPU, 1 tb HDD", true, 17500);
   c.addProductToStock("ab12", "Technology", "Xerox Phaser Printer", "3020b black white printer", true, 3500);
   c.addProductToStock("abcd12", "Technology", "Samsung Galaxy S24", "6 GB Ram,Android", true, 58000);
   c.addProductToStock("psplw2", "Technology", "Grand Theft Auto 6", "Open World Video Game", true, 1700);
   c.addProductToStock("vkmvkfm9", "Technology", "Samsung 4K HD Television", "127 inch screen , 4K", true, 40000);
   
  c.addProductToStock("151sa", "Pet", "Royal Canin Cat Food", "Chicken Adult Cat Food", true, 320);
  c.addProductToStock("12ncdn", "Pet", "Whiskas Cat Food", "Fish Adult Cat Food", true, 220);
  c.addProductToStock("1cdc2", "Pet", "Proplan Cat Food", "Chicken Adult Cat Food", true, 350);
  c.addProductToStock("vfv2111", "Pet", "Cat Laser Toy", "Nice toy for cats", true, 120);
  
  
  c.addProductToStock("mmodk", "Book", "Signals And Systems", "signal processing", true, 1300.76);
  c.addProductToStock("mnbhn", "Book", "Introduction to Java", "java for begginners", true, 750);
  c.addProductToStock("meweeqk", "Book", "Digital Design and Computer Architecture", "assembly language and microarcitecture", true, 2500);
  c.addProductToStock("mnhnhyt5", "Book", "Design Patterns", "creational,structural and behavioral design patterns", true, 3300.76);
  
  c.addProductToStock("puıy", "Clothes", "T-shirt", "LC Wakiki XL Tshirt", true, 100);
  c.addProductToStock("puıyefe", "Clothes", "Jean", "Diesel S jean", true, 1100);
  c.addProductToStock("puıbbfy", "Clothes", "Rolex Wacth", "Luxury Rolex Watch", true, 500000);
  
  c.addProductToStock("sp1", "Outdoor", "Bench Press Table", "Domyos Bench Press", true, 3200);
  c.addProductToStock("sp1", "Outdoor", "Squat Rack", "Handmade Squat Rack with height 2 meters", true, 15000);
  c.addProductToStock("sp1", "Outdoor", "Lat Pulldown Machine", "Lat machine to gain back muscle", true, 11200);
  
  c.displayTechProdc();
  c.displayPetProdc();
  c.displayBookProdc();
  c.displayClothesProdc();
  c.displayOutdoorProdc();

  //Customers registers to the e-commerce platform for shopping 
  c.userRegistration("Arda", "Baran", "barannmeisterr", "arda.baran@tedu.edu.tr", 650000);
  c.userRegistration("John", "Doe", "john.doe42", "john.doe@tedu.edu.tr", 50000);
  c.userRegistration("Maria", "Smith", "maria22", "maria.smith@tedu.edu.tr", 150000);
  c.userRegistration("Indiana", "Jones", "adventurerJones", "indiana.jones@tedu.edu.tr", 650000);

 
  //Customer notification preferences are set.
  c.getUserByUserName("barannmeisterr").setSubscribedForNotifications(true);
  c.getUserByUserName("john.doe42").setSubscribedForNotifications(false);
  c.getUserByUserName("maria22").setSubscribedForNotifications(true);
  c.getUserByUserName("adventurerJones").setSubscribedForNotifications(false);
  
  //-------------------------------------------------------------------------------------------------------
  //OBSERVER DESIGN PATTERN.Only subscibed users notified about discount
  //-------------------------------------------------------------------------------------------------------
  
  c.registerSubscribedUsers();
  c.displayAllUsers();
  System.out.println("==================================================================");
  c.applyDiscountToSpecificTypeOfProducts("Technology", 10);
  c.displayAllUsers();
  System.out.println("==================================================================");
  c.displayTechProdc();
  //-------------------------------------------------------------------------------------------------------
  //VISITOR DESIGN PATTERN.User can add the products to the cart and view different categories.
  //-------------------------------------------------------------------------------------------------------
  ShoppingVisitor shoppingVisitor = new ShoppingActionVisitor();

  
  for (TechnologyProduct techProduct : c.getTechnologyProducts()) {
      techProduct.accept(shoppingVisitor,c.getUserByUserName("barannmeisterr"));
  }
  c.getUserByUserName("barannmeisterr").showCart();
 
//-------------------------------------------------------------------------------------------------------
  //MEDIATOR DESIGN PATTERN.Users can buy products from the company.stock,user balance and company revenue are updated.
  //-------------------------------------------------------------------------------------------------------
  ShoppingMediator mediator = new ShoppingCartMediator();
  OrderContext order = new OrderContext();
  System.out.println("Purchasing items...");
  for (Product product :  c.getUserByUserName("barannmeisterr").getCart()) {
      mediator.purchaseItem( c.getUserByUserName("barannmeisterr"), product, c);
  }
//-------------------------------------------------------------------------------------------------------
  //TEMPLATE DESIGN PATTERN and STATE DESIGN PATTERN.
  //-------------------------------------------------------------------------------------------------------
  AbstractOrderProcessor physicalOrderProcessor = new PhysicalProductOrderProcessor();
  System.out.println("Processing physical product order:");
  physicalOrderProcessor.processOrder();
  System.out.println("Current State: " + order.getStateName());
  order.processOrder();

  System.out.println("\nCurrent State: " + order.getStateName());
  order.processOrder(); 

  System.out.println("\nCurrent State: " + order.getStateName());
  order.processOrder(); 
  System.out.println();
  c.getUserByUserName("barannmeisterr").getCart().clear();
  c.displayCompanyInfo();
  c.displayAllUsers();
  
//-------------------------------------------------------------------------------------------------------
  //CHAIN OF RESPONSIBILITY
  //-------------------------------------------------------------------------------------------------------
  
  RequestHandler customerService = new CustomerServiceHandler();
  RequestHandler technicalSupport = new TechnicalSupportHandler();
  RequestHandler management = new ManagementHandler();

  // bound the chain
  customerService.setNextHandler(technicalSupport);
  technicalSupport.setNextHandler(management);

  // sample requests
  SupportRequest refundRequest = new SupportRequest("Refund", "Customer wants a refund for their purchase.");
  SupportRequest techRequest = new SupportRequest("Technical", "Customer is facing an issue with the product.");
  SupportRequest complaintRequest = new SupportRequest("Complaint", "Customer is unhappy with the service.");
  SupportRequest unknownRequest = new SupportRequest("Other", "Request does not match any known category.");

  // process the requests by using the chain
  System.out.println("Processing refund request:");
  customerService.handleRequest(refundRequest);

  System.out.println("\nProcessing technical support request:");
  customerService.handleRequest(techRequest);

  System.out.println("\nProcessing complaint request:");
  customerService.handleRequest(complaintRequest);

  System.out.println("\nProcessing unknown request:");
  customerService.handleRequest(unknownRequest);
  
  

  
  
  
  
	}

}
