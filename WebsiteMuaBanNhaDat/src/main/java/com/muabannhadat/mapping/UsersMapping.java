package com.muabannhadat.mapping;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.muabannhadat.entity.UsersEntity;
import com.muabannhadat.model.UserModel;

public class UsersMapping implements IMapping<UserModel, UsersEntity>{

	@Override
	public UsersEntity mapToEntity(UserModel model) {
		UsersEntity entity = new UsersEntity();
		entity.setEmail(model.getEmail());
		try {
			entity.setPass(convertHashToString(model.getPass()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entity.setAddress(model.getAddress());
		entity.setBirthday(model.getBirthday());
		entity.setPhone(model.getPhone());
		return entity;
	}

	@Override
	public UserModel mapToModel(UsersEntity entity) {
		// TODO Auto-generated method stub
		UserModel model = new UserModel();
		model.setEmail(entity.getEmail());
//		model.setPass(entity.getPass());
		model.setAddress(entity.getAddress());
		model.setBirthday(entity.getBirthday());
		model.setPhone(entity.getPhone());
		//TODO
		model.setPostnews(null);
		model.setNewposted(null);
		return null;
	}
	private String convertHashToString(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	@Override
	public List<UsersEntity> mapToEntityList(List<UserModel> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> mapToModelList(List<UsersEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
