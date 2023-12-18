package com.jdbc.util;

import java.sql.*;

public class JDBCApp {

	private int id;
	private String name;
	private int age;
	private String gender;
	private int row;
	private PreparedStatement statement;
	private ResultSet result;
	private Connection connect;

	public JDBCApp() {
		super();
	}

	public JDBCApp(int id, String name, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int jdbcRegister() {
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

				row = statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtility.closeResources(connect, statement, result);
		}
		
		return row;
	}

}
