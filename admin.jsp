
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<nav id="menu">
    <ul>
        
        <li><a href="<c:url value='/admin.jsp'/>">Home</a></li>
        <li><a href="<c:url value='/alldefects.jsp'/>">All Defects</a></li>
        <li><a href="<c:url value='/unsolved.jsp'/>">UnSolved Defects</a></li>
    </ul>
</nav>
<%-- Section tag is used to write description  --%>
<section class="main">
    <img src="<c:url value='/images/nissanlogo.jpg'/>" alt="Home" />

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>