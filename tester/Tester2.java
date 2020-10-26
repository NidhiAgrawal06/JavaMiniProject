package com.tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

import com.ordersystem.Customer;
import com.ordersystem.PurchaseOrder;
import com.ordersystem.StockItem;
import com.service.CustomerService;
import com.service.PurchaseService;
import com.service.StockService;

public class Tester2 
{
	public static Date readDate()
	{
		Scanner sc = new Scanner(System.in);
//		String pattern = "yyyy-MM-dd";
		System.out.println("Enter Date in format YYYY-MM-DD");
		String input = sc.next();
		Date date = Date.valueOf(input);
		return date;
	}

	public static void main(String[] args) {
		
		String conti = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("*********Order Management System***********\n");
			System.out.println("1. Add New Customer");
			System.out.println("2. Create Purchase Order");
			System.out.println("3. Add Stock Item");
			System.out.println("4. Show Customer Details through id");
			System.out.println("5.Fetch Orders placed by specific customers");
			System.out.println("6.Fetch all orders placed between from and to date inclusive of both date");
			System.out.println("7.Fetch all the orders placed for given date");
			System.out.println("8.Update order status to ship and update ship date based on order id");
			System.out.println("9.Fetch delayed orders ");
			System.out.println("10. Show Stock Details");
			System.out.println("11.Find month-wise total orders shipped.");
			System.out.println("12.Find the total amount collected based on months");
			System.out.println("13.Find the customer who has made maximum orders");
			System.out.println("14.Genrate Bill");
			System.out.print("\nEnter you choice ::");
			int ch = sc.nextInt();
			switch (ch) {
				case 1:
				{
					System.out.println("Enter Customer Name:");
					String name = sc.next();
					CustomerService  service1 = new CustomerService();
					Customer c1 = new Customer(name);
					service1.insertCustomer(c1);
					//service1.setContact(c1);
					//service1.setAddress(c1);
					break;
					
				}
				case 2:
				{
					//getting customer id
					System.out.println("Enter Customer ID:");
					int cid = sc.nextInt(); //1
					//creating new po obj
					PurchaseService service3 = new PurchaseService();
					System.out.println("Enter Purchase Order no :");
					int no = sc.nextInt();
					PurchaseOrder po1 = new PurchaseOrder(no,new java.sql.Date(System.currentTimeMillis()));
					service3.createPOorder(po1, cid);
					//order creation
					service3.createOrder(po1);
					
					
					break;
				}
				case 3:
				{
					StockService service2 = new StockService();
					System.out.println("Enter Item Name:");
					String s =sc.next();
					System.out.println("Enter Price for Item");
					double d = sc.nextDouble();
					StockItem s1 = new StockItem(s,d);
					service2.insertStock(s1);
					break;
				}
				case 4:
				{
					System.out.println("Enter Customer Id:");
					int id = sc.nextInt();
					CustomerService  service1 = new CustomerService();
					Customer obj = service1.getCustomer(id);
					System.out.println(obj);
					break;
				}
				case 5:
				{
					System.out.println("Enter Customer Id:");
					int id = sc.nextInt();
					PurchaseService s = new PurchaseService();
					s.getpurchaseOrderList(id);
					break;
					
				}
				case 6 :
				{
					Date d1 = readDate();
					Date d2 = readDate();
					PurchaseService serv = new PurchaseService();
					serv.orderBetDate(d1,d2);
					break;
				}
				case 7 :
				{
					Date d = new Date(2020-10-06);
					PurchaseService serv = new PurchaseService();
					serv.gerOrdersOnDate(d);
					break;
				}
				case 8 :
				{
					System.out.println("Enter Purchase Order Id to be shipped");
					int id = sc.nextInt();
					PurchaseService serv = new PurchaseService();
					serv.setShipped(id);
					break;
				}
				case 9:
				{
					PurchaseService serv = new PurchaseService();
					serv.getDelayedOrders();
					break;
				}
				case 10:
				{
					
					StockService  service = new StockService();
					List<StockItem> s =service.getStock();
					System.out.println(s.size());
					for (StockItem stockItem : s) {
						System.out.println(stockItem);
					}
					break;
				}
				case 11:
				{
					PurchaseService serv = new PurchaseService();
					serv.monthWiseOrder();
					break;
				}
				case 12:
				{
					PurchaseService serv = new PurchaseService();
					serv.getMonthWiseSale();
					break;
				}
				case 13 :
				{
					PurchaseService serv = new PurchaseService();
					serv.maxOrders();
					break;
				}
				case 14 :
				{
					PurchaseService serv = new PurchaseService();
					System.out.println("Enter the Purchase Order no : ");
					int poNo  = sc.nextInt();
					serv.printInvoice(poNo);
					break;
				}
	
				default:
				{
					System.out.println("Wrong Choice!!");
					break;
				}
			}
			System.out.println("Do you want to continue (yes/no) ");
			conti = sc.next();		
			
		}while(conti.contains("y"));
		 
		
		
		sc.close();
	}
	

}
