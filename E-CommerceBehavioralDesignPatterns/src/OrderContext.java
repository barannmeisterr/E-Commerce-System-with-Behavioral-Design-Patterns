//=============================================================================================================================
                                              
                                                    // STATE DESIGN PATTERN
//States such as order processes can be represented by a State pattern. For example:
//Order status: Order Received, Order Shipped, Order Delivered.
//Each situation may take a different action on the order.
//=============================================================================================================================
interface OrderState {
	/*Class : OrderState Interface
	 *Author:Arda Baran 
	 * Description:Each state implements this interface and operates on the OrderContext. 	
	 */
	
	void handleOrder(OrderContext context);
    String getStateName();
}

public class OrderContext {
	/*Class : OrderContex class
	 *Author:Arda Baran 
	 * Description:this class stores the status of an order and executes transactions based on the current status. 	
	 */
	
	private OrderState currentState;

    public OrderContext() {
        // initial state
        this.currentState = new OrderPlacedState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void processOrder() {
        currentState.handleOrder(this);
    }

    public String getStateName() {
        return currentState.getStateName();
    }
}
class OrderPlacedState implements OrderState {
	/*Class : OrderPlacedState class
	 *Author:Arda Baran 
	 * Description:this class represents order placed  state.	
	 */
    @Override
    public void handleOrder(OrderContext context) {
        System.out.println("Order is placed. Preparing to ship...");
        context.setState(new OrderShippedState()); // change the state as transferred
    }

    @Override
    public String getStateName() {
        return "Order Placed";
    }
}
class OrderShippedState implements OrderState {
	/*Class : OrderShippedState class
	 *Author:Arda Baran 
	 * Description:this class represents order shipped state. 	
	 */
    @Override
    public void handleOrder(OrderContext context) {
        System.out.println("Order is shipped. On the way to delivery...");
        context.setState(new OrderDeliveredState()); // change the state as delivered
    }

    @Override
    public String getStateName() {
        return "Order Shipped";
    }
}
class OrderDeliveredState implements OrderState {
	/*Class : OrderDeliveredState class
	 *Author:Arda Baran 
	 * Description:this class represents order delivered state. 	
	 */
    @Override
    public void handleOrder(OrderContext context) {
        System.out.println("Order is delivered. Thank you!");
        // last step
    }

    @Override
    public String getStateName() {
        return "Order Delivered";
    }
}
