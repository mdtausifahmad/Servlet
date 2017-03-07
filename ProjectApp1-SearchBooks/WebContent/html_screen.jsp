<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
 <c:when test="${booksList ne null }">
   <table>
    <tr><th>BookId</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th></tr>
    <c:forEach var="dto" items="${booksList}">
       <tr>
         <td>${dto.bookId}</td>
         <td>${dto.bookName}</td>
         <td>${dto.author}</td>
         <td>${dto.status}</td>
         <td>${dto.category}</td>
         </tr>
    </c:forEach>
   </table>
 </c:when>
 <c:otherwise>
   <h1>No Books Found</h1>
 </c:otherwise>
</c:choose>







<%-- <%@page import="java.util.*,com.nt.dto.BookDTO"%>

<script language="JavaScript">
   function showPrint(){
     frames.focus();
     frames.print();
   }
</script>

<%//read request attribute  value
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
              <a href='javascript:showPrint()'>print</a>
          <% }
          else{
          %>
            <h1 style='color:red;text-align:center'>No Books Found</h1>
            <% }%>
            <br>
      <a href="search.html">home</a>
       --%>