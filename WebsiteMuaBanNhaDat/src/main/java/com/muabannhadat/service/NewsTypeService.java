package com.muabannhadat.service;

import java.util.List;

import com.muabannhadat.entity.NewsTypeEntity;

public interface NewsTypeService {

	List<NewsTypeEntity> getAll();
	NewsTypeEntity getByCode(String code);
}
