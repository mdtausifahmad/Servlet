<%@page import="nl.captcha.Captcha"%>

<%
//get Capacha objeect from session attribute
Captcha captcha=(Captcha)session.getAttribute(Captcha.NAME);
 //get ur  answer
String answer=request.getParameter("answer");

if(captcha.isCorrect(answer))
out.println("Correct");
else
 out.println("Incorrect");
%>