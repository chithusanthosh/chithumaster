package com.chithu.app.usercontroller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chithu.app.entity.User;
import com.chithu.app.user.dao.UserDao;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/usr")
public class UserController {
	
	private Logger log = LogManager.getLogger();
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(path="/login/{userid}/{password}", method = RequestMethod.GET)
	public String getUser(@PathVariable("userid") String userid, @PathVariable String password) {
		log.info("class :: UserController :: Methohd :: getUser :: START");
		/* log.info("class :: Methohd :: END"); */
		return userDao.getUser(userid, password);
	}
	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	public String newUser(@RequestBody User user) {
		log.info("class :: UserController :: Methohd :: newUser :: START");
		int responseint = userDao.saveUser(user);
		/* log.info("class :: Methohd :: END"); */
		return Integer.toString(responseint);
	}
}
