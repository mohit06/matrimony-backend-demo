package com.matchmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matchmaker.pojo.MyProfileDetails;
import com.matchmaker.services.ProfileService;
@RestController
@RequestMapping("/profilemanager")
public class ProfileManagerRestController {
	
	@Autowired
	ProfileService ps;

	
	@GetMapping("/home")
	public String home() {
		return "Helo World";
	}
	
	@PostMapping("/createNewProfile")
	public ResponseEntity<MyProfileDetails> createNewProfile(@RequestBody MyProfileDetails mpd){
		System.out.println("Inside Controller"+mpd.toString());
		return ps.createNewProfile(mpd);
	}
	
	@PutMapping("/updateProfile")
	public ResponseEntity<MyProfileDetails> updateProfile(@RequestBody MyProfileDetails mpd){
		System.out.println("put: Inside Controller"+mpd.toString());
		return ps.updateProfile(mpd);
	}
	
	@DeleteMapping("/deleteMyProfile")
	public ResponseEntity<MyProfileDetails> deleteProfile(@RequestBody String email){
		
		return ps.deleteByEmail(email);
	}
	
	
}
