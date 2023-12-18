package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.util.JDBCUtility;

import java.sql.*;

@WebServlet("/Reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");

		PrintWriter writer = response.getWriter();
		PreparedStatement statement = null;
		ResultSet result = null;
		Connection connect = null;

		try {
			connect = JDBCUtility.getDBConnection();
			if (connect != null) {
				statement = connect.prepareStatement("Insert into studentDetail values(?,?,?,?)");
			}
			if (statement != null) {
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setInt(3, age);
				statement.setString(4, gender);

				int noOfRowsAffected = statement.executeUpdate();

				if (noOfRowsAffected != 0) {
					writer.println("Registration successfull!!");
				} 
				else {
					writer.println("Failed to register");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtility.closeResources(connect, statement, result);
		}

	}

}
