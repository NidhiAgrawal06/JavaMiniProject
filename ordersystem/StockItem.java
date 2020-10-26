package com.psl.training.ordersystem;

public class StockItem 
{
	int itemNumber;
	String itemDescription;
	double itemPrice;
	
	public StockItem(int itemNumber , String itemDescription ,double price) {
		this.itemDescription = itemDescription;
		this.itemNumber = itemNumber;
		this.itemPrice = price;
	}
	
	public int getQauntity()
	{	
		return 1 ;
	}
	

}
