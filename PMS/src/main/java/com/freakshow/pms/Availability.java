package com.freakshow.pms;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
/**
 * entity for managing an employees availability
 * @author Joe
 *
 */
@Entity
@Table(name = "availability")
@IdClass(AvailabilityPK.class)
public class Availability {
    /**
     * the employees ID.
     */
    @Id
    private int emp_ID;
    /**
     * the id of the project the employee is assigned to.
     */
    @Id
    private int proj_ID;
    /**
     * retrieves the employees ID.
     * @return an int containing the employees ID.
     */
    public final int getEmp_ID() {
        return emp_ID;
    }
    /**
     * sets the employees ID.
     * @param e the new value to be assigned to emp_ID.
     */
    public final void setEmp_ID(int e) {
        emp_ID = e;
    }
    /**
     * retrieves the project ID.
     * @return an int containing the project ID.
     */
    public final int getProj_ID() {
        return proj_ID;
    }
    /**
     * sets the project ID.
     * @param p the new value to be assigned to the project ID.
     */
    public final void setProj_ID(int p) {
        proj_ID = p;
    }
}
