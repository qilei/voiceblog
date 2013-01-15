package com.voiceofyou.blog.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voiceofyou.blog.domain.AppUser;
import com.voiceofyou.blog.repository.UserRepository;
import com.voiceofyou.blog.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public AppUser addUser(AppUser user) {
		return userRepository.save(user);
	}

	public AppUser FindById(int id) {
		return userRepository.findOne(id);
	}

}
