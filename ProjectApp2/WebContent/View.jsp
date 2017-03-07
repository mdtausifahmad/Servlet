<%@page import="java.io.File,java.util.*,java.sql.*"%>

<!-- Retrive records from DB table -->
<H1>List of All files under C:\store</H1>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
PreparedStatement ps=con.prepareStatement("select * from EmployeeReg");
ResultSet rs=ps.executeQuery();
%>

<!-- display employee details as html table content-->
<body bgcolor=wheat>
<table border=1>
<tr><td>Employee Name</td><td>Employee Address</td><td>Employee Resume</td><td>Employee Photo</td></tr>

<%
while(rs.next())
{
%>
	<tr>
	  <td><%=rs.getString(2)%></td>
	  <td><%=rs.getString(3)%></td>
	  <td><a href='Download.jsp?resumeId=<%=rs.getString(1)%>'>Download Here</a></td>
	  <td>
	     <img src="<%=rs.getString(5)%>" width="200" height="100"/> <br>
	    <a href='Download.jsp?photoId=<%=rs.getString(1)%>'>Download Here</a>
	  </td>
	 </tr>
<%} %>			

  </table>
</body>