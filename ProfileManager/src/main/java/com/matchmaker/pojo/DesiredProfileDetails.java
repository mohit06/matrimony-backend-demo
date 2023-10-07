package com.matchmaker.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class DesiredProfileDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long desiredId;
	String Caste;
	String Religion;

	//long profileId;

	public String getCaste() {
		return Caste;
	}

	public void setCaste(String caste) {
		Caste = caste;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	@Override
	public String toString() {
		return "DesiredProfileDetails [desiredId=" + desiredId + ", Caste=" + Caste + ", Religion=" + Religion
				 + "]";
	}


	public long getDesiredId() {
		return desiredId;
	}

	public void setDesiredId(long desiredId) {
		this.desiredId = desiredId;
	}

	public DesiredProfileDetails(long desiredId, String caste, String religion) {
		super();
		this.desiredId = desiredId;
		Caste = caste;
		Religion = religion;
	}

	public DesiredProfileDetails() {
		super();
	}

//	public long getProfileId() {
//		return profileId;
//	}
//
//	public void setProfileId(long profileId) {
//		this.profileId = profileId;
//	}

}
