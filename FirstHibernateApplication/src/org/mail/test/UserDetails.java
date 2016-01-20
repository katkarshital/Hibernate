package org.mail.test;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
//(name="USER_DETAILS")
@Table(name="USER_DETAILS")
public class UserDetails {
	/*@Id @GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="User_Id")
	private int userId;*/
	@EmbeddedId
	private EmailAddress emailId;
	//@Column(name="User_Name")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joingDate;
	@Lob
	@Transient
	private String description;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="Home_Street")),
	@AttributeOverride(name="city",column=@Column(name="Home_City")),
	@AttributeOverride(name="state",column=@Column(name="Home_State")),
	@AttributeOverride(name="zipcode",column=@Column(name="Home_Zipcode")),
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="Office_Street")),
	@AttributeOverride(name="city",column=@Column(name="Office_City")),
	@AttributeOverride(name="state",column=@Column(name="Office_State")),
	@AttributeOverride(name="zipcode",column=@Column(name="Office_Zipcode")),
	})
	private Address officeAddress;
	
	public Date getJoingDate() {
		return joingDate;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setJoingDate(Date joingDate) {
		this.joingDate = joingDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public EmailAddress getEmailId() {
		return emailId;
	}
	public void setEmailId(EmailAddress emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
