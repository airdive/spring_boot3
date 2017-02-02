package com.ch8ch8cacheredis.service;

import com.ch8ch8cacheredis.service.domain.Person;

public interface DemoService {

	public Person save(Person person);

	public void remove(Long id);

	public Person findOne(Person person);

}
