package com.ordersystem;

public class OrderItem {
	StockItem stockItem;
	int numberOfItems;
	int itemNumber; //fk
	int purchaseId;//fk
	
	
	//getterSetter
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getNumberOfItems(){
        return this.numberOfItems;
    }
    public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
    
    
	public double getTotal()
	{
        return stockItem.itemPrice * numberOfItems;
	}
	public OrderItem(int itemNumber, int numberOfItems) {
        this.itemNumber = itemNumber ;
        this.numberOfItems = numberOfItems;
    }
    public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	public StockItem getStockItem(){
        return this.stockItem;
    }
    
   

}
