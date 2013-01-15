package com.voiceofyou.blog.repository;


import org.springframework.data.repository.CrudRepository;

import com.voiceofyou.blog.domain.ShiroUser;

public interface ShiroUserRepository extends CrudRepository<ShiroUser,Integer> {
	ShiroUser getShiroUserByUserId(String userId);

}
