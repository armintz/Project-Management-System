package com.freakshow.pms;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="work_package")
@IdClass(WorkPackagePK.class)
public class WorkPackage {
    
    @Id
    private String wp_ID;
    @Id
    private int proj_ID;
    
    private boolean active;
    private Date start_date;
    private int responsible_engineer;
    private String Description;
    private int wp_budget;
    
    public String getWp_ID() {
        return wp_ID;
    }
    public void setWp_ID(String wp_ID) {
        this.wp_ID = wp_ID;
    }
    public int getProj_ID() {
        return proj_ID;
    }
    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public int getResponsible_engineer() {
        return responsible_engineer;
    }
    public void setResponsible_engineer(int responsible_engineer) {
        this.responsible_engineer = responsible_engineer;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public int getWp_budget() {
        return wp_budget;
    }
    public void setWp_budget(int wp_budget) {
        this.wp_budget = wp_budget;
    }
    
}
