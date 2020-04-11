package org.brc.com.authentication.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.brc.com.authentication.model.Roles;
import org.brc.com.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sandeep Rana
 *
 */
@Service(value ="customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = userService.findByUserId(userName);
		 if(user == null) {
			 throw new UsernameNotFoundException("User Name :: "+ userName + " is not found !");
		 }
	     List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	     return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Roles role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(),
                user.isEnable(), true, true, true, authorities);
    }
	
	
	

}
