package com.freakshow.pms;

import java.io.Serializable;

public class AvailabilityPK implements Serializable {
    private int emp_ID;
    private int proj_ID;
    
    public int getEmp_ID() {
        return emp_ID;
    }
    public void setEmp_ID(int id) {
        emp_ID = id;
    }
    public int getProj_ID() {
        return proj_ID;
    }
    public void setProj_ID(int pID) {
        proj_ID = pID;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + proj_ID;
        result = prime * result + emp_ID;
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
        AvailabilityPK other = (AvailabilityPK) obj;
        if (proj_ID != other.proj_ID)
            return false;
        if (emp_ID != other.emp_ID)
            return false;
        return true;
    }
}


