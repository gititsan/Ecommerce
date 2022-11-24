package com.sana.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.product.model.Product;
import com.sana.product.model.Tags;
import com.sana.product.repository.ProductRepository;
import com.sana.product.repository.ProductTagsRepository;

@Service
public class ProductTagsServiceImp implements ProductTagsService{

	
	@Autowired
	private ProductTagsRepository productTagsRepository;
	
	@Override
	public List<Tags> getListProductTags() {
		return productTagsRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Tags tags) {
		productTagsRepository.save(tags);
		
	}

	@Override
	public void deleteProductTags(String id) {
		productTagsRepository.deleteById(id);
		
	}

	@Override
	public Tags getProductTagsById(String id) {
		return productTagsRepository.findById(id).get();
	}
	
	

}
