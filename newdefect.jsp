
<%@page import="com.bhanu.data.UserDB"%>
<%@page import="com.bhanu.business.User"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display Page Name --%>
<h3><span id="page_name">Adding a New Defect</span></h3>
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

<section id="newstudy_form">
         
<form action="<c:url value='/DefectController/add'/>" method="post">
        <label>Defect Title *</label>
        <input type="text" name="title" required /><br>
        <label>Model *</label> 
        <select id="drop" name="model" >
  <option value="Altima" id="drop">Altima</option>
  <option value="Maxima" id="drop">Maxima</option>
  <option value="PathFinder" id="drop">PathFinder</option>
        </select><br><br>
        <div id="my_div"></div><br>
        <label>Description *</label>  
        <textarea name="description" required></textarea><br>
        <button type="submit"  id="submit_button">Submit</button>
    </form>
</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>