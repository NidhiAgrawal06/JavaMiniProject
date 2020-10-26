package com.psl.training.ordersystem;

import java.util.Date;

//import java.sql.Date;

public class PurchaseOrder {
	private int poNumber;
	private Date orderDate;
	private Date shipDate;
	private OrderItem[] items;
	private boolean shipped = false;
	private Customer customer;
	
	
	//creating customer
	public void create(int poNumber , Date orderDate)
	{
		this.poNumber = poNumber;
        this.orderDate = orderDate;
	}
	
	
	public Customer getCustomer(){
        return this.customer;
    }
    
    public void setOrderItems(Customer cus, OrderItem... items){
        this.customer = cus;
        this.items = items;
    }
    public void ship(){
        this.shipped = true;
    }   
    
    
	public boolean isShipped()
	{
		return true;
	}
	
	//total bill value 
	public double sumItems()
	{
		double sum = 0;     
        for(OrderItem i: items){
            sum += i.getTotal();
        }
        return sum;
		
	}
	public void setShipDate(Date date)
	{
		this.shipDate = date;
	}
		
	public OrderItem[] getItems()
	{
		return items;
		
	}
	public void printInvoice(){
		System.out.println();
        System.out.println("***************************************************************");
        System.out.println("Invoice for Purchase Order Number : "+poNumber);
        customer.print();
        System.out.println("Items:---------------------------------------------");
        System.out.println("Description\tCount\tPrice\tSubTotal");
        for(OrderItem i: items){
            System.out.println(i.getStockItem().itemDescription+"\t\t\t"+i.getNumberOfItems()+"\t\t"+i.getStockItem().itemPrice+"\t\t"+i.getTotal());
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Sum\t\t\t"+sumItems());
        System.out.println("-------------------------------------");
        System.out.println();
    }

}
