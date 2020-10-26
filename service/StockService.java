package com.service;

import java.util.List;

import com.dao.StockDao;
import com.ordersystem.StockItem;

public class StockService {
	
	
	StockDao dao = new StockDao();
	
	public void insertStock(StockItem s)
	{
		dao.addStock(s);
	}

	public List<StockItem> getStock() {
		return dao.getStock();		
	}
	
	public String getItemName(int stockid)
	{
		return dao.getName(stockid);
	}

	public double getUnitPrice(int itemNo) {
		return dao.getUnitPrice(itemNo);
	}

}
