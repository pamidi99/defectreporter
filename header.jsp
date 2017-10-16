

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- title of the Page--%>
       
        <title>Nissan Car Defect Reporting</a</title>
        
        <%-- importing CSS stylesheet --%>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/>" >                                         
        
    </head>
    <body>
        <%-- Code to specify Header section of the page--%>
        <div id="header">
            <nav id="header_menu">
                <% if(session.getAttribute("theUser")!=null){ %>
                    <a href="<c:url value='/UserController?action=home'/>">Nissan Car Defect Reporting</a>
                    <% } %>
                </ul>
                <ul class="right">
                   
                    <% if(session.getAttribute("theAdmin")==null && session.getAttribute("theUser")==null ) {%>
                                                <li><a href="<c:url value='/login.jsp'/>">Login</a></li>
                        <% } else {%>   
       
                       
                        
                        <% if(session.getAttribute("theAdmin")!=null) { %>
                         <li> Hello <c:out value="${theAdmin.getUsertype()}" /></li>
                         <% } else {%>
               
                         <li> Hello <c:out value="${theUser.getUsername()}" /></li>
                       <% } %>
                         <%} %>
                         <% if(session.getAttribute("theUser")!=null || session.getAttribute("theAdmin")!=null) { %>
                         <li><a href="<c:url value='/UserController?action=logout'/>">Logout</a></li>
                         <% } %>
                </ul>
            </nav>



        </div>
                <div id="bod">