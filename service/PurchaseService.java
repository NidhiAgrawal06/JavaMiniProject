package com.service;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.dao.PurchaseDao;
import com.ordersystem.Customer;
import com.ordersystem.PurchaseOrder;
import com.ordersystem.StockItem;

public class PurchaseService {
	PurchaseDao dao = new PurchaseDao();
	Scanner sc = new Scanner(System.in);
	Month month;

	public void createPOorder(PurchaseOrder po1 ,int cid) 
	{
		po1.setCustomerId(cid);
		System.out.println(po1.getPoNumber());
		dao.create(po1,cid);

		
	}

	public void SetOrder(PurchaseOrder po1) {
		dao.setOrder(po1);
	}

	public void createOrder(PurchaseOrder po1) {
		
		//Displaying stock
		StockService  service = new StockService();
		List<StockItem> s =service.getStock();
		System.out.println(s.size());
		
		System.out.println("*********Available Stock items ************");
		System.out.println("Item Number\t\t\tItem Name");
		for (StockItem stockItem : s) {
			System.out.println(stockItem.getItemNumber() +" ::"+ stockItem.getItemDescription());
		}
		String ch = null;
		do {
		//getting order details
		System.out.println("Enter the Item number of Item which you want to buy:");
		int stockid =  sc.nextInt();
		System.out.println("Enter quantity of item you want to buy:");
		int noOfItem =sc.nextInt();
		
		//creating order
		OrderService serv_Order = new OrderService();
		serv_Order.insetOrder(stockid,noOfItem,po1);
		System.out.println("place another order?(y/n)");
		ch = sc.next();
		}while(ch.contains("y"));
		
		
		
		
	}

	public void getpurchaseOrderList(int id) {
			ArrayList<Integer> poList = dao.getPoList(id);
			System.out.println("--------Total No of purchase Order placed is "+ poList.size()+"--------");
			OrderService serv = new OrderService();
			serv.getorderdetails(poList);
	}

	public void orderBetDate(Date d1, Date d2) {
		ArrayList<Integer> list = dao.getOrderBetDate(d1,d2);
		OrderService serv = new OrderService();
		serv.getorderdetails(list);
		
		
		
	}

	public void gerOrdersOnDate(Date d) {
		System.out.println("Ok1");
		ArrayList<Integer> list1 = dao.getOrderOnDate(d);
		for (Integer integer : list1) {
			System.out.println(integer);
		}
		OrderService serv = new OrderService();
		serv.getorderdetails(list1);
		
	}
	
	public void setShipped(int id) {
		dao.setShipped(id);
	}

	public void getDelayedOrders() {
		ArrayList<Integer> list = dao.getDelayedOrders();
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}

	public void maxOrders() {
			int cid = dao.getMaxOrder();
			CustomerService serv = new CustomerService();
			Customer c = serv.getCustomer(cid);
			System.out.println("Maximum order place by customer "+c.getName());
	}

	public void monthWiseOrder() {
		HashMap<Integer, Integer> hmap = dao.getMonthWiseOrder();
		hmap.entrySet().forEach(entry->{
		    System.out.println("Month Name: "+ getMonth(entry.getKey()) + "  No of Order Placed : " + entry.getValue());  
		 });
	}

	public void getMonthWiseSale() {
		HashMap<Integer, Integer> hmap = dao.getMonthWiseSale();
		hmap.entrySet().forEach(entry->{
		    System.out.println("Month Name: "+ getMonth(entry.getKey()) + "  Sale : " + entry.getValue());  
		 });
	}

	public void printInvoice(int poNo) {
		 	System.out.println();
		 	System.out.println("***************************************************************");
		 	System.out.println("Invoice for Purchase Order Number : "+poNo);
		CustomerService service = new  CustomerService();
		Customer c = service.getCustomerViaPoId(poNo); // getting customer details through Purchase Order id
	      	System.out.println(c);
	      	System.out.println("Items:---------------------------------------------");
		OrderService serv = new OrderService();
		double totalSum = serv.getOrderDetailsViaPoID(poNo);
			System.out.println("--------------------------------------");
			System.out.println("Total Sum\t\t\t"+totalSum);
			System.out.println("-------------------------------------");
			System.out.println();	
	}
	

	public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}

}

 enum Month {

    January(1),
    February(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    September(9),
    October(10),
    November(11),
    December(12);

    private int value;
    Month(int i) {
        this.value = i;
    }

    
    public int getValue(Integer integer) {
        return value;
    }

}
