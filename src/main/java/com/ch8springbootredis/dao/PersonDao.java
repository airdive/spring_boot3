package com.ch8springbootredis.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.ch8springbootredis.domain.Person;

@Repository
public class PersonDao {

	//下面4个都不支持集群
	@Autowired
	StringRedisTemplate stringRedisTemplate; //spring boot已为我们配置StringRedisTemplate，在此处可以直接注入

	@Resource(name="stringRedisTemplate")
	ValueOperations<String,String> valOpsStr; //可以使用@Resource注解指定的stringRedisTemplate，可注入基于字符串的简单属性操作方法

	@Autowired
	RedisTemplate<Object, Object> redisTemplate; //spring boot已为我们配置RedisTemplate，在此处可以直接注入

	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps; //可以使用@Resource注解指定的redisTemplate，可注入基于对象的简单属性操作方法

	public void stringRedisTemplateDemo(){ //通过set方法存储字符串类型
		valOpsStr.set("xx", "yy");
	}

	public void save(Person person){ //通过set方法存储对象类型
		valOps.set(person.getId(),person);
	}

	public String getString(){//通过get方法，获得字符串
		return valOpsStr.get("xx");
	}

	public Person getPerson(){//通过get方法，获得对象
		return (Person) valOps.get("1");
	}

}
