package com.voiceofyou.blog.service.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;
import com.voiceofyou.blog.domain.Entry;
import com.voiceofyou.blog.repository.EntryRepository;
import com.voiceofyou.blog.service.EntryService;


@Service("entryService")
@Repository
@Transactional
public class EntryServiceImpl implements EntryService {
	private EntryRepository entryRepository;

	@Autowired
	public EntryServiceImpl(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	public Entry add(Entry entry) {
		return entryRepository.save(entry);
	}
	
	public Entry find(int id){
		return entryRepository.findOne(id);
	}

	public List<Entry> findAll() {
		return Lists.newArrayList(entryRepository.findAll());
	}

	@Override
	public Page<Entry> findAll(Pageable pageable) {
		return entryRepository.findAll(pageable);
	}

	@Override
	public Entry update(Entry entry) {
		return entryRepository.save(entry);
	}

	@Override
	public void delete(int id) {
		entryRepository.delete(id);
	}

	@Override
	public void addViewCount(int id) {
		Entry entry=find(id);
		entry.setViewCount(entry.getViewCount()+1);
		entryRepository.save(entry);
	}

	@Override
	public Entry save(Entry entry) {
		if(entry.getId() == 0){
			entry.setPostDate(new Date());
		}
		return entryRepository.save(entry);
	}

}
