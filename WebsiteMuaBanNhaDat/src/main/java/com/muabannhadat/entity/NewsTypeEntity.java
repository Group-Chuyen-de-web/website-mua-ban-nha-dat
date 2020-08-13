package com.muabannhadat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "NEWSTYPE")
public class NewsTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String code;
	
	private String status;
	
	@OneToMany (mappedBy = "news_id", cascade = CascadeType.ALL)
	private List<PostNewsEntity> post_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PostNewsEntity> getPost_id() {
		return post_id;
	}

	public void setPost_id(List<PostNewsEntity> post_id) {
		this.post_id = post_id;
	}
	
//	@Override
//	public String toString() {
//		return this.name;
//	}

}
