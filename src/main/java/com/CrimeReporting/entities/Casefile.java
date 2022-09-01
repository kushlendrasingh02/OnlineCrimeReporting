package com.CrimeReporting.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CASEFILE")
public class Casefile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private int casefile_id;
	private String victim_name;
	private String victim_relativename;
	private Date victim_birthdate;
	private String victim_mobile;
	private String victum_nationality;
	private String victum_uid_no;
	private String victum_passport;
	private String victum_address;
	private String victum_district;
	private String victum_ps;
	private Date occurrence_date;
	private String occurrence_time;
	private String occurrence_address;
	private String type_of_cirme;
	@Column(length = 50000)
	private String crime_disc;
	private String avidence_pic;
	private boolean agreement;
	private String fir_status;
	@Column(length = 50000)
	private String officer_comment;

	@ManyToOne
	private User user;

	public Casefile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCasefile_id() {
		return casefile_id;
	}

	public void setCasefile_id(int casefile_id) {
		this.casefile_id = casefile_id;
	}

	public String getVictim_name() {
		return victim_name;
	}

	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}

	public String getVictim_relativename() {
		return victim_relativename;
	}

	public void setVictim_relativename(String victim_relativename) {
		this.victim_relativename = victim_relativename;
	}

	public Date getVictim_birthdate() {
		return victim_birthdate;
	}

	public void setVictim_birthdate(Date victim_birthdate) {
		this.victim_birthdate = victim_birthdate;
	}

	public String getVictim_mobile() {
		return victim_mobile;
	}

	public void setVictim_mobile(String victim_mobile) {
		this.victim_mobile = victim_mobile;
	}

	public String getVictum_nationality() {
		return victum_nationality;
	}

	public void setVictum_nationality(String victum_nationality) {
		this.victum_nationality = victum_nationality;
	}

	public String getVictum_uid_no() {
		return victum_uid_no;
	}

	public void setVictum_uid_no(String victum_uid_no) {
		this.victum_uid_no = victum_uid_no;
	}

	public String getVictum_passport() {
		return victum_passport;
	}

	public void setVictum_passport(String victum_passport) {
		this.victum_passport = victum_passport;
	}

	public String getVictum_address() {
		return victum_address;
	}

	public void setVictum_address(String victum_address) {
		this.victum_address = victum_address;
	}

	public String getVictum_district() {
		return victum_district;
	}

	public void setVictum_district(String victum_district) {
		this.victum_district = victum_district;
	}

	public String getVictum_ps() {
		return victum_ps;
	}

	public void setVictum_ps(String victum_ps) {
		this.victum_ps = victum_ps;
	}

	public Date getOccurrence_date() {
		return occurrence_date;
	}

	public void setOccurrence_date(Date occurrence_date) {
		this.occurrence_date = occurrence_date;
	}

	public String getOccurrence_time() {
		return occurrence_time;
	}

	public void setOccurrence_time(String occurrence_time) {
		this.occurrence_time = occurrence_time;
	}

	public String getOccurrence_address() {
		return occurrence_address;
	}

	public void setOccurrence_address(String occurrence_address) {
		this.occurrence_address = occurrence_address;
	}

	public String getType_of_cirme() {
		return type_of_cirme;
	}

	public void setType_of_cirme(String type_of_cirme) {
		this.type_of_cirme = type_of_cirme;
	}

	public String getCrime_disc() {
		return crime_disc;
	}

	public void setCrime_disc(String crime_disc) {
		this.crime_disc = crime_disc;
	}

	public String getAvidence_pic() {
		return avidence_pic;
	}

	public void setAvidence_pic(String avidence_pic) {
		this.avidence_pic = avidence_pic;
	}

	public boolean isAgreement() {
		return agreement;
	}

	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}

	public String getFir_status() {
		return fir_status;
	}

	public void setFir_status(String fir_status) {
		this.fir_status = fir_status;
	}

	public String getOfficer_comment() {
		return officer_comment;
	}

	public void setOfficer_comment(String officer_comment) {
		this.officer_comment = officer_comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Casefile [casefile_id=" + casefile_id + ", victim_name=" + victim_name + ", victim_relativename="
				+ victim_relativename + ", victim_birthdate=" + victim_birthdate + ", victim_mobile=" + victim_mobile
				+ ", victum_nationality=" + victum_nationality + ", victum_uid_no=" + victum_uid_no
				+ ", victum_passport=" + victum_passport + ", victum_address=" + victum_address + ", victum_district="
				+ victum_district + ", victum_ps=" + victum_ps + ", occurrence_date=" + occurrence_date
				+ ", occurrence_time=" + occurrence_time + ", occurrence_address=" + occurrence_address
				+ ", type_of_cirme=" + type_of_cirme + ", crime_disc=" + crime_disc + ", avidence_pic=" + avidence_pic
				+ ", agreement=" + agreement + ", fir_status=" + fir_status + "]";
	}
	
	

}
