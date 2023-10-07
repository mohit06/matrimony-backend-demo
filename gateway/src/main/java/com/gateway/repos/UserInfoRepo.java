package com.gateway.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.UserInfo;



public interface UserInfoRepo extends JpaRepository<UserInfo,Integer>{

	Optional<UserInfo> findByName(String username);

}
