<%@page import="java.util.*,com.nt.dto.BookDTO"%>

<%
  // make response of this jsp as downloadble excel file
     response.setContentType("application/vnd.ms-excel");
     response.addHeader("Content-Disposition","attachment;fileName=Titltes.xls");
//read request attribute  value
      List<BookDTO> listDTO=null;
      listDTO=(List<BookDTO>)request.getAttribute("booksList"); 
      //Display db table having records
      if(listDTO.size()!=0){ %>
       <h1 style='text-align:center'> Books Report for <%=request.getParameter("category") %></h1>
       <table border="1">
        <tr>
          <th>BookId</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th>
         </tr> 
        <%
           for(BookDTO dto:listDTO){ %>
            <tr>
              <td><%=dto.getBookId() %></td>
              <td><%=dto.getBookName() %></td>
               <td><%=dto.getAuthor() %></td>
               <td><%=dto.getStatus() %></td>
               <td><%=dto.getCategory() %></td>
             </tr>
             <% }%>
            </table>
          <% }
          else{
          %>
            <h1 style='color:red;text-align:center'>No Books Found</h1>
            <% }%>
      