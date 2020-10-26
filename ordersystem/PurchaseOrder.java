package com.ordersystem;
import java.sql.Date;

public class PurchaseOrder {
	private int pONumber;
	private int customerId;//fk
	private Date orderDate;
	private Date shipDate;
//	private OrderItem[] items;
	private boolean shipped = false;
	private Customer customer;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	
	//constructor
	public PurchaseOrder(int po , Date od) {
		this.pONumber = po;
		this.orderDate = od;
		this.shipDate = null;
	}
	
	public PurchaseOrder(Date date) {
		this.orderDate = date;
	}

	public PurchaseOrder() {
		// TODO Auto-generated constructor stub
	}

	//getter& Setter
	public int getPoNumber() {
		return pONumber;
	}


	public void setPoNumber(int poNumber) {
		this.pONumber = poNumber;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	//creating purchase  order
//	public void create(int poNumber , Date date)
//	{
//		this.poNumber = poNumber;
//        this.orderDate = date;
//	}
//	
	
	public Customer getCustomer(){
        return this.customer;
    }
    
//    public void setOrderItems(Customer cus, OrderItem... items){
//        this.customer = cus;
//        this.items = items;
//    }
    
	
	//total bill value 
//	public double sumItems()
//	{
//		double sum = 0;     
//        for(OrderItem i: items){
//            sum += i.getTotal();
//        }
//        return sum;
//		
//	}
	public void setShipDate()
	{
		this.shipDate = new Date(System.currentTimeMillis());
	}
	public Date getShipDate() {
		return shipDate;
	}

	public boolean getshipped() {
		this.shipped = true;
		 return true;
	}
		
//	public OrderItem[] getItems()
//	{
//		return items;
//		
//	}
//	public void printInvoice()
//	{
//		System.out.println();
//        System.out.println("***************************************************************");
//        System.out.println("Invoice for Purchase Order Number : "+pONumber);
//        customer.print();
//        System.out.println("Items:---------------------------------------------");
//        System.out.println("Description\tCount\tPrice\tSubTotal");
//        for(OrderItem i: items){
//            System.out.println(i.getStockItem().itemDescription+"\t\t\t"+i.getNumberOfItems()+"\t\t"+i.getStockItem().itemPrice+"\t\t"+i.getTotal());
//        }
//        System.out.println("--------------------------------------");
//        System.out.println("Total Sum\t\t\t"+sumItems());
//        System.out.println("-------------------------------------");
//        System.out.println();
//    }

	

	
}
