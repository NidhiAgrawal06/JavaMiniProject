package com.ordersystem;

public class StockItem 
{
	int itemNumber;
	String itemDescription;
	double itemPrice;
	
	public StockItem(String string, double d) {
		this.itemDescription = string;
		this.itemPrice = d;
	}
	
	public StockItem(int itemNumber , String itemDescription ,double price) {
		this.itemDescription = itemDescription;
		this.itemNumber = itemNumber;
		this.itemPrice = price;
	}
	
	public StockItem() {
	}

	//getter & Setter
	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQauntity()
	{	
		return 1 ;
	}

	@Override
	public String toString() {
		return "StockItem [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + "]";
	}

	
	

}
