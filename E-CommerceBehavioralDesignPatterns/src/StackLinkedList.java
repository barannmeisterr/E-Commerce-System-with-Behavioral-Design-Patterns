
public class StackLinkedList {
	/*class:StackLinkedList class
	 * Author:Arda Baran
	 * Description:
	 * This class represents the linked list implementation of stack data structure
	 * 
	 */
	
	
	StackNode top ;
	int size ;
	public StackLinkedList() {
		this.top=null;
	this.size = 0 ;
	}
	public boolean isEmpty() {
		return (top==null);
	}
	public void pushStack(String key) {

	StackNode node = new StackNode(key);
	node.setNext(top);	
	top=node;
	size++;
		
		
	}
	public void popStack() {
		if(isEmpty()) {
			
		return ;
		}
	StackNode temp = top;
	top = top.getNext();
	temp.setNext(null);
		size--;
		

	}
	public String getTop() {
	return (top == null ? null : top.getMail());	
	}
	public void printStack() {
	if(top==null) {
		System.out.println("There is No Mail In the Inbox...");
		return;
	}
		StackNode current = top ;
	while (current !=null) {
		System.out.println(current.getMail());

	current = current.getNext();
	}
	
	}


	}


 class StackNode {
String mail ;
StackNode next ;
public StackNode(String mail) {
	this.mail=mail;
    this.next=null;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public StackNode getNext() {
	return next;
}
public void setNext(StackNode next) {
	this.next = next;
}

}