package com.service;

import java.util.ArrayList;

import com.dao.OrderDao;
import com.ordersystem.OrderItem;
import com.ordersystem.PurchaseOrder;

public class OrderService {
	OrderDao dao = new OrderDao();

	public void insetOrder(int stockid, int noOfItem, PurchaseOrder po1) {

		OrderItem o1 = new OrderItem(stockid, noOfItem);
		System.out.println("Purchase Id in Purchase class:"+po1.getPoNumber());
		o1.setPurchaseId(po1.getPoNumber());
		dao.addOrder(o1);
		
	}

	public void getorderdetails(ArrayList<Integer> poList) 
	{
		StockService s = new StockService();
		if(poList != null)
		{
			System.out.println("Item No \t\tItem Discription\t\tQuantity of Item");
			
			for (Integer poid : poList) {
				ArrayList<OrderItem> obj = dao.getorderdetails(poid);
				System.out.println("Orders in Purchase Order No "+poid + " is "+ obj.size());
				for (OrderItem orderItem : obj) {
					if(obj != null)
						System.out.println(orderItem.getItemNumber()+"\t\t\t"+s.getItemName(orderItem.getItemNumber())+"\t\t\t\t"+orderItem.getNumberOfItems());
											
				}
				
			}
		}
	}

	public double getOrderDetailsViaPoID(int poNo) {
		
		StockService s = new StockService();
		int itemNo = 0;
		String itemName = null;
		int qty =0;
		double unitPrice = 0.0;
		double subTotal = 0.0;
		double totalSum = 0.0;
		
		ArrayList<OrderItem> obj = dao.getorderdetails(poNo);
	    System.out.println("Description\tCount\tPrice\tSubTotal");
		for (OrderItem orderItem : obj) {
			if(obj != null) 
			{
				itemNo = orderItem.getItemNumber();
				itemName = s.getItemName(orderItem.getItemNumber());
				qty =orderItem.getNumberOfItems();
				unitPrice = s.getUnitPrice(itemNo);
				subTotal = unitPrice * qty ;
				totalSum += subTotal;
	          System.out.println(itemName+"\t\t"+qty+"\t"+unitPrice+"\t"+subTotal);
					
			}		
		}
		
		return totalSum;
		
	}

	

}
