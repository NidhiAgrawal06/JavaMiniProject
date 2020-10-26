# JavaMiniProject
This project is based on core java concepts which has mysql database and implemented through the 4 layers dao,util,service,test.There is no framework involved in project and implemention done with on command line of eclipse there is no front end specially developed

**Functionality involved:**
1.  Add New Customer  
2.	Add new Purchase Order  
3.	Add new Stock Item  
4.	Fetch customer based on id 
5.	Fetch Orders placed by specific customers
6.	Fetch orders placed for specific duration
    a.	fetch all orders placed between from and to date inclusive of both date
    b.	fetch all the orders placed for given date
7.	Update order status to ship and update ship date based on order id. 
8.	Fetch delayed orders 
    a.	By default, every order placed by customer should get dispatched within the 4 days after placing the order (inclusive placed date). if order is not dispatched within the 4         days after placing date it should be considered as delayed order
9.	Fetch all stock Items
10.	Find month-wise total orders shipped.   
11.	Find the total amount collected based on months
12.	Find the customer who has made maximum orders.  
13. Generate bill for customer for specific order. 


**Steps to populate Database:**

1.Run all the commands of sqlscript file in SQL command Line.
This will create 4 table namely Customer,PurchaseOrder,StockItem and OrderItem.For understanding relationship between table refer the tableimg/ER-dig.


 

 
