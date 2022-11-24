package com.sana.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.product.model.Tags;

 

@Repository
public interface ProductTagsRepository extends JpaRepository<Tags, String>{
	
}
