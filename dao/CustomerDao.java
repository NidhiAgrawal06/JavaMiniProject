package com.dao;
//Interacting with database 
//All Sql queries will be executed by this class

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ordersystem.Customer;
import com.util.ConnectionManager;

public class CustomerDao {
	
	Connection cn=ConnectionManager.getConnection();
	public Connection getCn() {
		return cn;
	}
	
	// create customer in database
		public void addcustomer(Customer c){

			try (PreparedStatement pstmt = cn.prepareStatement("insert into Customer(custId,custName) values(?,?)");) {
				pstmt.setInt(1, c.getCustomerNumber());
				pstmt.setString(2, c.getName());					
				int i=pstmt.executeUpdate();
				System.out.println(i + " records inserted....");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
			
		}

		public void setAddress(Customer c) {
			try (PreparedStatement pstmt = cn.prepareStatement("update  customer set Street=? , City= ?,State=?,ZipCode=? where custId=?");)
				{
				pstmt.setString(1, c.getStreet());
				pstmt.setString(2, c.getCity());	
				pstmt.setString(3, c.getState());					
				pstmt.setString(4, c.getZipcode());
				pstmt.setInt(5, c.getCustomerNumber());
				int i=pstmt.executeUpdate();
				System.out.println(i + " records updated....");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		public void setContact(Customer c) {
				try (PreparedStatement pstmt = cn.prepareStatement("update  customer set homePhone = ?, cellPhone=?, workPhone=? where custId = ?");)
				{
				
				pstmt.setString(1, c.getHomePhone());
				pstmt.setString(2, c.getCellPhone());
				pstmt.setString(3, c.getWorkPhone());	
				pstmt.setInt(4,c.getCustomerNumber());
	
				int i=pstmt.executeUpdate();
				System.out.println(i + " records updated....");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
			
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
				//c.setPurchaseOrder(rs.getInt(10));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return c;
		}

		public void setPoOrder(int id) {
			
			
			
		}

		public int getCustomerDetail(int poNo) {
			String qry="select customerId from PurchaseOrder where pONumber=?";
			int custId = 0;
			try (PreparedStatement pstmt = cn.prepareStatement(qry)) {
				pstmt.setInt(1, poNo);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					custId = rs.getInt(1);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return custId;
			
		}


	

}
