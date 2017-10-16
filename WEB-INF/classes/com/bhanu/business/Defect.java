/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhanu.business;

import java.io.Serializable;
import java.util.Date;



public class Defect implements Serializable{
    private long id;
    private String defectTitle;
    private String reportedByEmail;
    private String reportedByName;
    private String model;

   
    private long dateReported;
    private String defectDescription;
    private String defectStatus;

    public String getDefectStatus() {
        return defectStatus;
    }

    @Override
    public String toString() {
        return "Defect{" + "id=" + id + ", defectTitle=" + defectTitle + ", reportedByEmail=" + reportedByEmail + ", reportedByName=" + reportedByName + ", model=" + model + ", dateReported=" + dateReported + ", defectDescription=" + defectDescription + ", defectStatus=" + defectStatus + '}';
    }
  
    public void setDefectStatus(String defectStatus) {
        this.defectStatus = defectStatus;
    }
    
     public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDefectTitle() {
        return defectTitle;
    }

    public void setDefectTitle(String defectTitle) {
        this.defectTitle = defectTitle;
    }

    public String getReportedByEmail() {
        return reportedByEmail;
    }

    public void setReportedByEmail(String reportedByEmail) {
        this.reportedByEmail = reportedByEmail;
    }

    public String getReportedByName() {
        return reportedByName;
    }

    public void setReportedByName(String reportedByName) {
        this.reportedByName = reportedByName;
    }

    public long getDateReported() {
        return dateReported;
    }

    public void setDateReported(long dateReported) {
        this.dateReported = dateReported;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }
    
}
