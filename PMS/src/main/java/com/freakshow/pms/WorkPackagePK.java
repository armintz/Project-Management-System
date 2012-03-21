package com.freakshow.pms;

import java.io.Serializable;

public class WorkPackagePK implements Serializable {

    private String wp_ID;
    private int proj_ID;
    
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + proj_ID;
        result = prime * result + ((wp_ID == null) ? 0 : wp_ID.hashCode());
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
        WorkPackagePK other = (WorkPackagePK) obj;
        if (proj_ID != other.proj_ID)
            return false;
        if (wp_ID == null) {
            if (other.wp_ID != null)
                return false;
        } else if (!wp_ID.equals(other.wp_ID))
            return false;
        return true;
    }
}
