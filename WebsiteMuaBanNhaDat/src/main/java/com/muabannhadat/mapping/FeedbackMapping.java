package com.muabannhadat.mapping;

import java.util.List;

import com.muabannhadat.entity.FeedbackEntity;
import com.muabannhadat.model.FeedbackModel;

public class FeedbackMapping implements IMapping<FeedbackModel, FeedbackEntity> {
	FeedbackTypeMapping mappingtype = new FeedbackTypeMapping();
	UsersMapping mappinguser = new UsersMapping();

	@Override
	public FeedbackEntity mapToEntity(FeedbackModel model) {
		FeedbackEntity entity = new FeedbackEntity();
		entity.setTime(model.getTime());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeedbackModel mapToModel(FeedbackEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedbackEntity> mapToEntityList(List<FeedbackModel> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedbackModel> mapToModelList(List<FeedbackEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
