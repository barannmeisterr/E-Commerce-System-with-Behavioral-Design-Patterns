# E-Commerce System with Behavioral Design Patterns

## Project Description

The **E-Commerce System with Behavioral Design Patterns** project is a Java-based e-commerce system management that demonstrates the use of behavioral design patterns to create a flexible, scalable, and maintainable system. The primary design patterns implemented in this project include **Observer**, **Visitor**, **Mediator**,**Template**, **Chain of Responsibility**, **State**, and **Factory**. Since E-commerce systems require a flexible and scalable architecture to handle a wide range of functionalities, including product management, user interactions, order processing, and notifications , each pattern is used to solve specific design challenges, such as dynamically notifying customers when there is a discount or campaign, allowing a user to shop for a specific category and add the products to the shopping card,coordinating actions like updating stock, user balance, and company revenue during the checkout process ,standardizing order lifecycle processes such as order confirmation, shipment, and completion,routing customer support requests to appropriate departments (e.g., Customer Service, Technical Team, Management),managing the lifecycle states of orders and creating different product categories (e.g., Technology, Books, Clothing).

## Author

- **Arda Baran**

## Features

- **User Subscription and Notification**: The system can notify users about promotions or discounts on their subscribed categories by using the Observer design pattern.
- **Coordinating Actions**: The system can update instantly the stock,user balance,user shopping card and company revenue after each purchase by using Mediator design pattern.
- **Flexible Customer Shopping**: The system can allow users to shop for a specific category and add the products to the cart by using the Visitor design pattern.
- **Order Processing**: The system can standardize order lifecycle processes such as order confirmation, shipment, and completion by using the Template design pattern.
- **Customer Support**: The system can route customer support requests by using the Chain of Responsibility design pattern.
- **Track Order**: The system can provide customers tracking their order status dynamically by using the State design pattern.
- **Product Management**: The system can generate different product categories by using the Factory design pattern .

## Technologies and Data Structures Used

- **Programming Language**: Java
- **IDE**: Eclipse
- **Data Structures and Design Patterns**:
  - **List**: Used in Company class for categorize different product types that generated.
  - **Stack Linked List Implementation**: Used in MailBox class for simulating e-mail system in real life.
  - **Object Oriented Programming**: Inheritence,Abstract classes,Interfaces,Encapsulation,Polymorfizm 
 - **Design Patterns**:
    - **Observer Pattern**: Notifies users about promotions or discounts on their subscribed categories.
    - **Visitor Pattern**: Allows a user to shop for a specific category and add the products to the cart.
    - **Mediator Pattern**: Coordinates actions like updating stock, user balance, and company revenue during the checkout process.
    - **Template Pattern**: Standardizes order lifecycle processes such as order confirmation, shipment, and completion.
    - **Chain of Responsibility Pattern**: Routes customer support requests to appropriate departments (e.g., Customer Service, Technical Team, Management).
	- **State Pattern**: Manages the lifecycle states of orders (e.g., Pending, Shipped, Delivered).
	- **Factory Pattern**: Responsible for creating different product categories (e.g., Technology, Books, Clothing).
 
## Usage

- Run the `Driver` class to simulate an E-Commerce System.

## Future Enhancements

- Adding new payment methods such as crypto payment ,paypal payment or credit card payment.
- Implementing a graphical user interface (GUI) for easier interaction.
