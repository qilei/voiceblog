package com.voiceofyou.blog.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.voiceofyou.blog.domain.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {
	
}
