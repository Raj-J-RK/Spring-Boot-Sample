package com.rk.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class UserEntity {
	
	@Id
	@Column(name="USERID")
	private String userId;
	
	@Column(name="FNAME")
	private String userfName;
	
	@Column(name="LNAME")
	private String userlName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="GOVTEMP")
	private boolean governmentEmployee;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserfName() {
		return userfName;
	}
	public void setUserfName(String userfName) {
		this.userfName = userfName;
	}
	public String getUserlName() {
		return userlName;
	}
	public void setUserlName(String userlName) {
		this.userlName = userlName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isGovernmentEmployee() {
		return governmentEmployee;
	}
	public void setGovernmentEmployee(boolean governmentEmployee) {
		this.governmentEmployee = governmentEmployee;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userfName=" + userfName + ", userlName=" + userlName + ", age=" + age
				+ ", city=" + city + ", country=" + country + ", governmentEmployee=" + governmentEmployee + ", dob="
				+ dob + "]";
	}

}
