package com.spring.mongodemo.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MongoDemoTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private MongoDemo mongoDemo;
	
	//@Test
	public void insertTest(){
		mongoDemo.insert();
	}
	//@Test
	public void getByNameTest(){
		mongoDemo.getByName();
	}
	@Test
	public void deleteTest(){
		mongoDemo.delete();
	}
}
