package com.muabannhadat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.NewsPostedEntity;
@Repository("newsPostedRespository")
public interface NewsPostedRespository extends JpaRepository<NewsPostedEntity, Long>{
	

}
