package com.smart.contact.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.contact.entities.MstUserBo;
import com.smart.contact.repository.UserRepo;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MstUserBo user=userRepo.getUserByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Does Not Exist!");
		}
		return new CustomUserDetails(user);
		
	}

	
}
