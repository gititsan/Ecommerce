package com.sana.category.service;

import java.util.List;

import com.sana.category.model.Category;

public interface CategoryService {
	public List<Category> getListCategorys();
	public void saveAndUpdate( Category category );
	public void deleteCategory( String id );
	public Category getCategoryById( String id );
}
