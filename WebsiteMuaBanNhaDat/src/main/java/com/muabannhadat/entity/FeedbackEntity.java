package com.muabannhadat.entity;

import java.util.Date;

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
@Table(name = "FEEDBACK")
public class FeedbackEntity {
//feedback(id,feedback_type,id_post_news,id_users, status)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne @PrimaryKeyJoinColumn
	private FeedbackTypeEntity type;
	
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	@ManyToOne
	private PostNewsEntity post_id;
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private UsersEntity user_id;
	
	private Date time;
	
	private String status;
}
