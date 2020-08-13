package com.muabannhadat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.PostNewsEntity;
@Repository("postnewRespository")
public interface PostnewRespository extends JpaRepository<PostNewsEntity, Long>{
	List<PostNewsEntity> findAllByStatus(String status);

}

