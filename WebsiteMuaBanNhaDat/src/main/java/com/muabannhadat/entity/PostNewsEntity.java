package com.muabannhadat.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "POSTNEW")
public class PostNewsEntity {
//	post_news(id,title,date_submitted,expiration_date,messager_type,id_package,id_post_detail,status).

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	@OneToOne @PrimaryKeyJoinColumn
	private PackageTypeEntity type_id;
	
	private String start_day;
	
	private String end_day;
	
	@ManyToOne
	@JoinColumn (name="news_id",referencedColumnName = "id")
	private NewsType news_id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @PrimaryKeyJoinColumn
	private PostDetailEntity id_post_detail;
	
	private String status;

	
	
	@OneToMany(mappedBy = "post_id")
	private List<CommentEntity> comment;

	@OneToMany(mappedBy = "post_id")
	private List<FeedbackEntity> feedback;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private UsersEntity user_id;
	


}
