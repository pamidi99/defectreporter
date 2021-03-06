<%-- Include tag is used to import header page --%>
<%@include file="header.jsp" %>
<%-- Section to input login details --%>

<section id="login_form">
    <%-- Code to create login form--%>
    <form action="<c:url value='/UserController/login'/>" method="post">
        <input type="hidden" name="action" value="login">
        <label >Email Address *</label>
        <input type="email" name="email" required/> <br><br>
        <label> Password *</label>
        <input type="password" name="password" required/><br>
        <%
if(session.getAttribute("wrong_uname_pass") != null){
%>
<script>

alert("wrong user name or password");
</script>

<%
session.removeAttribute("wrong_uname_pass");
}

%>
        <label>&nbsp;</label>
        <input type="submit" value="Login" id="login_button" name="login" >
        <br>
    </form>
    <%-- Code to go to Sign up for a new account  --%>
    <a href="signup.jsp" id="sign_up_link">Sign up for a new account</a>

</section>
    <%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp" %>