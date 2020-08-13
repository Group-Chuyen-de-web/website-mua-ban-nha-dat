package com.muabannhadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.repository.UserRepository;
import com.muabannhadat.service.UserService;
@Repository("userService")
public class UserImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(UsersEntity users) {
		userRepository.save(users);
	}

	@Override
	public List<UsersEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UsersEntity findUser(String email, String pass) {
		for (UsersEntity usersEntity : findAll()) {

			if (usersEntity.getEmail().equalsIgnoreCase(email)&&usersEntity.getPass().equals(pass)) {
				return usersEntity;
			}
		}
		return null;
	
	}

	@Override
	public UsersEntity findOne(String name, String status) {
		UsersEntity entity= userRepository.findOneByUsernameAndStatus(name, status);
		return entity;
	}

	@Override
	public UsersEntity findOne(String username) {
		
		return userRepository.findOneByUsername(username);
	}

	@Override
	public boolean checkUser(String username) {
		if(findOne(username)==null) {
			return true;
		}
		return false;
	}

	
}
