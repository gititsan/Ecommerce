package com.sana.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.product.model.Product;
import com.sana.product.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getListProducts() {

		return productRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.findById(id).get();
				
	}
}
