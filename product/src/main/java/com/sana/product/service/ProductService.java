package com.sana.product.service;

import java.util.List;

 

import com.sana.product.model.Product;


public interface ProductService {
	public List<Product> getListProducts();
	public void saveAndUpdate( Product product );
	public void deleteProduct( String id );
	public Product getProductById( String id );
}
