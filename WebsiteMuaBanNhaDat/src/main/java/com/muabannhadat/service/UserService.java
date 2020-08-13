package com.muabannhadat.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.muabannhadat.entity.UsersEntity;
@Service
public interface UserService {

	    public void saveUser(UsersEntity users);
	    public List<UsersEntity> findAll();
	    public UsersEntity findUser(String email, String pass);
	    public UsersEntity findOne(String name, String status);
	    public UsersEntity findOne(String username);
	    public boolean checkUser(String username);
	     
	    


}
