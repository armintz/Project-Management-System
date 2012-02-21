package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class UserBean.
 */
@Named("user")
@Entity
@Table(name="employee")
public class UserBean implements Serializable {
   
    /** The user name. */
    private String userName;
    
    /** The password. */
    private String password;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;

    /** The email. */
    private String email;
    
    /** The phone number. */
    private int phone;
    
    /** The employee startdate. */
    private Date startDate;
    
    /** The full-time indicator. */
    private String ft_indicator;
    

    /** The supervisor employee id. */
    private String supervisor_id;
    
    /** The timesheet approver id. */
    private String ts_approver_id;
    
    
    @Id
    /** The is employee number. */
    private int employeeNum; 
    
    public void UserName(String userName, String password, String firstName, String lastName,
    		String email, int phone, Date startDate, String ft_indicator, 
    		String supervisor_id, String ts_approver_id, int employeeNum){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.ft_indicator = ft_indicator;
        this.supervisor_id = supervisor_id;
        this.ts_approver_id = ts_approver_id;
        this.employeeNum = employeeNum;            
    }
    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }   
   
    /**
     * Sets the user name.
     *
     * @param newValue the new user name
     */
    public void setUserName(String newValue) {
        userName = newValue;
    }
   
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
   
    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
		return email;
	}
    
    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public int getPhone() {
		return phone;
	}
	
    /**
     * Sets the phone number.
     *
     * @param phone the new phone number
     */
    public void setPhone(int phone) {
		this.phone = phone;
	}
	
	/**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
		return startDate;
	}
	
    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
     * Gets the full-time indicator.
     *
     * @return the full-time indicator
     */
    public String getFt_indicator() {
		return ft_indicator;
	}
	
    /**
     * Sets the full-time indicator.
     *
     * @param ft_indicator the new full-time indicator
     */
    public void setFt_indicator(String ft_indicator) {
		this.ft_indicator = ft_indicator;
	}
	
	/**
     * Gets the supervisor id.
     *
     * @return the supervisor id
     */
    public String getSupervisor_id() {
		return supervisor_id;
	}
	
    /**
     * Sets the supervisor id.
     *
     * @param supervisor_id the new supervisor id
     */
    public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	
	/**
     * Gets the timesheet approver id.
     *
     * @return the timesheet approver id
     */
    public String getTs_approver_id() {
		return ts_approver_id;
	}
	
    /**
     * Sets the timesheet approver id.
     *
     * @param ts_approver_id the new timesheet spprover id.
     */
    public void setTs_approver_id(String ts_approver_id) {
		this.ts_approver_id = ts_approver_id;
	}
	
	/**
     * @return the employeeNum
     */
    public int getEmployeeNum() {
        return employeeNum;
    }

    /**
     * @param employeeNum the employeeNum to set
     */
    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

}

