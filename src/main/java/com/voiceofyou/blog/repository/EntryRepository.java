package com.voiceofyou.blog.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.voiceofyou.blog.domain.Entry;

public interface EntryRepository extends PagingAndSortingRepository<Entry, Integer> {
	@Query("select e from entry e order by e.postDate desc")
	public Page<Entry> findAll(Pageable pageable);
}
