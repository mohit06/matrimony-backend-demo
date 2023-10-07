package com.identity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.identity.entities.UserInfo;
import com.identity.entities.UserInfoDetails;
import com.identity.repos.UserInfoRepo;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	UserInfoRepo uiRepo;

	public String register(UserInfo userInfo) {

		if (uiRepo.save(userInfo) != null) {
			return "User Registered.";
		} else {
			return "User Not Registered";
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserInfo> userDetail = uiRepo.findByName(username);

		// Converting userDetail to UserDetails
		return userDetail.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}

}
