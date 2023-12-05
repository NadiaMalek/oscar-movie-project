package com.backbase.oscarmovie.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUserDetails(final User user) {
		super(user);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles() //This object goes to database and gets the roles using select * from user_roles
                .stream() //This stream API which will internally iterate and call map method
                .map(role -> new
                		SimpleGrantedAuthority("ROLE_" + role.getRole())
                	) //Our business Logic to update the our main object
                .collect(Collectors.toList());  // This will convert teh entire result to List Object or Collection Object
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getFirstName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
