package com.safesync.security.services;

import com.safesync.security.entities.CustomUserDetails;
import com.safesync.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.safesync.security.entities.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User does exist with the given username");
		}
		
		UserDetails userDetails = new CustomUserDetails(user);
		
		return userDetails;
	}

}
