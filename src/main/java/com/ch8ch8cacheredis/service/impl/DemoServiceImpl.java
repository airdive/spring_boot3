package com.ch8ch8cacheredis.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ch8ch8cacheredis.service.DemoService;
import com.ch8ch8cacheredis.service.domain.Person;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	@CachePut(value = "people", key = "#person.id")
	public Person save(Person person) {
		System.out.println("为id、key为:"+person.getId()+"数据做了缓存");
		return person;
	}

	@Override
	@CacheEvict(value = "people")//2
	public void remove(Long id) {
		System.out.println("删除了id、key为"+id+"的数据缓存");
		//这里不做实际删除操作
	}

	@Override
	@Cacheable(value = "people", key = "#person.id")//3
	public Person findOne(Person person) {
		System.out.println("为id、key为:"+person+"数据做了缓存");
		return person;
	}

}
