package com.jsp.servelet.mobile_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-mobile")
public class DeleteMobileServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int mobileId=Integer.parseInt(req.getParameter("mobileId"));
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile_management_system?user=root&password=Suman@123");
		
			PreparedStatement pst = conn.prepareStatement("Delete from mobile where mobileId=?");
			pst.setInt(1, mobileId);
			
			pst.executeUpdate();
			
//			int rowsDeleted = pst.executeUpdate();
			
//			if(rowsDeleted>0)
//			{
//				resp.getWriter().println("Mobile deleted successfully!");
//			}
//			else
//			{
//				resp.getWriter().println("No Mobile found with the provided Id.");
//			}
			
			resp.sendRedirect("display-all-mobiles");
		} catch (ClassNotFoundException | SQLException e) {
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
		
	}

}
