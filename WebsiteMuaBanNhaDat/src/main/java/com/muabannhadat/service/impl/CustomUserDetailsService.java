package com.muabannhadat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.muabannhadat.authentication.MyUser;
import com.muabannhadat.constants.Constant;
import com.muabannhadat.entity.RoleEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersEntity userEntity = userRepository.findOneByUsernameAndStatus(username, Constant.ACTIVE_STATUS);
//		System.out.println(userEntity);
		System.out.println("sâsasasasasasa");
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : userEntity.getRole_id()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
//		UserModel userModel = new UserModel(userEntity.getEmail(), userEntity.getPass(), authorities);
//		userModel.setName(userEntity.getName());
//		return (UserDetails) userModel;
		MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPass(), true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullname());
		return myUser;
	}

}
