package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */

public class AddProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		
		ProductDao dao = new ProductDao();
		dao.insert(p);
		response.setContentType("text/html");
		response.getWriter().write("Product added successfully. <a href='addProduct.jsp'>Click here</a>to add more products");
	}

}
