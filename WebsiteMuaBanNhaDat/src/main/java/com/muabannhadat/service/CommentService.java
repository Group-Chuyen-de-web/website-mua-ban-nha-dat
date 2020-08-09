package com.muabannhadat.service;

import java.util.List;

import com.muabannhadat.entity.CommentEntity;
import com.muabannhadat.entity.PostNewsEntity;

public interface CommentService {
	public void savePostnew(CommentEntity comment);
	 
	 public List<PostNewsEntity> getListPostnewByIdPostnew(int idPostnew);
}
