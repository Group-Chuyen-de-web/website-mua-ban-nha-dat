package com.muabannhadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.PackageTypeEntity;
import com.muabannhadat.repository.PackageTypeRespository;
import com.muabannhadat.service.PackageTypeService;
@Repository("packageTypeService")
public class PackageTypeImpl implements PackageTypeService{

	@Autowired
	PackageTypeRespository packageTypeRespository;
	@Override
	public List<PackageTypeEntity> getAll() {
		
		return packageTypeRespository.findAll();
	}

	@Override
	public PackageTypeEntity getByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
