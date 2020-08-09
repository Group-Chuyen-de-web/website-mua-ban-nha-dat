package com.muabannhadat.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSTDETAIL")
public class PostDetailEntity {
//	post_detail(id,content,area,address,list_image,phone,price,type_property)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String content;

	private int area;

	private String address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "ITEM_IMAGES", joinColumns = @JoinColumn(name = "detail_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
	private Set<ImagesEntity> images;

	private String phone;

	private double price;

}
