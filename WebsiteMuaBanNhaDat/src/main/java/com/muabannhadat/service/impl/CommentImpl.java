package com.muabannhadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muabannhadat.entity.CommentEntity;
import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.repository.CommentRespository;
import com.muabannhadat.service.CommentService;
@Repository("commentService")
public class CommentImpl implements CommentService{

	@Autowired
	CommentRespository commentRespository;
	@Override
	@Transactional
	public void savePostnew(CommentEntity comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<PostNewsEntity> getListPostnewByIdPostnew(int idPostnew) {
		// TODO Auto-generated method stub
		return null;
	}

}
