package edu.miu.waa.ministore.service.MyUserDetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.miu.waa.ministore.domain.User;
import edu.miu.waa.ministore.repository.UserRepository;

@EnableWebSecurity
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findUserByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));

		return new LoginUserDetails(user.get());
	}
}
