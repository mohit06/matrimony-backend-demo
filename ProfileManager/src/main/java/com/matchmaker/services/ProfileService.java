package com.matchmaker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.matchmaker.pojo.MyProfileDetails;
import com.matchmaker.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	public ResponseEntity<MyProfileDetails> createNewProfile(MyProfileDetails mpd) {
		System.out.println("Saving mpd" + mpd.toString());

		profileRepository.save(mpd);

		return new ResponseEntity<MyProfileDetails>(mpd, HttpStatus.CREATED);

	}

	public ResponseEntity<MyProfileDetails> updateProfile(MyProfileDetails mpd) {
		MyProfileDetails mpdetails = profileRepository.findByEmail(mpd.getEmail());
		mpdetails.setCaste(mpd.getCaste());
		mpdetails.setContactNo(mpd.getContactNo());
		mpdetails.setPlaceOfBirth(mpd.getPlaceOfBirth());
		mpdetails.setReligion(mpd.getReligion());
		profileRepository.save(mpdetails);
		return new ResponseEntity<MyProfileDetails>(mpdetails, HttpStatus.OK);
	}

	public ResponseEntity<MyProfileDetails> deleteByEmail(String email) {
		MyProfileDetails mpdetails = profileRepository.findByEmail(email);
		if(mpdetails != null)
		    profileRepository.deleteByEmail(email);
		else
		{
			System.out.println("Profile Not Found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MyProfileDetails>(mpdetails, HttpStatus.OK);
	}

}
