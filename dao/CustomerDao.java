package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ordersystem.Customer;
import com.util.ConnectionManager;

public class CustomerDao {

	Connection cn = ConnectionManager.getConnection();
	
	public void addCustomer() {
		
	}
	
	public Customer getCustomer(int id) {
		String qry="select * from customer where custId=?";
		Customer c=null;
		try (PreparedStatement pstmt = cn.prepareStatement(qry)) {
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
			c=new Customer();		
			c.setCustomerNumber(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setHomePhone(rs.getString(3));
			c.setCellPhone(rs.getString(4));
			c.setWorkPhone(rs.getString(5));
			c.setStreet(rs.getString(6));
			c.setState(rs.getString(7));
			c.setCity(rs.getString(8));
			c.setZipcode(rs.getString(9));
			c.setPurchaseOrder(rs.getInt(10));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return c;
	}

}
