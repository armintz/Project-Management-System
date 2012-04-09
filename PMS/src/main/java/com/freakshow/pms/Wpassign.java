package com.freakshow.pms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
/**
 * entity that keeps track of who's assigned to which work package.
 * @author Joe
 *
 */
@Entity
@Table(name = "wpassign")
@IdClass(WpassignPK.class)
public class Wpassign {
    /**
     * an employees id.
     */
    @Id
    private int emp_ID;
    /**
     * a projects id.
     */
    @Id
    private int proj_ID;
    /**
     * a workpackages id.
     */
    @Id
    private String wp_ID;
    /**
     * the date the employee was assigned to the work package.
     */
    private Date date_started;
    /**
     * retrieves the employees id.
     * @return the employees id number.
     */
    public int getEmp_ID(){
        return emp_ID;
    }
    /**
     * sets the employees id.
     * @param n the new value for the employees id.
     */
    public void setEmp_ID(int n){
        emp_ID = n;
    }
    /**
     * retrieves the projects id.
     * @return the projects id.
     */
    public int getProj_ID(){
        return proj_ID;
    }
    /**
     * sets the projects id.
     * @param n the new project id.
     */
    public void setProj_ID(int n){
        proj_ID = n;
    }
    /**
     * retrieves the work package id.
     * @return the work packages id.
     */
    public String getWp_ID(){
        return wp_ID;
    }
    /**
     * sets the work package id.
     * @param s the new value for work package id.
     */
    public void setWp_ID(String s){
        wp_ID = s;
    }
    /**
     * retrieves the date the employee was assigned to the work package.
     * @return the date the employee was assigned.
     */
    public Date getDate_started(){
        return date_started;
    }
    /**
     * sets the date the employee was assigned the work package.
     * @param d the new value for the date.
     */
    public void setDate_started(Date d){
        date_started = d;
    }
    
    
}
