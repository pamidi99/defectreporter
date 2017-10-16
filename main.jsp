<%@page import="com.bhanu.data.UserDB"%>
<%@page import="java.util.List"%>
<%@page import="com.bhanu.business.User"%>
<%@page import="com.bhanu.business.User"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        <% if(session.getAttribute("theUser")!=null){
          User user = (User) session.getAttribute("theUser");
            UserDB.getuserbyemail(user.getEmail());
          
        
        %>
        <li><a href="<c:url value='/main.jsp'/>"> Home</a></li>
        <li><a href="<c:url value='/defects.jsp'/>">Your Reported Defects</a></li>
        <li><a href="<c:url value='/newdefect.jsp'/>">Add New Defect</a></li>
        
    </ul>
</nav>
        <% } %>

<%-- Section tag is used to write description  --%>
<section>
    <img src="<c:url value='/images/nissanlogo.jpg'/>" alt="Home" />
    
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>