package Controller;

import java.util.HashMap;
import java.util.Map;


import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Service.UserService;

@RestController
public class User {
	
	@Autowired
	UserService serv_user;

	private static final Logger LOGGER = Logger.getLogger(User.class);
	
	@RequestMapping(value = "reg/getReg", method = RequestMethod.POST)
	public Map<String,Object> A(@RequestBody String str) {
		
		LOGGER.debug("reg/getReg");
		
		JSONObject obj = new JSONObject(str);
		serv_user.insertMysql();
		byte[] bytesEncoded = Base64.decodeBase64(obj.getString("data").toString().getBytes());
		LOGGER.debug("reg/getReg");
		LOGGER.debug("reg/getReg");
		String str_obj=new String(bytesEncoded);
		
		
		/*
		 * //obj=new JSONObject(str_obj); //String str1=obj.getString("a").toString();
		 * //int a1=obj.getInt("a"); //String str_a=serv_user.A(); //String
		 * str_redis=serv_user.getRedisData(); //System.out.println("A: "+str_a);
		 * //System.out.println("Redis Data: "+str_redis);
		 * 
		 * //String str2=obj.getString("b").toString();
		 */
		// serv_user.insertIntoMongo();
		
		//System.out.println("A: "+str1+" B: "+str2);
		
		serv_user.insertMysql();
		Map<String,Object> hmap=new HashMap<String,Object>();
		
		hmap.put("Name","Abhi");
				
		return hmap;
	}
	@RequestMapping(value = "reg/getSetMongo", method = RequestMethod.POST)
	public Map<String,Object> Mongo(@RequestBody String str) {
		
		LOGGER.debug("reg/getReg");
		
		JSONObject obj = new JSONObject(str);
		//serv_user.insertIntoMongo();
		
		serv_user.insertWthWhereIntoMongo();
		
		//serv_user.deleteFromMongo();
		
		//System.out.println("A: "+str1+" B: "+str2);
		
		Map<String,Object> hmap=new HashMap<String,Object>();
		
		//System.out.println(HttpServletRequest);
		//System.out.println(getServletRequest().getRemoteAddr());
		
		hmap.put("Name","Abhi");
				
		return hmap;
	}
	
	@RequestMapping(value = "setGetXlxFile", method = RequestMethod.POST)
	public Map<String,Object> setGetInExcel(@RequestBody String str) {
		
		
		
		Map<String,Object> hmap=new HashMap<String,Object>();
		
		serv_user.setGetExcel();
		
		hmap.put("Name","Abhi");
				
		return hmap;
	}
	
	

}
