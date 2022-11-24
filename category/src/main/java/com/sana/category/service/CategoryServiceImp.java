package com.sana.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.category.model.Category;
import com.sana.category.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getListCategorys() {

		return categoryRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void deleteCategory(String id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public Category getCategoryById(String id) {
		return categoryRepository.findById(id).get();
				
	}
}
