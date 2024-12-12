
public class MailBox {
/*class:MailBox class
 * Author:Arda Baran
 * Description:
 * this class represent a mail box of an user.User receives notifications by using this class.
 * This class also uses Stack data structure.
 */
	
	
String mailAddress;
StackLinkedList inbox;
public MailBox(String mailAddress) {
	this.mailAddress=mailAddress;
	this.inbox=new StackLinkedList();	
}
public String getMailAddress() {
	return mailAddress;
}
public void setMailAddress(String mailAddress) {
	this.mailAddress = mailAddress;
}


public StackLinkedList getInbox() {
	return inbox;
}
public void setInbox(StackLinkedList inbox) {
	this.inbox = inbox;
}
public void attachNotification(String notificationMessage) {
	getInbox().pushStack(notificationMessage);
}
public void displayInbox() {

	getInbox().printStack();	
}
}
