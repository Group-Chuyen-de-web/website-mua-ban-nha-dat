package com.muabannhadat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muabannhadat.entity.PostNewsEntity;
@Service
public interface PostnewService {
	public void savePostnew(PostNewsEntity postnews);

	 List<PostNewsEntity> getAll();
	 
	 List<PostNewsEntity> getByNewsType(String code);
	 
	 PostNewsEntity getOne(long id);
	 
	 
	 

}
