package com.voiceofyou.blog.service;

import com.voiceofyou.blog.domain.AppUser;

public interface UserService {
	AppUser addUser(AppUser user);
	
	AppUser FindById(int id);
}
