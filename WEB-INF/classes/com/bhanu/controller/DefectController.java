/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhanu.controller;

import com.bhanu.business.Defect;
import com.bhanu.business.User;
import com.bhanu.data.DefectDB;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bhanu
 */
public class DefectController extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String url="";
          String action = request.getParameter("action");
        if (action == null || action.isEmpty() ) {
              url = "/main.jsp";
        }
        else if(action.equals("Alldefects")){
            url = "/defects.jsp";  
        }else if(action.equals("AllUnSolvedDefects")){
            url = ""; 
        }else if(action.equals("myDefects")){
            url = "/defects.jsp"; 
        }
        
        else if(action.equals("deleteDefect")){
            
        }
        else if(action.equals("solveDefect")){
            
        }
        

        // perform action and set URL to appropriate page
      
        
         getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String url = "";
        String action = request.getParameter("action");
        if (requestURI.endsWith("/add")) {
            url = addStudy(request, response);
        }else if(requestURI.endsWith("/solved")){
             url = solved(request, response);
        }
       // forward to view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
   
   private String solved(HttpServletRequest request, HttpServletResponse response){
      
      HttpSession session = request.getSession();
      User userSession = (User) session.getAttribute("theAdmin");
      String message="";
      if(userSession==null){
         request.setAttribute("message", message);
         return "/login.jsp";
      } 
      
      else{
          
        String id= request.getParameter("defectCode");
        System.out.print("in solved method is is"+id);
          if(id!=null){
               
               Defect defect = (Defect)DefectDB.getDefect(Long.parseLong(id));
               System.out.print("defect fetched is "+defect);
               defect.setDefectStatus("Solved");
               DefectDB.updateStatus(defect,"Solved");
              session.setAttribute("defectReported", defect);
          return "/unsolved.jsp";
          }
          else{
          
          return "/admin.jsp";
          }
         
      }
      
     
  } 
   
   
   
    
 private String addStudy(HttpServletRequest request, HttpServletResponse response){
       HttpSession session = request.getSession();
       String url="/main.jsp";
      String defectname = request.getParameter("title");
       String desc = request.getParameter("description");
       String model = request.getParameter("model");
       
       User user = (User) session.getAttribute("theUser");
      
            Defect defect = new Defect();
          
       defect.setDateReported(System.currentTimeMillis());
       defect.setDefectTitle(defectname);
       defect.setDefectDescription(desc);
       defect.setModel(model);
       defect.setReportedByEmail(user.getEmail());
       defect.setReportedByName(user.getUsername());
       defect.setDefectStatus("pending");
        String message;
     
             DefectDB.addDefect(defect);
            List<Defect> studyCode = (List<Defect>)DefectDB.getAllMyDefects(user.getEmail());
            session.setAttribute("studyCode", studyCode);
            request.setAttribute("studyCode", studyCode);
          
            message = "defect details added";
            request.setAttribute("message", message);
            url = "/defects.jsp";
          
      
        return url;
           
      
       
       
   }
    
     
        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  }
