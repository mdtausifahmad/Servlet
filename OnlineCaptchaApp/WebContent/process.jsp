<%@ page import="net.tanesha.recaptcha.ReCaptchaImpl"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaResponse"%>
 
<html>
<body>
    <%
    //get IP addres of client machine
        String remoteAddr = request.getRemoteAddr();
        
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LdGYgkUAAAAACiz_j_fHcNePK_b6hSEZCOQMeby");
 
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
 
        if (reCaptchaResponse.isValid()) 
        {
            out.print("Answer was entered correctly!");
        } else
        {
            out.print("Answer is wrong");
        }
    %>
</body>
</html>