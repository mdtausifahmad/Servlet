<%@page isELIgnored="false" %>
<form action="regurl"  method="post">
   Name: <input type="text" name="name"/><br>
    age :<input type="text"  name="age"/><br>
    <input type="hidden"  name="cToken" value="${sessionScope.serverToken}"/> 
    <input type="submit"  value="send"/>
</form>