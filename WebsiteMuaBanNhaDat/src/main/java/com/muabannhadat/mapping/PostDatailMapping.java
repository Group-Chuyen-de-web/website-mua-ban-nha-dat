package com.muabannhadat.mapping;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.muabannhadat.entity.ImagesEntity;
import com.muabannhadat.entity.PostDetailEntity;
import com.muabannhadat.model.PostDetailModel;

public class PostDatailMapping implements IMapping<PostDetailModel, PostDetailEntity> {

	@Override
	public PostDetailEntity mapToEntity(PostDetailModel model) {
		PostDetailEntity entity = new PostDetailEntity();
		entity.setAddress(model.getAddress());
		entity.setArea(model.getArea());
		entity.setContent(model.getContent());
		
		List<ImagesEntity> images = new ArrayList<ImagesEntity>();
		
		entity.setPhone(model.getPhone());
		entity.setPrice(model.getPrice());
		return entity;
	}

	@Override
	public PostDetailModel mapToModel(PostDetailEntity entity) {
		PostDetailModel model = new PostDetailModel();
		model.setAddress(entity.getAddress());
		model.setArea(entity.getArea());
		model.setContent(entity.getContent());
		
		List<String> images = new ArrayList<String>();
		model.setPhone(entity.getPhone());
		model.setPrice(entity.getPrice());
		return model;
	}

	@Override
	public List<PostDetailEntity> mapToEntityList(List<PostDetailModel> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDetailModel> mapToModelList(List<PostDetailEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
