package com.freakshow.pms;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
    
    @Id
    private int proj_ID;
    private String proj_name;
    private boolean active;
    private Date start_date;
    private int project_manager;
    
    @OneToMany
    public Collection<WorkPackage> wp;

    public int getProj_ID() {
        return proj_ID;
    }
    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }
    public String getProj_name() {
        return proj_name;
    }
    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
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
    public int getProject_manager() {
        return project_manager;
    }
    public void setProject_manager(int project_manager) {
        this.project_manager = project_manager;
    }
    public Collection<WorkPackage> getWp() {
        return wp;
    }
    public void setWp(Collection<WorkPackage> wp) {
        this.wp = wp;
    }
}
