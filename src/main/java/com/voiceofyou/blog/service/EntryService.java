package com.voiceofyou.blog.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.voiceofyou.blog.domain.Entry;

public interface EntryService {
	Entry add(Entry entry);
	
	Page<Entry> findAll(Pageable pageable);
	
	Entry find(int id);
	
	Entry save(Entry entry);
	
	Entry update(Entry entry);
	
	void delete(int id);
	
	/**
	 * 增加浏览次数
	 * @param entry
	 */
	void addViewCount(int id);
}
