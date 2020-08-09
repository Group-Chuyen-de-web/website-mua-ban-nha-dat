package com.muabannhadat.service;

import java.util.List;

import com.muabannhadat.entity.PackageTypeEntity;

public interface PackageTypeService {
	List<PackageTypeEntity> getAll();
	PackageTypeEntity getByCode(String code);
}
