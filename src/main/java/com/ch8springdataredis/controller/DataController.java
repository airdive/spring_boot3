package com.ch8springdataredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ch8springdataredis.dao.PersonDao;
import com.ch8springdataredis.domain.Person;

@RestController
public class DataController {

	@Autowired
	PersonDao personDao;

	//http://localhost:8081/boot/set
	@RequestMapping("/set") //1
	public void set(){
		Person person = new Person("1","wyf6655", 32);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}

	//http://localhost:8081/boot/getStr
	@RequestMapping("/getStr") //2
	public String getStr(){
		return personDao.getString();
	}

	//http://localhost:8081/boot/getPerson
	@RequestMapping("/getPerson") //3
	public Person getPerson(){
		return personDao.getPerson();
	}

}
