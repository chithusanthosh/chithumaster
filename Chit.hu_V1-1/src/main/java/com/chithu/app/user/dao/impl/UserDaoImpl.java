package com.chithu.app.user.dao.impl;

import java.math.BigDecimal;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.chithu.app.database.Database;
import com.chithu.app.emailservice.EmailService;
import com.chithu.app.entity.ResponseJson;
import com.chithu.app.entity.User;
import com.chithu.app.rowmapper.UserRowMapper;
import com.chithu.app.user.dao.UserDao;
import com.chithu.app.util.Pojo2json;


@Service("userDao")
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	
	private Logger log = LogManager.getLogger();
	
	@Override
	public String getUser(String userid, String password) {
		
		
		
		log.info("class :: UserDaoImpl :: method :: getUser START");
		User usr = new User();
		String response;
		try {
			String sql = "select * from user01 where username = \""+userid+"\"";
			log.debug("class :: UserDaoImpl :: method :: getUser :: running query :: "+sql);
			usr = jdbctemplate.queryForObject(sql, new UserRowMapper());
			
			if(usr.getPassword().equalsIgnoreCase(password)) {
				response = Pojo2json.pojotoJSON().writeValueAsString(usr);
				log.info("class :: UserDaoImpl :: method :: getUser :: END");
				return response;
			}else {
				log.info("class :: UserDaoImpl :: method :: getUser :: END");
				return "{\"error\":\"userid/password incorrect\"}";
			}
		}catch(Exception e) {
			log.error("class :: UserDaoImpl :: Method :: getUser :: "+e.getCause()+" "+e.getMessage());
			log.info("class :: UserDaoImpl :: method :: getUser :: END");
			return "\"error\":\"Unexpected error\"";
		}
		
		
		
	}

	@Override
	public int saveUser(User user) {
		
		log.info("class :: UserDaoImpl :: method ::  saveUser :: START");
		
		int isnewUser = checkFormobileno(user.getMobilenumber());
		try {
			if(isnewUser == 1) {
					// User is already registered
				return 10;
			}else {
				String insertsql = "Insert into user01(username,firstname,lastname,mailid,mobilenumber,password) values(?,?,?,?,?,?)";
				String username = user.getFirstname()+getUsername();
				Object[] insertvalues = new Object[] {username,user.getFirstname(),user.getLastname(),user.getMailid(),user.getMobilenumber(),user.getPassword()};
				
				int[] types = new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.NUMERIC,Types.VARCHAR};
				
				int rowno = jdbctemplate.update(insertsql,insertvalues,types);
				if(rowno > 0) {
					log.info("class :: UserDaoImpl :: method ::  saveUser :: START");
					// User is successfully registered
					EmailService email = new EmailService();
					String mailmes = "username :: "+username+"\n\n"+"Thanks for registering with ChitF";
					email.sendSimpleMessage(user.getMailid(), "ChitF Username!!!",mailmes );
					return 00;
				}else {
					ResponseJson response = new ResponseJson();
					log.info("class :: UserDaoImpl :: method ::  saveUser :: START");
					// insert error
					return 20;
				}
			}
			
		}catch(Exception e) {
			log.error("class :: UserDaoImpl :: Method :: saveUser :: "+e.getCause()+" "+e.getMessage());
			log.info("class :: UserDaoImpl :: method ::  saveUser :: END");
			// Database error
			return 50;
		}
		
		
	}

	private int checkFormobileno(BigDecimal mobilenumber) {
		log.info("class :: UserDaoImpl :: method ::  checkFormobileno :: START");
		
		try {
			String sql ="select * from user01 where mobilenumber="+mobilenumber;
			
			User usr = jdbctemplate.queryForObject(sql, new UserRowMapper());
			
			if(usr != null) {
				return 1;
			}else {
				return 0;
			}
			
		}catch(Exception e) {
			log.error("class :: UserDaoImpl :: Method :: checkFormobileno :: "+e.getCause()+" "+e.getMessage());	
			return 9;
		}
		
	
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getUsername() {
		log.info("class :: UserDaoImpl :: method ::  getUsername :: START");
		int maxNum = 0;
		try {
			String sql ="select max(userid) from user01";
			
			maxNum = jdbctemplate.queryForObject(sql, Integer.class);
			
		}catch(Exception e) {
			log.error("class :: UserDaoImpl :: Method :: getUsername :: "+e.getCause()+" "+e.getMessage());	
		}
		return maxNum+1;
	}

}
