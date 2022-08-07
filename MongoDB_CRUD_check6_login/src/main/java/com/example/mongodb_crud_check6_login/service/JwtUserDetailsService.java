package com.example.mongodb_crud_check6_login.service;

import java.util.ArrayList;

import com.example.mongodb_crud_check6_login.model.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

	private final CustomUserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		CustomUser user = userService.findByEMail(email);

		if (user == null)
			throw new UsernameNotFoundException("User not found with username: " + email);

		UserDetails userDetails = User.withUsername(user.getEmail())
				.password(user.getPassword())
				.authorities(user.getRole().name())
				.build();

		return userDetails ;

//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}

}