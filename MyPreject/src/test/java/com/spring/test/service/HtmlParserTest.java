package com.spring.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class HtmlParserTest  extends AbstractJUnit4SpringContextTests{
	@Resource
	private HtmlParser htmlParser;
	
	@Test
	public void test(){
		htmlParser.test2();
	}
}
