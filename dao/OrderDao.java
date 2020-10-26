package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ordersystem.OrderItem;
import com.util.ConnectionManager;

public class OrderDao {
	Connection cn=ConnectionManager.getConnection();
	public Connection getCn() {
		return cn;
	}
	public void addOrder(OrderItem o1) {
		try (PreparedStatement pstmt = cn.prepareStatement("insert into OrderItem(numberOfItems,itemNumber,purchaseId) values(?,?,?)");) {
			pstmt.setInt(1, o1.getNumberOfItems());
			pstmt.setInt(2, o1.getItemNumber());
			System.out.println("Purchase Order no :"+o1.getPurchaseId());
			pstmt.setInt(3, o1.getPurchaseId());					
			int i=pstmt.executeUpdate();
			System.out.println(i + " records inserted....");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public ArrayList<OrderItem> getorderdetails(int poid) {
		ArrayList<OrderItem> list = new ArrayList<OrderItem>() ;
			OrderItem obj = null;
		try (PreparedStatement pstmt = cn.prepareStatement("select numberOfItems,itemNumber from OrderItem where purchaseId = ? ");) {
			pstmt.setInt(1, poid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				obj=new OrderItem();
				obj.setNumberOfItems(rs.getInt(1));
				obj.setItemNumber(rs.getInt(2));
				list.add(obj);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	
	

}
