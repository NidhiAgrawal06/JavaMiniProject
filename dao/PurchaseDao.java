package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ordersystem.PurchaseOrder;
import com.util.ConnectionManager;

public class PurchaseDao {
	Connection cn=ConnectionManager.getConnection();
	public Connection getCn() {
		return cn;
	}

	public void create(PurchaseOrder po1, int cid) 
	{
		try (PreparedStatement pstmt = cn.prepareStatement("insert into PurchaseOrder(pONumber,orderDate,shipDate,customerId) values(?,?,?,?)");) {
			pstmt.setInt(1, po1.getPoNumber());
			System.out.println("PO No"+po1.getPoNumber());
			pstmt.setDate(2,po1.getOrderDate());
			pstmt.setDate(3, po1.getShipDate());
			pstmt.setInt(4,po1.getCustomerId());
			int i=pstmt.executeUpdate();
			System.out.println(i + " records inserted....");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void setOrder(PurchaseOrder po1) {
		try (PreparedStatement pstmt = cn.prepareStatement("insert into PurchaseOrderJoin  values(?,?,?)");) {
			pstmt.setInt(1, po1.getPoNumber());
			
			//pstmt.setInt(2,);
			int i=pstmt.executeUpdate();
			System.out.println(i + " records inserted....");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<Integer> getPoList(int id) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		try (PreparedStatement pstmt = cn.prepareStatement("select * from PurchaseOrder where customerId=?");) {
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return list;
		
	}

	public ArrayList<Integer> getOrderBetDate(Date d1, Date d2) {
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		try (PreparedStatement pstmt = cn.prepareStatement("select pONumber from PurchaseOrder where orderDate>=? and orderDate<=? ");) {
			pstmt.setDate(1, d1);
			pstmt.setDate(2,d2);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return list;

		
	}

	public ArrayList<Integer> getOrderOnDate(Date d) {
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		try (PreparedStatement pstmt = cn.prepareStatement("select pONumber from PurchaseOrder where orderDate=? ");) {
			pstmt.setDate(1, d);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return list;
	}

	public void setShipped(int id) {
		PurchaseOrder p = null;
		try (PreparedStatement pstmt = cn.prepareStatement("update  PurchaseOrder set shipped = ? , shipDate= ? where pONumber = ?");)
		{
		p = new PurchaseOrder();
		p.setShipDate();
		pstmt.setBoolean(1,p.getshipped());
		pstmt.setDate(2, p.getShipDate());
		pstmt.setInt(3, id);
		int i=pstmt.executeUpdate();
		System.out.println(i + " records updated....");
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
		
	}

	public ArrayList<Integer> getDelayedOrders() {
		ArrayList<Integer> list = new ArrayList<Integer>() ;
		try (PreparedStatement pstmt = cn.prepareStatement("select pONumber from PurchaseOrder where DATEDIFF(shipDate,orderDate)>4");) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return list;
	}

	public int getMaxOrder() {
		int cid = 0;
		try (PreparedStatement pstmt = cn.prepareStatement("select customerId,count( * ) as cnt from PurchaseOrder GROUP BY customerId order by cnt desc limit 1;");) {
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				cid =(rs.getInt(1));
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return cid;
	}

	public HashMap<Integer, Integer> getMonthWiseOrder() {
		int monthNo;
		int qtyOfPo;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		try (PreparedStatement pstmt = cn.prepareStatement("select month(shipDate) as month_name,count(pONumber) as cnt from PurchaseOrder where year(shipDate)=year(now()) group by month(shipDate);");) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				monthNo =(rs.getInt(1));
				qtyOfPo = rs.getInt(2);
				hmap.put(monthNo, qtyOfPo);
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return hmap;
	}

	public HashMap<Integer, Integer> getMonthWiseSale() {
		int monthNo;
		int sale;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		try (PreparedStatement pstmt = cn.prepareStatement("SELECT MONTH(a.shipDate) AS monthName,SUM(b.numberOfItems * c.itemPrice) AS Total FROM PurchaseOrder AS a JOIN orderItem AS b ON a.pONumber = b.purchaseId  JOIN stockItem AS c on b.itemNumber=c.itemNumber GROUP BY MONTH(a.shipDate);");) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				monthNo =(rs.getInt(1));
				sale = rs.getInt(2);
				hmap.put(monthNo, sale);
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return hmap;
	}

	

}
