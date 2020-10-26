package com.ordersystem;

public class CustomerTest {

	public static void main(String[] args) {
		Customer obj1 = new Customer(1,"Jamie");
		Customer obj2 = new Customer(2, "Bill");
		Customer obj3 = new Customer(3, "Joe");		
		
//		StockItem milk = new StockItem(1,"Milk",20);
//		StockItem chicken = new StockItem(1,"Chicken",100);
//		StockItem apple = new StockItem(1,"Apple",40);
//		StockItem egg = new StockItem(1,"Egg",5);
//		StockItem orange = new StockItem(1,"Orange",30);


		
		
		System.out.println("----Object 3 Details-----");
		//obj3.setPhoneNumber("07267222111", "985236471","874596321");
		//obj3.setPrintingAddress("Telephone Colony","Pune","Maharashtra","440148");
		obj3.print();
		System.out.println("------Object 2 Details-----");
		obj2.printPhoneNumber();
		System.out.println("-----Object1 Details-----");
		obj1.print();
	}

}
