package com.tester;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.ConnectionManager;

public class BasicDemo {

	public static void main(String[] args) {
		// getting connection
				
		try {
					Connection con=ConnectionManager.getConnection();
					System.out.println(con);
					
					Statement st = con.createStatement();
					PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?)");					
					
					
					
			} catch (SQLException e) {
					e.printStackTrace();
			}
				

	}

}
