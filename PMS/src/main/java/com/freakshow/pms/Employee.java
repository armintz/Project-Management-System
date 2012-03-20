package com.freakshow.pms;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Class UserBean.
 */
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
    private String supervisor_id;
    private String ts_approver_id;

    @ManyToOne
    private Employee approver;
    
    @OneToMany(mappedBy = "approver")
    private Collection<Employee> peons;
    
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
    public String getSupervisor_id() {
        return supervisor_id;
    }
    public void setSupervisor_id(String supervisor_id) {
        this.supervisor_id = supervisor_id;
    }
    public String getTs_approver_id() {
        return ts_approver_id;
    }
    public void setTs_approver_id(String ts_approver_id) {
        this.ts_approver_id = ts_approver_id;
    }
    public Employee getApprover() {
        return approver;
    }
    public void setApprover(Employee approver) {
        this.approver = approver;
    }
    public Collection<Employee> getPeons() {
        return peons;
    }
    public void setPeons(Collection<Employee> peons) {
        this.peons = peons;
    }

    


}

