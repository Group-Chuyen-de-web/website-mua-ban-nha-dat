package com.muabannhadat.mapping;

import java.util.ArrayList;
import java.util.List;

import com.muabannhadat.entity.PostDetailEntity;
import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.PostNewModel;
import com.muabannhadat.model.UserModel;

public class PostnewMapping implements IMapping<PostNewModel, PostNewsEntity>{

	@Override
	public PostNewsEntity mapToEntity(PostNewModel model) {
		PostNewsEntity entity = new PostNewsEntity();
		entity.setTitle(model.getTitle());
		entity.setStart_day(model.getStart_day());
		entity.setEnd_day(model.getEnd_day());
		//newtypeEntity
		
		PostDatailMapping mapping_detail = new PostDatailMapping();
		PostDetailEntity detailEntity = mapping_detail.mapToEntity(model.getDetail());
		entity.setId_post_detail(detailEntity);
		
		UsersMapping mapping_user = new UsersMapping();
		UsersEntity usersEntity = mapping_user.mapToEntity(model.getUser());
		entity.setUser_id(usersEntity);
		
		return entity;
	}

	@Override
	public PostNewModel mapToModel(PostNewsEntity entity) {
		PostNewModel model = new PostNewModel();
		return model;
	}

	@Override
	public List<PostNewsEntity> mapToEntityList(List<PostNewModel> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostNewModel> mapToModelList(List<PostNewsEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	 user :title, start_date, area,price,image_default(1),
//	admin: end_day

}
