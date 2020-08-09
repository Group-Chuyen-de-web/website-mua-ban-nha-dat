package com.muabannhadat.mapping;

import java.util.ArrayList;
import java.util.List;

import com.muabannhadat.entity.CommentEntity;
import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.CommentModel;

public class CommentMapping implements IMapping<CommentModel, CommentEntity> {
	UsersMapping mapping = new UsersMapping();

	@Override
	public CommentEntity mapToEntity(CommentModel model) {
		CommentEntity entity = new CommentEntity();
		entity.setContent(model.getContent());
		entity.setTime(model.getTime());
		// lấy user hiện tại
		// TODO
		UsersEntity usersEntity = null;
		entity.setUser_id(usersEntity);
		return entity;
	}

	@Override
	public CommentModel mapToModel(CommentEntity entity) {
		CommentModel model = new CommentModel();
		model.setContent(entity.getContent());
		model.setTime(entity.getTime());
		return model;
	}

	@Override
	public List<CommentEntity> mapToEntityList(List<CommentModel> models) {
		
		return null;
	}

	@Override
	public List<CommentModel> mapToModelList(List<CommentEntity> entities) {
		List<CommentModel> models = new ArrayList<CommentModel>();
		for (CommentEntity entity : entities) {
			CommentModel model = mapToModel(entity);
			models.add(model);
		}
		return models;
	}

}
