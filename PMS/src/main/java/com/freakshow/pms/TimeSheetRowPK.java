package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;

public class TimeSheetRowPK implements Serializable {
    
    private Date week_end_day;
    private int wp_ID;
    private int proj_ID;

    public Date getWeek_end_day() {
        return week_end_day;
    }

    public void setWeek_end_day(Date week_end_day) {
        this.week_end_day = week_end_day;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + proj_ID;
        result = prime * result
                + ((week_end_day == null) ? 0 : week_end_day.hashCode());
        result = prime * result + wp_ID;
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
        if (proj_ID != other.proj_ID)
            return false;
        if (week_end_day == null) {
            if (other.week_end_day != null)
                return false;
        } else if (!week_end_day.equals(other.week_end_day))
            return false;
        if (wp_ID != other.wp_ID)
            return false;
        return true;
    }

    public int getWp_ID() {
        return wp_ID;
    }

    public void setWp_ID(int wp_ID) {
        this.wp_ID = wp_ID;
    }

    public int getProj_ID() {
        return proj_ID;
    }

    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }


}
