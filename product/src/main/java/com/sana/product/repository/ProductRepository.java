package com.sana.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sana.product.model.Product;

 

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	@Query(value="SELECT * FROM product p full outer join product_tags t on  t.product_id=p.id where p.description like %:description%  or p.name like %:description% or  t.tags = LOWER(:description) ",nativeQuery=true)
	List<Product> findProductByDescription( String description);

	
}
