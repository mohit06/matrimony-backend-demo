package com.identity.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.identity.entities.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer>{

	Optional<UserInfo> findByName(String username);

}
