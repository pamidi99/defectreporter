/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhanu.data;

import com.bhanu.business.Defect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author bhanu
 */
public class DefectDB {
     public static void addDefect(Defect defect){
            Connection connection = DBUtility.getConnection();
            PreparedStatement ps = null;
		String query = "INSERT INTO defect(title, byname, byemail, model,datereported, description, defectstatus ) VALUES (?,?,?,?,?,?,?)";
		
		try
		{
			ps = connection.prepareStatement(query);
			ps.setString(1,defect.getDefectTitle());
                        ps.setString(2, defect.getReportedByName());
                        ps.setString(3,defect.getReportedByEmail());
                        ps.setString(4,defect.getModel());
                        ps.setLong(5,defect.getDateReported());
                        ps.setString(6,defect.getDefectDescription());
                        ps.setString(7, defect.getDefectStatus());
			ps.executeUpdate();
                        EmailDB.emailRecommendTrigger(defect.getReportedByEmail());
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			
		}
		finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);
		}
      
      
  }
     public static Defect getDefect(long id){
         	Defect defect=null;
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from defect where id=?";

        try
        {
        	  ps = connection.prepareStatement(query);
                  ps.setLong(1,id);
              ResultSet rs = ps.executeQuery();
              if(rs.next())
              {
          		  defect = new Defect();
                          defect.setId(rs.getLong("id"));
                          defect.setDefectTitle(rs.getString("title"));
                          defect.setReportedByEmail(rs.getString("byemail"));
                          defect.setReportedByName(rs.getString("byname"));
                          defect.setDateReported(rs.getLong("datereported"));
                          defect.setDefectDescription(rs.getString("description"));
                          defect.setDefectStatus(rs.getString("defectstatus"));
                          defect.setModel(rs.getString("model")); 
            	          
              }
        }
        catch(SQLException  e)
        {
        	System.out.println(e);
        }
        finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);

		}
	    return defect;	
	
     }
     public static ArrayList<Defect> getAllDefects(){
         	ArrayList<Defect> defects = new ArrayList<Defect>();
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from defect";

        try
        {
        	  ps = connection.prepareStatement(query);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
          		  Defect defect = new Defect();
                          defect.setId(rs.getLong("id"));
                          defect.setDefectTitle(rs.getString("title"));
                          defect.setReportedByEmail(rs.getString("byemail"));
                          defect.setReportedByName(rs.getString("byname"));
                          defect.setDateReported(rs.getLong("datereported"));
                          defect.setDefectDescription(rs.getString("description"));
                          defect.setDefectStatus(rs.getString("defectstatus"));
                          defect.setModel(rs.getString("model")); 
            	          defects.add(defect);
              }
        }
        catch(SQLException  e)
        {
        	System.out.println(e);
        }
        finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);

		}
        System.out.println("defects returned "+defects);
	    return defects;	
	
     }
     public static ArrayList<Defect> getAllPendingDefects(){
         	ArrayList<Defect> defects = new ArrayList<Defect>();
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from defect where defectstatus=?";

        try
        {
        	  ps = connection.prepareStatement(query);
                  ps.setString(1,"pending");
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
          		  Defect defect = new Defect();
                          defect.setId(rs.getLong("id"));
                          defect.setDefectTitle(rs.getString("title"));
                          defect.setReportedByEmail(rs.getString("byemail"));
                          defect.setReportedByName(rs.getString("byname"));
                          defect.setDateReported(rs.getLong("datereported"));
                          defect.setDefectDescription(rs.getString("description"));
                          defect.setDefectStatus(rs.getString("defectstatus"));
                          defect.setModel(rs.getString("model")); 
            	          defects.add(defect);
              }
        }
        catch(SQLException  e)
        {
        	System.out.println(e);
        }
        finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);

		}
	    return defects;	
	
     }
     public static ArrayList<Defect> getAllMyDefects(String email){
         	ArrayList<Defect> defects = new ArrayList<Defect>();
		Connection connection = DBUtility.getConnection();
		
		PreparedStatement ps = null;
		
		String query = "SELECT * from defect where byemail=?";

        try
        {
        	  ps = connection.prepareStatement(query);
                  ps.setString(1,email);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
          		  Defect defect = new Defect();
                          defect.setId(rs.getLong("id"));
                          defect.setDefectTitle(rs.getString("title"));
                          defect.setReportedByEmail(rs.getString("byemail"));
                          defect.setReportedByName(rs.getString("byname"));
                          defect.setDateReported(rs.getLong("datereported"));
                          defect.setDefectDescription(rs.getString("description"));
                          defect.setDefectStatus(rs.getString("defectstatus"));
                          defect.setModel(rs.getString("model")); 
            	          defects.add(defect);
              }
        }
        catch(SQLException  e)
        {
        	System.out.println(e);
        }
        finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);

		}
	    return defects;	
	
     }
   
   public static void updateStatus(Defect defect,String status){
      
       Connection connection = DBUtility.getConnection();
		PreparedStatement ps = null;
		
        String query = "UPDATE defect set defectstatus=? WHERE id=?";
		
		try
		{
			ps = connection.prepareStatement(query);
			ps.setString(1,status);
			ps.setLong(2,defect.getId());
                        ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
			
		}
		finally
		{
			DBUtil.closePreparedStatement(ps);
                    DBUtility.closeConnection(connection);

		}
      
      
  }
   
}
