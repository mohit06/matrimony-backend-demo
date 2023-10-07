package com.matchmaker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matchmaker.pojo.MyProfileDetails;

public interface ProfileRepository extends JpaRepository<MyProfileDetails,Long>{

	public MyProfileDetails findByEmail(String email);

	public void deleteByEmail(String email);

}
