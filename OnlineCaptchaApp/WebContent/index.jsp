<%@ page import="net.tanesha.recaptcha.ReCaptcha,net.tanesha.recaptcha.ReCaptchaFactory"%>
 
<html>
<body>
    <form action="process.jsp" method="post">
        <%
          //ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
          ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LdGYgkUAAAAAIQxnoy4Px9GeQ8FkmBCdvCPxFza", "6LdGYgkUAAAAACiz_j_fHcNePK_b6hSEZCOQMeby", false);
          out.print(captcha.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
    </form>
</body>
</html>
