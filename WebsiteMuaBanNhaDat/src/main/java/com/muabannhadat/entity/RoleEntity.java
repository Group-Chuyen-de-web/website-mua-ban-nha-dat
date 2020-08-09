package com.muabannhadat.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RoleEntity {
//	role(id,code,name,status)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String code;
	
	private String name;
	
	private String status;
	
	@ManyToMany(mappedBy="role_id")
	private List<UsersEntity> user_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UsersEntity> getUser_id() {
		return user_id;
	}

	public void setUser_id(List<UsersEntity> user_id) {
		this.user_id = user_id;
	}
	
	
}
