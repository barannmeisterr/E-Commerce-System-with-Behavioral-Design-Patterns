//=============================================================================================================================
                                              
                                                    // TEMPLATE DESIGN PATTERN
//The Template design pattern is used to describe a process step by step and allow subclasses to customize some of each step.
//This allows subclasses to provide custom behavior while standardizing repeated operations.
//In the context of the E-commerce shopping system, using the Template pattern, orders are:
//Order Confirmation
//Sending (Shipping)
//Order Completion
//the processes are defined. While some steps of these processes are standard (e.g. payment processing), some can be customized 
//by subclasses (e.g. different shipping methods).
//=============================================================================================================================


public abstract class AbstractOrderProcessor {
/*class:AbstractOrderProcessor class
 * Author:Arda Baran
 * Description:
 * This class determines the order processing steps and marks some of them as final (cannot be modified by subclasses). 
 * The steps to be customized are left as abstract.
 * 
 */
	public final void processOrder() {
	        confirmOrder();       
	        processPayment();     
	        shipOrder();          
	        completeOrder();      
	    }
	    // Step 1: Order confirmation
	    protected abstract void confirmOrder();

	    // Step 2: Payment process
	    protected void processPayment() {
	        System.out.println("Payment processed successfully.");
	    }

	    // Step 3: Transfer process
	    protected abstract void shipOrder();

	    // Step 4: Complete ordes process
	    protected void completeOrder() {
	        System.out.println("Order completed and marked as fulfilled.");
	    }
	}

//Custom behaviors can be provided for each different order type (e.g. physical products, digital products).

class PhysicalProductOrderProcessor extends AbstractOrderProcessor {
	/*class:PhysicalProductOrderProcessor class
	 * Author:Arda Baran
	 * Description:this class represents Order Processing for Physical Products
	 * 
	 * 
	 */
    @Override
    protected void confirmOrder() {
        System.out.println("Physical product order confirmed.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Physical product shipped via courier.");
    }
}
class DigitalProductOrderProcessor extends AbstractOrderProcessor {
	/*class:DigitalProductOrderProcessor class
	 * Author:Arda Baran
	 * Description:this class represents Order Processing for Digital Products
	 * 
	 * 
	 */	
    @Override
    protected void confirmOrder() {
        System.out.println("Digital product order confirmed.");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Digital product download link sent to the user.");
    }
}

