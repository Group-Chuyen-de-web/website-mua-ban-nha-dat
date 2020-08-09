package com.muabannhadat.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "NEWSTYPE")
public class NewsType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String code;
	
	private String status;
	
	@OneToMany (mappedBy = "news_id")
	private List<PostNewsEntity> post_id;

}
