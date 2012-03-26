package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;

public class TimeSheetRowPK implements Serializable {
    
    private Date week_end_day;
    private String wp_ID;
    private int proj_ID;
    private int emp_ID;

    public Date getWeek_end_day() {
        return week_end_day;
    }

    public void setWeek_end_day(Date week_end_day) {    
        this.week_end_day = week_end_day;
    }

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
        result = prime * result + proj_ID;
        result = prime * result
                + ((week_end_day == null) ? 0 : week_end_day.hashCode());
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
        TimeSheetRowPK other = (TimeSheetRowPK) obj;
        if (emp_ID != other.emp_ID)
            return false;
        if (proj_ID != other.proj_ID)
            return false;
        if (week_end_day == null) {
            if (other.week_end_day != null)
                return false;
        } else if (!week_end_day.equals(other.week_end_day))
            return false;
        if (wp_ID == null) {
            if (other.wp_ID != null)
                return false;
        } else if (!wp_ID.equals(other.wp_ID))
            return false;
        return true;
    }

}
