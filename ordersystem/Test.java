/*Problem Statement:
1.Create StockItem class
2. Create PurchaseOrder class
3. Create OrderItem class
4. Create Test class that does the following - 
1. Create 3 customers - Jamie, Bill, Joe
2. Create 5 items - Milk, Chicken, Egg, Apple and Orange
3. Create 3 Purchase Orders. 2 for Jamie, 1 for Bill and None for Joe.
1. PO 1 - 2 gallons Milk, 2 lbs Chicken and 12 eggs.
2. PO 2 - 5 apples and 10 oranges
3. PO 3 - 5 Lbs chicken and 10 apples
4. Get all the orders to be shipped and print labels
5. Ship first order for Jamie
6. Ship Bill’s order
7. Ship Jamie’s order
8. Print total sales by customer
9. Print all invoices (include customer, Order date, line items with count and price,
sum for the invoice at the bottom)
*/



package com.psl.training.ordersystem;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		
//			System.out.println("-----------------------------Order Management System---------------------------------------");
//	        //Creating 3 customers
//	        Customer jamie = new Customer(1001, "Jamie");
//	        Customer bill = new Customer(1002, "Bill");
//	        Customer joe = new Customer(1003, "Joe");
//	        
//	        //address for each customer
//	        jamie.setPrintingAddress("Kondhwa", "Pune", "Maharashtra", "440148");
//	        jamie.setPhoneNumber("14523698", "84516239", "8806596125");
//	        
//	        bill.setPrintingAddress("Hinjewadi", "Pune", "Maharashtra", "421452");
//	        bill.setPhoneNumber("874596230", "7412589630", "8451263987");
//	        
//	        joe.setPrintingAddress("Baner", "Malkapur", "Maharashtra", "443101");
//	        joe.setPhoneNumber("7849562130", "9147852369", "8795462101");
//	    
//	        //5 items in stock
//	        StockItem milk = new StockItem(2001, "Milk", 21.0);
//	        StockItem chicken = new StockItem(2002, "Chicken", 140.0);
//	        StockItem egg = new StockItem(2003, "Egg", 6.0);
//	        StockItem apple = new StockItem(2004, "Apple", 20.0);
//	        StockItem orange = new StockItem(2005, "Orange", 16);
//	        
//	        
//	        //3 purchase orders
//	        PurchaseOrder po1 = new PurchaseOrder();
//	        po1.create(101, new Date(2020 - 1900, 8, 1));
//	        po1.setOrderItems(jamie, new OrderItem(milk, 2), new OrderItem(chicken, 2), new OrderItem(egg, 12));
//	        po1.setShipDate(new Date());
//	        
//	        PurchaseOrder po2 = new PurchaseOrder();
//	        po2.create(102, new Date(2020 - 1900, 8, 2));
//	        po2.setOrderItems(jamie, new OrderItem(apple, 5), new OrderItem(orange, 10));
//	        po2.setShipDate(new Date());
//	        
//	        PurchaseOrder po3 = new PurchaseOrder();
//	        po3.create(103, new Date(2020 - 1900, 8, 5));
//	        po3.setOrderItems(bill, new OrderItem(chicken, 5), new OrderItem(apple, 10));
//	        po3.setShipDate(new Date());
//	        
//	        
//	        //Shipping Orders
//	        po1.ship();
//	        if(po1.isShipped())
//	            System.out.println("Jamie's 1st order is shipped.");
//	        po2.ship();
//	        if(po2.isShipped())
//	            System.out.println("Jamie's 2nd order is shipped.");	        
//	        po3.ship();
//	        if(po3.isShipped())
//	            System.out.println("Bill's 1st order is shipped.");
//	        
//	        
//	        
//	        //total sales
//	        double totalSale = po1.sumItems() + po2.sumItems() + po3.sumItems();	        
//	        System.out.println("Total Sales: "+totalSale);
//	        
//	        //Invoices
//	        po1.printInvoice();
//	        po2.printInvoice();
//	        po3.printInvoice();       
//	        System.out.println("***************************************************************");
//	}

}
}
