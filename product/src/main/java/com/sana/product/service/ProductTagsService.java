package com.sana.product.service;

import java.util.List;

import com.sana.product.model.Product;
import com.sana.product.model.Tags;

public interface ProductTagsService {
	
	public List<Tags> getListProductTags();
	public void saveAndUpdate( Tags tags );
	public void deleteProductTags( String id );
	public Tags getProductTagsById( String id );

}
