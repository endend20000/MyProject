package com.spring.mongodemo.service.serviceimpl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.spring.mongodemo.model.User;
import com.spring.mongodemo.service.MongoDemo;

@Service
public class MongoDemoImpl implements MongoDemo{
	
	//@Resource
	private MongoTemplate mongoService;
				
				@Override
				public void getByName(){
					Query q = new Query(Criteria.where("name").is("大和2"));
					
					
					
					DBCollection db= mongoService.getCollection("ng");

					BasicDBObject queryObject = new BasicDBObject("name","大和2");
					
					DBObject obj=db.findOne(queryObject);
					System.out.println(obj.toString());
					
			//		User user=mongoService.findOne(q, User.class);
				//	System.out.println(user.getAge());
					
					//OssPartInfo ossPart= mongoService.findOne(q, OssPartInfo.class);
				}
				@Override
				public void insert(){
					User user=new User();
					user.setId(UUID.randomUUID().toString());
					user.setAge(19);
					user.setName("大和3");
					
			    	mongoService.insert(user,"ng");

			    	DBCollection db= mongoService.getCollection("ng");
			    
			    	
			    	System.out.println(db.toString());
				}
				@Override
				public void delete(){
					DBCollection db= mongoService.getCollection("ng");
					
					BasicDBObject queryObject = new BasicDBObject("name","大和2");
	
					WriteResult wr=db.remove(queryObject);
					
					System.out.println(wr.toString());
				}
				public void update(){
					DBCollection db= mongoService.getCollection("ng");
					
					BasicDBObject queryObject = new BasicDBObject("name","大2");
					BasicDBObject queryObject2 = new BasicDBObject("age",200);
					WriteResult wr=db.update(queryObject, queryObject2);
					System.out.println(wr.toString());
				}
}
