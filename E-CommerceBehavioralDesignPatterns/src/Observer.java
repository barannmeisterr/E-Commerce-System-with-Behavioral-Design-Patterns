import java.util.ArrayList;
import java.util.List;
//=============================================================================================================================

                                                //OBSERVER DESIGN PATTERN
//Observer design pattern in a way to notify the subscribed users when a product in their favorite category is on sale
//with promotions or discounts.
//For the Observer design pattern, Observer and a Subject interfaces are defined. The Company class can then
//implement one of these interfaces and notify users by sending notification e mail to user's mailbox if the user subscribed
// which means if user prefers to receive discount or campaing email about products.
//Observer design pattern is used to establish notification and subscibion mechanisms.
//=============================================================================================================================

interface Observer {
/*
 * class:Observer Interface
 * Author:Arda Baran
 * Description:
 ** Author: Arda Baran
     * Description:
     * Defines the blueprint for any observer class that wants to subscribe 
     * to a subject. Observers implement this interface to receive 
     * notifications from the subject they are observing.       
 */	
	void update(String message);//Called when the subject notifies its observers.It delivers the message to the observer.
}
interface Subject {
	/* 
     * class: Subject Interface
     * Author: Arda Baran
     * Description:
     * Defines the blueprint for any subject class that maintains a list of observers. 
     * Subjects implement this interface to manage the subscription and notification 
     * of observers.
     */
	
	void subscribe(Observer observer);//Adds an observer to the subject's list of observers.
    void unsubscribe(Observer observer);//Removes an observer from the subject's list.
    void notifyObservers(String message);//Sends a message to all subscribed observers to notify them of a discount or campaign about the product.
}


class NotificationObserver implements Observer {
	 /*
     * class: NotificationObserver class
     * Author: Arda Baran
     * Description:
     * A concrete implementation of the Observer interface. 
     * Represents a user who subscribes to receive notifications from a subject. 
     * It utilizes the user's mailbox to store received notifications.
     */
	
	private User user;//The user associated with this observer, who will receive notifications.

    public NotificationObserver(User user) {   	
    	this.user = user;
    }

    @Override
    public void update(String message) {
  /*--------------------------------------------------------------------------------
   * Summary:Invoked by the subject to send notifications.It stores the notification in the user's mailbox using `attachNotification()`
   * --------------------------------------------------------------------------------      
   */
        user.getMailBox().attachNotification(message);
    }
}

