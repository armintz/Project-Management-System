package com.freakshow.pms;

import java.io.Serializable;
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
    
    @Id
    /** The is employee number. */
    private int employeeNum; 
    
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
    public String verifyUser(){
        return "login";
    }
}

