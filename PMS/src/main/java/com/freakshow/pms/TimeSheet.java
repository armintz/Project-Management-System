package com.freakshow.pms;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("timeSheet")
public class TimeSheet implements Serializable {
    
	private TimeSheetRow[] ts = {	        
        new TimeSheetRow(1,"a",3,4),
        new TimeSheetRow(2,"a",3,4),
        new TimeSheetRow(3,"a",3,4)
	};

    public TimeSheetRow[] getTs() {      
        return ts;
    }

    public void setTs(TimeSheetRow[] ts) {
        this.ts = ts;
    }	
}

