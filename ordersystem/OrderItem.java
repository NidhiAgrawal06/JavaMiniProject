package com.psl.training.ordersystem;

public class OrderItem {
	StockItem stockItem;
	int numberOfItems;
	
	public double getTotal()
	{
        return stockItem.itemPrice * numberOfItems;
	}
	public OrderItem(StockItem stockItem, int numberOfItems) {
        this.stockItem = stockItem;
        this.numberOfItems = numberOfItems;
    }
    public StockItem getStockItem(){
        return this.stockItem;
    }
    public int getNumberOfItems(){
        return this.numberOfItems;
    }
   

}
