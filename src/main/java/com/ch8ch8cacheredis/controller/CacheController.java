package com.ch8ch8cacheredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ch8ch8cacheredis.service.DemoService;
import com.ch8ch8cacheredis.service.domain.Person;

@RestController
public class CacheController {

	@Autowired
	DemoService demoService;

	//http://localhost:8081/boot/put?id=1&name=z&age=30&address=bj
	//先缓存
	@RequestMapping("/put")
	public Person put(Person person){
		return demoService.save(person);

	}

	//http://localhost:8081/boot/able?id=1
	@RequestMapping("/able")
	public Person cacheable(Person person){
		return demoService.findOne(person);
	}

	//http://localhost:8081/boot/evit?id=1
	@RequestMapping("/evit")
	public String evit(Long id){
		 demoService.remove(id);
		 return "ok";
	}

}
