package com.voiceofyou.blog.repository;


import org.springframework.data.repository.CrudRepository;

import com.voiceofyou.blog.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
