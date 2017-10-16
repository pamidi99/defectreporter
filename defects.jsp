
<%@page import="com.bhanu.data.UserDB"%>
<%@page import="com.bhanu.business.Defect"%>
<%@page import="com.bhanu.data.DefectDB"%>
<%@page import="com.bhanu.business.User"%>
<%@page import="java.util.List"%>
<%-- Include tag is used to import header page --%>
<%@ include file="header.jsp" %>



 
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

 
<%-- Section to display studies details --%> 
<%-- Clicking on Start, Stop to Participate in that study and  Edit button to display edit page and edit study details in it--%>
<section id="studies_section">


    <table id="your_studies_table" >
        <tr>
            <th id="Study">Defect Title</th>
            <th>Defect Model</th>		
            <th>Description</th>
            <th>Status</th>
        </tr>
        
        <% 
            User user = (User) session.getAttribute("theUser");
            if(session.getAttribute("theUser")!=null){
               
            List<Defect> defectRecords = DefectDB.getAllMyDefects(user.getEmail());
            for(Defect defectRecord : defectRecords){ %>
            <%if(defectRecord!=null){ 
            
            
            %>
       <td><%= defectRecord.getDefectTitle()%></td>
       <td><%= defectRecord.getModel() %></td>
       <td><%= defectRecord.getDefectDescription()%></td>
       <td><%= defectRecord.getDefectStatus()%></td>
        </tr>
                
                
          <%  }    
            }

            
        }  
else { %>

<p>not displaying</p>
<%

}        %>    
        <tr>
           

    
      
    </table>

</section>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>