package com.voiceofyou.blog.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.voiceofyou.blog.domain.Entry;

public interface EntryService {
	Entry add(Entry entry);
	
	Page<Entry> findAll(Pageable pageable);
	
	Entry find(int id);
}
