package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    
    @Id   
    private int emp_ID; 
    private String emp_pass;
    private String first_name;
    private String last_name;
    private Date emp_start_date;
    private String ft_pt;
    private int supervisor_ID;
    private int ts_approver_ID;
    private boolean role_create_WP;
    private boolean role_HR;
    private boolean role_PM; 
    private boolean role_Supervisor;
    
//    @ManyToOne
//    private Employee approver;
//    
//    @OneToMany(mappedBy = "approver")
//    private Collection<Employee> peons;
    
    public Employee(){
    }
    
    public Employee (int emp_ID){
        emp_ID = this.emp_ID;
    }
    public int getEmp_ID() {
        return emp_ID;
    }
    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }
    public String getEmp_pass() {
        return emp_pass;
    }
    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public Date getEmp_start_date() {
        return emp_start_date;
    }
    public void setEmp_start_date(Date emp_start_date) {
        this.emp_start_date = emp_start_date;
    }
    public String getFt_pt() {
        return ft_pt;
    }
    public void setFt_pt(String ft_pt) {
        this.ft_pt = ft_pt;
    }
    public int getSupervisor_ID() {
        return supervisor_ID;
    }
    public void setSupervisor_ID(int supervisor_ID) {
        this.supervisor_ID = supervisor_ID;
    }
    public int getTs_approver_ID() {
        return ts_approver_ID;
    }
    public void setTs_approver_ID(int ts_approver_ID) {
        this.ts_approver_ID = ts_approver_ID;
    }
    public boolean isRole_create_WP() {
        return role_create_WP;
    }
    public void setRole_create_WP(boolean role_create_WP) {
        this.role_create_WP = role_create_WP;
    }
    public boolean isRole_HR() {
        return role_HR;
    }
    public void setRole_HR(boolean role_HR) {
        this.role_HR = role_HR;
    }
    public boolean isRole_PM() {
        return role_PM;
    }
    public void setRole_PM(boolean role_PM) {
        this.role_PM = role_PM;
    }
    public boolean isRole_Supervisor() {
        return role_Supervisor;
    }
    public void setRole_Supervisor(boolean role_Supervisor) {
        this.role_Supervisor = role_Supervisor;
    }
}

