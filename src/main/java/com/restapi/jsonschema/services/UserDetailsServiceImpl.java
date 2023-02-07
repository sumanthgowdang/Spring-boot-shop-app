package com.restapi.jsonschema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restapi.jsonschema.Repository.CustomerRepository;
import com.restapi.jsonschema.domain.Customer;
import com.restapi.jsonschema.domain.UserDetailsImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CustomerRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		
		Customer user=userRepo.getByName(username);
		
		if(user==null) {
			System.out.println("exception thrown");
			throw new UsernameNotFoundException(username + "not found");
		}
		return new UserDetailsImpl(user);
	}
}
