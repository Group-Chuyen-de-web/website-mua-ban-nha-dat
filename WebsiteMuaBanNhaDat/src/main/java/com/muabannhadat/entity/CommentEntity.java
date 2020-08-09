package com.muabannhadat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class CommentEntity {
//comment(id,content,id_post_news,time_curren,id_users,status)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String content;

	@JoinColumn(name = "post_id", referencedColumnName = "id")
	@ManyToOne
	private PostNewsEntity post_id;

	private Date time;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private UsersEntity user_id;

	private String status;

}
