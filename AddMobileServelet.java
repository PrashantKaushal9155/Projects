package com.jsp.servelet.mobile_management_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

@WebServlet("/add-Mobile")
public class AddMobileServelet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int mobileId=Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel=req.getParameter("mobileModel");
		String mobileBrand=req.getParameter("mobileBrand");
		int mobilePrice=Integer.parseInt(req.getParameter("mobilePrice"));
		
		//JDBC Steps
		Connection conn=null;
//		String message = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system?user=root&password=Suman@123");
			
			PreparedStatement pst = conn.prepareStatement("Insert into mobile values(?,?,?,?)");
			
			pst.setInt(1, mobileId);
			pst.setString(2, mobileModel);
			pst.setString(3, mobileBrand);
			pst.setInt(4, mobilePrice);
			
			pst.execute();
			
//			int rowInserted = pst.executeUpdate();
//			
//			if(rowInserted>0)
//				message = "Mobile added successfully";
//			else
//				message = "Error adding mobile";
			resp.sendRedirect("addMobile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			if(conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//URL encode the message to safely include it in the redirect URL
//		String encodedMessage = URLEncoder.encode(message, "UTF-8");
		
		//Redirect to the JSP page with the message as a query parameter
//		resp.sendRedirect("result.jsp?message="+encodedMessage);
		
	}

}
