package org.mail.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmailAddress implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name="User_Name")
	private String userName;
	@Column(name="Domain_Name")
	private String domainName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	
}
