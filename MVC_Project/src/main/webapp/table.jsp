<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
<h1 style="background-color: green">Data retrival from Database</h1>
<a href=" "><button style="height: 20px; width: 100px" >Update</button></a>
<a href=" "><button style="height: 20px; width: 100px" >Insert</button></a>
<a href=" "><button style="height: 20px; width: 100px" >Delete</button></a>

<table  style="background-color: brown; color:white;width:800px; padding: 20px; margin: 10px;"  border="2">
<tr style="background-color: black; color:white; height: 30px">
<td>ID</td>
<td>Name</td>
<td>Age</td>
<td>Gender</td>
</tr>
<%
Connection connection = null;
Statement statement=null;
ResultSet resultSet = null;
try{	
Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "admin@123");
if(connection!=null){
statement=connection.createStatement();
}
String sql ="select * from StudentPortal";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr style="height: 30px">
<td><%=resultSet.getInt("ID")%></td>
<td><%=resultSet.getString("Name")%></td>
<td><%=resultSet.getInt("Age")%></td>
<td><%=resultSet.getString("Gender")%></td>
</tr>
<%
}
}
catch (Exception e) {
e.printStackTrace();
}
finally{
	try{
	if(resultSet!=null)
	resultSet.close();
	if(connection!=null)
	connection.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
}
%>
</table>
</body>
</html>