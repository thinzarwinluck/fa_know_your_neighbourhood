package com.assignment3.kyn_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public void UserDetailsServiceImpl() {
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findUserByName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("user " + userName + " is not valid. Please re-enter.");
		}
		org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User
				.builder();
		String[] roleNames = user.getRoles().stream().map(Role::getName).toArray(String[]::new);
		return userBuilder.username(user.getUserName()).password(user.getPassword()).roles(roleNames)
				.passwordEncoder(passwordEncoder::encode).build();
	}
}
