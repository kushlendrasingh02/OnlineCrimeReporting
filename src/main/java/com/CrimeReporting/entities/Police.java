package com.CrimeReporting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POLICE")
public class Police {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private int police_id;
	private String police_name;
	@Column(unique = true)
	private String police_email;
	private String police_mob;
	private String police_passwd;
	private String police_address;
	private String police_designation;
	private String station_branch;
	
	public Police() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPolice_id() {
		return police_id;
	}

	public void setPolice_id(int police_id) {
		this.police_id = police_id;
	}

	public String getPolice_name() {
		return police_name;
	}

	public void setPolice_name(String police_name) {
		this.police_name = police_name;
	}

	public String getPolice_email() {
		return police_email;
	}

	public void setPolice_email(String police_email) {
		this.police_email = police_email;
	}

	public String getPolice_mob() {
		return police_mob;
	}

	public void setPolice_mob(String police_mob) {
		this.police_mob = police_mob;
	}

	public String getPolice_passwd() {
		return police_passwd;
	}

	public void setPolice_passwd(String police_passwd) {
		this.police_passwd = police_passwd;
	}

	public String getPolice_address() {
		return police_address;
	}

	public void setPolice_address(String police_address) {
		this.police_address = police_address;
	}

	public String getPolice_designation() {
		return police_designation;
	}

	public void setPolice_designation(String police_designation) {
		this.police_designation = police_designation;
	}

	public String getStation_branch() {
		return station_branch;
	}

	public void setStation_branch(String station_branch) {
		this.station_branch = station_branch;
	}
	
}
