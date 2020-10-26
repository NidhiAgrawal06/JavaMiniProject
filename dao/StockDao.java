package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ordersystem.StockItem;
import com.util.ConnectionManager;

public class StockDao {
	Connection cn=ConnectionManager.getConnection();
	public Connection getCn() {
		return cn;
	}
	
	//add Stock in Database
	public void addStock(StockItem s) 
	{
		try (PreparedStatement pstmt = cn.prepareStatement("insert into StockItem values(?,?,?)");) {
			pstmt.setInt(1,s.getItemNumber() );
			pstmt.setString(2,s.getItemDescription() );	
			pstmt.setDouble(3,s.getItemPrice());
			int i=pstmt.executeUpdate();
			System.out.println(i + " records inserted....");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	public List<StockItem>  getStock() {
		String qry="select * from StockItem";
		StockItem s=null;
		List<StockItem> stocklist =  new ArrayList<StockItem>();

		try (PreparedStatement pstmt = cn.prepareStatement(qry))
		{
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
			s=new StockItem();		
			s.setItemNumber(rs.getInt(1));
			s.setItemDescription(rs.getString(2));
			s.setItemPrice(rs.getDouble(3));
			stocklist.add(s);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return stocklist;
		
	}

	public String getName(int stockid) {
		String name = null;
		String qry="select itemDescription from StockItem where itemNumber=?";
		try (PreparedStatement pstmt = cn.prepareStatement(qry)) {
			pstmt.setInt(1, stockid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
			name = rs.getString(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return name;
	}

	public double getUnitPrice(int stockid) {
		double unitPrice =0.0;
		String qry="select itemPrice from StockItem where itemNumber=?";
		try (PreparedStatement pstmt = cn.prepareStatement(qry)) {
			pstmt.setInt(1, stockid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
			unitPrice = rs.getDouble(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return unitPrice;
		
	}
	
	
	

}
