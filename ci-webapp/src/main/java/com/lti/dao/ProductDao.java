package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.dao.util.ConnManager;
import com.lti.entity.Product;

//class which maintain DB code are commanly
//reffered to as Data Access Objects
public class ProductDao {
	
	//This method is fetching the data from database
	public Product select(int id) {
		Connection conn = null;
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try {
			conn=ConnManager.connect();
			String sql = "Select * from tb1_product where id =?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("id"));
				return product;
			}
			return null; //very bad should throw an exception indicating that no product found
		}
		catch(SQLException e) {		//ClassNotFoundException | SQLException
			e.printStackTrace();
			return null;	//very bad should throw an exception indicating some problem which trying to fetch data 
		}
		finally {
			try {conn.close(); } catch(Exception e) {}
		}
	}
	
	public List<Product> selectAll(){
		Connection conn = null;
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try {
			conn=ConnManager.connect();
			String sql = "Select * from tb1_product";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> productlist = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				productlist.add(product);
			}
			return productlist; //very bad should throw an exception indicating that no product found
		}
		catch(SQLException e) {		//ClassNotFoundException | SQLException
			e.printStackTrace();
			return null;	//very bad should throw an exception indicating some problem which trying to fetch data 
		}
		finally {
			try {conn.close(); } catch(Exception e) {}
		}
	}
	
	public void insert(Product product) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//step 1. Loading the JDBC Driver
			//For Derby
			conn=ConnManager.connect();
			//System.out.println("Connection Successful...");	
			String sql = "Insert into tb1_product values(?, ?, ?)";
			stmt  = conn.prepareStatement(sql);
			stmt.setInt(1, product.getId()); //replacing ? with actual value
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			int count = stmt.executeUpdate();
			//checking count imporant in case of update/delete statements
			//for ex: if(count == 0) indicates no rows got updated/deleted
		}
		catch(SQLException e) {
			e.printStackTrace(); //detailed report of the Exception
		}
		finally {
			try { conn.close();} catch(Exception e) {}
		}
	}
}
