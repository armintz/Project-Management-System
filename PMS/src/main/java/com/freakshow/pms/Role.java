package com.freakshow.pms;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="role")
@IdClass(RolePK.class)
public class Role implements Serializable {
    
    @Id   
    private int emp_ID; 
    @Id
    private int role_ID;
    
    public int getEmp_ID() {
        return emp_ID;
    }
    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }
    public int getRole_ID() {
        return role_ID;
    }
    public void setRole_ID(int role_ID) {
        this.role_ID = role_ID;
    }   
}

