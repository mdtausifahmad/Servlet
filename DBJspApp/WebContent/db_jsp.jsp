<%@page import="java.sql.*" %>
<%!
 Connection con=null;
    PreparedStatement ps1=null,ps2=null;
    ResultSet rs=null;
  public void jspInit(){
    ServletConfig cg=null;
    String driver=null,url=null,user=null,pwd=null;
   
    //get SevletConfig 
    cg=getServletConfig();
    //read init param values fromw web.xml file
    driver=cg.getInitParameter("driver");
    url=cg.getInitParameter("url");
    user=cg.getInitParameter("dbuser");
    pwd=cg.getInitParameter("dbpwd");
   //create jdbc con , PrpearedStatement objs
   try{
      Class.forName(driver);
      con=DriverManager.getConnection(url,user,pwd);
      ps1=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
      ps2=con.prepareStatement("SELECT * FROM STUDENT");
   }//try
   catch(SQLException se){
   se.printStackTrace();
  }
  catch(Exception e){
   e.printStackTrace();
    }
  }//jspInit()
 %>
 <%
    String pval=null;
    int no=0;
    String name=null,addrs=null;
    int result=0;
    
    //read "s1" request parameter value
    pval=request.getParameter("s1");
    if(pval.equalsIgnoreCase("register")){
       //read form data
        no=Integer.parseInt(request.getParameter("sno"));
        name=request.getParameter("sname");
        addrs=request.getParameter("sadd");
        //set values to Query params
        ps1.setInt(1,no);
        ps1.setString(2,name);
        ps1.setString(3,addrs);
        //execute the Query
        result=ps1.executeUpdate();
        if(result==0){%>
          <h1><center> Registrration failed</center></h1>
         <% }
           else{  %>
            <h1><center> Registrration success</center></h1>
           <% }
     }//if
    else{   // for hyperlink
         //execute query
         rs=ps2.executeQuery(); %>
         <table border="1">
           <tr><th>sno</th><th>sname</th><th>sadd</th></tr>
    
         <%    while(rs.next()){ %>
             <tr>
              <td><%=rs.getInt(1)%></td>
             <td><%=rs.getString(2)%></td>
             <td><%=rs.getString(3)%></td>
             </tr>
         <%   } %>         
          </table>
   <% }//else
     %>
      <a href="input.html">home</a>
     
     
     <%! public void jspDestroy(){
         //close jdbc objs
               try{
            if(rs!=null)
                 rs.close();
           }//try
           catch(SQLException  se){
              se.printStackTrace();
           }
           try{
            if(ps1!=null)
                 ps1.close();
           }//try
           catch(SQLException  se){
              se.printStackTrace();
           }
           
           try{
            if(ps2!=null)
                 ps2.close();
           }//try
           catch(SQLException  se){
              se.printStackTrace();
           }
           
           try{
            if(con!=null)
                 con.close();
           }//try
           catch(SQLException  se){
              se.printStackTrace();
           }
        }//jspDestroy()
      %>

