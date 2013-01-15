package com.voiceofyou.blog.service.jpa;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.voiceofyou.blog.domain.Category;
import com.voiceofyou.blog.repository.CategoryRepository;
import com.voiceofyou.blog.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public List<Category> findAll() {
		return Lists.newArrayList(categoryRepository.findAll());
	}	
}
