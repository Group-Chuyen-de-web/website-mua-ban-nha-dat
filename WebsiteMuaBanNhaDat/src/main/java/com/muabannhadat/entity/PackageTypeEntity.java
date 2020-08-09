package com.muabannhadat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PACKAGETYPE")
public class PackageTypeEntity {
//packege_type(id,packege_name,price_type,status)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String code;
	
	private String price;
	
	private String status;
	
}
