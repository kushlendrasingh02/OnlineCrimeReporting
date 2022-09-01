package com.CrimeReporting.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private int user_id;
	
	@NotBlank(message  = "Name field should not be blank !!")
	@NotNull(message  = "Name field should not be blank !!")
	@Size(min = 2,max = 15,message = "min 2 and max 20 characters are allowed")
	@Pattern (regexp = "^[a-zA-Z\\s]*$", message = "Name should contain alphabets only !! " )
	private String user_name;
	
	private String user_imgurl;
	
	@NotBlank(message  = "Address field should not be blank !!")
	@Size(min = 3,max = 100,message = "min 10 and max 100 characters are allowed !!")
	@Pattern (regexp = "^[a-zA-Z0-9\\s]*$", message = "Address should contain alphabets and Numbers only !! " )
	private String user_address;
	
	@Column(unique = true)
	@NotBlank(message  = "Email field should not be blank !!")
	@Size(min = 10,max = 35,message = "min 10 and max 35 characters are allowed !!")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Email should be in the form of in proper form !! ")
	private String user_email;
	

	@NotBlank(message  = "Moble field should not be blank !!")
	@Size(min = 10,max = 10,message = " 10 characters are allowed !!")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Moblie Number should be starts form 7 to 9 !!")
	private String user_mobile;
	
	@NotBlank(message  = "Moble field should not be blank !!")
	@Size(min = 8,max = 100,message = "min 8 and max = 15 characters are allowed !!")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,100}$", message = "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
	private String user_passwd;	
	
	@Column(unique = true)
	@NotBlank(message  = "Moble field should not be blank !!")
	@Size(min = 12,max = 12,message = "Please enter valid adharcard number of 12 digit !!")
	@Pattern(regexp = "^[0-9]{4}[ -]?[0-9]{4}[ -]?[0-9]{4}$", message = "Please enter valid adharcard number of 12 digit !!")
	private String user_idcard_no;
	
	
	private String user_idcard_imgurl;
	
	//@AssertTrue(message = "Must agree Terms and Condition !!")
	private boolean enabled;
	
	
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Casefile> casefiles = new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_imgurl() {
		return user_imgurl;
	}

	public void setUser_imgurl(String user_imgurl) {
		this.user_imgurl = user_imgurl;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getUser_passwd() {
		return user_passwd;
	}

	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}

	public String getUser_idcard_no() {
		return user_idcard_no;
	}

	public void setUser_idcard_no(String user_idcard_no) {
		this.user_idcard_no = user_idcard_no;
	}

	public String getUser_idcard_imgurl() {
		return user_idcard_imgurl;
	}

	public void setUser_idcard_imgurl(String user_idcard_imgurl) {
		this.user_idcard_imgurl = user_idcard_imgurl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Casefile> getCasefiles() {
		return casefiles;
	}

	public void setCasefiles(List<Casefile> casefiles) {
		this.casefiles = casefiles;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_imgurl=" + user_imgurl
				+ ", user_address=" + user_address + ", user_email=" + user_email + ", user_mobile=" + user_mobile
				+ ", user_passwd=" + user_passwd + ", user_idcard_no=" + user_idcard_no + ", user_idcard_imgurl="
				+ user_idcard_imgurl + ", enabled=" + enabled + ", casefiles=" + casefiles + "]";
	}

	
}
