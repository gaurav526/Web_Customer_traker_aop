package com.testConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestConnection
 */
@WebServlet("/TestConnection")
public class TestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestConnection() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set up connection variables
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String pass = "springstudent";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		PrintWriter out = response.getWriter();
		 out.println("connecting to DB "+url);
		 
		 try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 out.println("success");
		 try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
