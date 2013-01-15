package com.voiceofyou.blog.service;

import com.voiceofyou.blog.domain.ShiroUser;

public interface ShiroUserService {
	ShiroUser getById(int id);
	
	ShiroUser getByUserId(String userId);
	
	void addShiroUser(ShiroUser user);
}
