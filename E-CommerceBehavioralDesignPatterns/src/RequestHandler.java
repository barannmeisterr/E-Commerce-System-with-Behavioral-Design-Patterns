//=============================================================================================================================
                                              
                                                    // CHAIN OF RESPONSIBILITY
//It ensures that a request is carried through a processing chain and handled by an appropriate handler. 
//This pattern can be used to direct the customer representative, technical team or management, especially for returns and support
//requests.
//This pattern connects handlers together to form the chain. For example, the order can be created as 
//customer representative → technical team → management.
//=============================================================================================================================
public abstract class RequestHandler {
/*Class : RequestHandler class
 *Author:Arda Baran 
 * Description:
 * All handlers implement this interface and have the ability to forward it to the next handler.
 * 
 * 
 * 	
 */
	
	protected RequestHandler nextHandler;

	    public void setNextHandler(RequestHandler nextHandler) {
	        this.nextHandler = nextHandler;
	    }

	    public abstract void handleRequest(SupportRequest request);
	}
class SupportRequest {
	/*Class : SupportRequest class
	 *Author:Arda Baran 
	 * Description:
	 * This class represents support requests. For example, it may include attributes such as request type and message.
	 * 
	 * 
	 * 	
	 */
	
	
	
	private String type; // e.g.: "Refund", "Technical", "Complaint"
    private String message;

    public SupportRequest(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
//Concrete Handler classes.
class CustomerServiceHandler extends RequestHandler {
	/*Class : CustomerServiceHandler class
	 *Author:Arda Baran 
	 * Description:
	 * this class represents customer service handler
	 * 
	 * 
	 * 	
	 */
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equalsIgnoreCase("Refund") || request.getType().equalsIgnoreCase("General")) {
            System.out.println("Customer Service: Handling request - " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for request: " + request.getMessage());
        }
    }
}
class TechnicalSupportHandler extends RequestHandler {
	/*Class : TechnicalSupportHandler class
	 *Author:Arda Baran 
	 * Description:
	 * this class represents technical support handler
	 * 
	 * 
	 * 	
	 */
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equalsIgnoreCase("Technical")) {
            System.out.println("Technical Support: Handling request - " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for request: " + request.getMessage());
        }
    }
}
class ManagementHandler extends RequestHandler {
	/*Class : ManagementHandler class
	 *Author:Arda Baran 
	 * Description:
	 * this class represents management handler.
	 * 
	 * 
	 * 	
	 */
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getType().equalsIgnoreCase("Complaint")) {
            System.out.println("Management: Handling request - " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler available for request: " + request.getMessage());
        }
    }
}