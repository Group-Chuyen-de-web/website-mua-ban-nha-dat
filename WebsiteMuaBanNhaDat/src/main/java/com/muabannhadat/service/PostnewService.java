package com.muabannhadat.service;

import java.util.List;

import com.muabannhadat.entity.PostNewsEntity;

public interface PostnewService {
	public void savePostnew(PostNewsEntity postnews);

	 List<PostNewsEntity> getAll();
	 
	 List<PostNewsEntity> getByNewsType(String code);
	 
	 

}
