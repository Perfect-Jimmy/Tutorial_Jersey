package tutorial.jersey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import tutorial.jersey.pojo.User;

@Singleton 
@Component
@RestController
@Path("/user")
public class JerseyControllerXml {
	//返回多节点xml
	@GET
	@Produces(MediaType.APPLICATION_XML)  
	public List<User> getAllUser(){
		List<User> users = new ArrayList<User>();
		users.add(new User("001","HuiJia","26"));
		users.add(new User("002","Andy","23"));
		users.add(new User("003","BoWen","21"));
		return users;
	}
	
	//返回单节点xml
	@GET
	@Produces(MediaType.APPLICATION_XML)  
	@Path("/getUser")
	public User getUser(){
		User user = new User("004","Lucy","26");
		return user;
	}
	
	//返回单节点xml
	@GET
	@Produces(MediaType.APPLICATION_JSON)  
	@Path("/getUserJson")
	public User getUserJson(){
		User user = new User("004","Lucy","26");
		return user;
	}
}
