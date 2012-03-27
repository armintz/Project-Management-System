package com.freakshow.pms;

import java.io.Serializable;

public class RolePK implements Serializable {

    private int role_ID;
    private int emp_ID;

    public int getRole_ID() {
        return role_ID;
    }
    public void setRole_ID(int role_ID) {
        this.role_ID = role_ID;
    }
    public int getEmp_ID() {
        return emp_ID;
    }
    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + emp_ID;
        result = prime * result + role_ID;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RolePK other = (RolePK) obj;
        if (emp_ID != other.emp_ID)
            return false;
        if (role_ID != other.role_ID)
            return false;
        return true;
    }
}
