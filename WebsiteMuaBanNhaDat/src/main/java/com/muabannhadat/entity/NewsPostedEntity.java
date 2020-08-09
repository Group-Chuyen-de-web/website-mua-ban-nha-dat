package com.muabannhadat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NEWPOSTED")
public class NewsPostedEntity {
//	news_posted(id,id_users,id_post_news,time,status)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne @PrimaryKeyJoinColumn
	private PostNewsEntity post_id;
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private UsersEntity user_id;
	
	//ngay luu
	private Date time;
	
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PostNewsEntity getPost_id() {
		return post_id;
	}

	public void setPost_id(PostNewsEntity post_id) {
		this.post_id = post_id;
	}

	public UsersEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UsersEntity user_id) {
		this.user_id = user_id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
