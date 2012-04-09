package com.freakshow.pms;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
/**
 * entity for managing an employees availability
 * @author Joe
 *
 */
@Entity
@Table(name = "availability")
@IdClass(AvailabilityPK.class)
public class Availability {

    @Id
    private int emp_ID;

    @Id
    private int proj_ID;

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public int getProj_ID() {
        return proj_ID;
    }

    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }
}
