package Dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	 JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}
    public String Insert() {
		
		String sql="select NAME from employee1 where empid=1";
		//return  template.queryForList(sql);
		try {
			
		String str=(String) jdbcTemplate.queryForObject(sql,String.class);
		return  str;
		}catch(Exception e) {
			return "Error";
		}
	}
	
	

}

