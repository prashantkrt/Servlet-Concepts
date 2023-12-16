package com.studentPortal.model;

import java.sql.*;

public class Model {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String userName;
	private String password;
	private Connection connect;
	private PreparedStatement statement;
	private ResultSet result;
	private int row;

	public Model() {
		//super();
	}

	public Model(int id, String name, int age, String gender, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + age + " " + gender + " " + userName + " " + password;

	}

	public int register() {
		connect = JDBCUtility.getDBConnection();
		String sql = "Insert into MyDB.StudentPortal values(?,?,?,?,?,?)";
		if (connect != null) {
			try {
				statement = connect.prepareStatement(sql);
				if (statement != null) {
					statement.setInt(1, id);
					statement.setString(2, name);
					statement.setInt(3, age);
					statement.setString(4, gender);
					statement.setString(5, userName);
					statement.setString(6, password);
				}
				row = statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtility.closeResources(connect, statement, null);
			}
		}
		return row;
	}

	public int login() {
		connect = JDBCUtility.getDBConnection();
		int rowCount = 0;
		String sql = "Select UserName,Password from MyDB.StudentPortal where UserName =? ";
		if (connect != null) {
			try {
				statement = connect.prepareStatement(sql);
				if (statement != null) {
					statement.setString(1, userName);
				}
				result = statement.executeQuery();
				
				if (result != null) {
					while (result.next()) {
						userName = result.getString("UserName");
						password = result.getString("Password");
						rowCount++;
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtility.closeResources(connect, statement, null);
			}			
		}
		return rowCount;
	}
}
