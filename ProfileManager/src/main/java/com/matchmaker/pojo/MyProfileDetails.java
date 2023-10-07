package com.matchmaker.pojo;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class MyProfileDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long profileId;
	String name;
	String placeOfBirth;
	String caste;
	String religion;
	String ContactNo;
	@Column(unique = true)
	String email;
	@OneToOne(cascade = CascadeType.ALL)
	DesiredProfileDetails details;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	
	
	public long getProfileId() {
		return profileId;
	}
	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}
	@Override
	public String toString() {
		return "MyProfileDetails [profileId=" + profileId + ", name=" + name + ", placeOfBirth=" + placeOfBirth
				+ ", caste=" + caste + ", religion=" + religion + ", ContactNo=" + ContactNo + ", email=" + email
				+ ", details=" + details + "]";
	}
	public MyProfileDetails() {
		super();
	}
	public DesiredProfileDetails getDetails() {
		return details;
	}
	public void setDetails(DesiredProfileDetails details) {
		this.details = details;
	}
	public MyProfileDetails(long profileId, String name, String placeOfBirth, String caste, String religion,
			String contactNo, String email, DesiredProfileDetails details) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.placeOfBirth = placeOfBirth;
		this.caste = caste;
		this.religion = religion;
		ContactNo = contactNo;
		this.email = email;
		this.details = details;
	}

	
	
	

}
