package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class UserMongoDb {
	
	@Autowired(required=true)
	 private MongoTemplate mongoTemplate;

	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	/**
	 * inserting a single document or a document on a key
	 * 
	 * @return
	 */
	public String insert() {

		/**
		 * insert a document with "_id"
		 */
		/*BasicDBObject document = new BasicDBObject();
		UUID uuid=UUID.randomUUID();
		document.put("_id", uuid.toString());
		document.put("PAGE_UUID", uuid.toString());
		mongoTemplate.insert(document, "abc");*/
		
		/**
		 * inserting a document on a key
		 */
		UUID uuid=UUID.randomUUID();
		BasicDBObject document = new BasicDBObject();
		document.put("_id", uuid.toString());
		document.put("PAGE_UUID", uuid.toString());
		document.put("name", "lokesh");
		document.put("website", "howtodoinjava.com");
		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("TEST_NAME", "Mongo Test");
		documentDetail.put("TOTAL_MARKS",100);
		documentDetail.put("DURATION", 60);
		document.put("TEST_DETAILS", documentDetail);
		mongoTemplate.insert(document,"abc");
		
		
		return "Hi";
	}

	/**
	 * remove a single document
	 * @return
	 */
	public String delete() {

		BasicDBObject document = new BasicDBObject();
		document.put("A", "a");
		// document.put("city", "NY");
		mongoTemplate.remove(document);
	    return "Hi";
	}
	/**
	 * inserting a single document
	 * 
	 * @return
	 */
	public String insertWithWhere() {
		
		/**
		 * inserting a document on a key
		 */
		UUID uuid=UUID.randomUUID();
		BasicDBObject document = new BasicDBObject();
		document.put("_id", uuid.toString());
		document.put("PAGE_UUID", uuid.toString());
		document.put("name", "lokesh");
		document.put("website", "howtodoinjava.com");
		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("TEST_NAME", "Mongo Test");
		documentDetail.put("TOTAL_MARKS",100);
		documentDetail.put("DURATION", 60);
		document.put("TEST_DETAILS", documentDetail);
		mongoTemplate.insert(document,"abc");

		List<BasicDBObject> list_document = new ArrayList<BasicDBObject>();

		BasicDBObject document_a = new BasicDBObject();
		document_a.put("A", "a");
		document_a.put("A1", "a1");
		list_document.add(document_a);
		BasicDBObject document1 = new BasicDBObject();
		document1.put("SUBJECT", list_document);
		//mongoTemplate.insert(document1,"abc");
		document = new BasicDBObject();
		document.put("A2", "a2");
		document.put("A3", "a3");
		document1 = new BasicDBObject();
		
		document1.put("SUBJECT", list_document);
		//mongoTemplate.insert(document1,"abc");
		
		return "Hi";
	}

}

