package com.chithu.app.entity;

import java.math.BigDecimal;

public class User {

	private int userid;
	private String username;
	private String firstname;
	private String lastname;
	private String mailid;
	private String alternatemail;
	private BigDecimal mobilenumber;
	private BigDecimal alternatenumber;
	private String dob;
	private String password;
	
	
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the mailid
	 */
	public String getMailid() {
		return mailid;
	}
	/**
	 * @param mailid the mailid to set
	 */
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	/**
	 * @return the alternatemail
	 */
	public String getAlternatemail() {
		return alternatemail;
	}
	/**
	 * @param alternatemail the alternatemail to set
	 */
	public void setAlternatemail(String alternatemail) {
		this.alternatemail = alternatemail;
	}
	/**
	 * @return the mobilenumber
	 */
	public BigDecimal getMobilenumber() {
		return mobilenumber;
	}
	/**
	 * @param mobilenumber the mobilenumber to set
	 */
	public void setMobilenumber(BigDecimal mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	/**
	 * @return the alternatenumber
	 */
	public BigDecimal getAlternatenumber() {
		return alternatenumber;
	}
	/**
	 * @param alternatenumber the alternatenumber to set
	 */
	public void setAlternatenumber(BigDecimal alternatenumber) {
		this.alternatenumber = alternatenumber;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", mailid=" + mailid + ", alternatemail=" + alternatemail + ", mobilenumber="
				+ mobilenumber + ", alternatenumber=" + alternatenumber + ", dob=" + dob + ", password=" + password
				+ "}";
	}
}
