package com.muabannhadat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muabannhadat.entity.CommentEntity;
import com.muabannhadat.entity.PostNewsEntity;
@Service
public interface CommentService {
	public void savePostnew(CommentEntity comment);
	 
	 public List<PostNewsEntity> getListPostnewByIdPostnew(int idPostnew);
}
