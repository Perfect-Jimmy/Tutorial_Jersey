package tutorial.jersey.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
//默认情况下，资源类的生命周期是per-request，也就是系统会为每个匹配资源类URI的请求创建一个实例，
//这样的效率很低，可以对资源类使用@Singleton注解，这样在应用范围内，只会创建资源类的一个实例
@Singleton 
@Component
@RestController
@Path("/jersey")
public class JerseyController {
	    @GET
	    @Path("get")
	    //定义请求的媒体类型，如果不指定，则容器默认可接受任意媒体类型，容器负责确认被调用的方法可接受HTTP请求的媒体类型，否则返回415 Unsupported Media Type
	    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    //定义响应媒体类型，如果不指定，则容器默认可接受任意媒体类型，容器负责确认被调用的方法可返回HTTP请求可以接受媒体类型，否则返回406 Not Acceptable
	    @Produces(MediaType.APPLICATION_JSON)
	    public Map<String, String> getMessage() {
	    	Map<String, String> map = new HashMap<String,String>(); 
	    	map.put("Id", "100");
	    	map.put("Name", "Jimmy");
	        return map;
	    }

	    @GET
	    @Path("/getXML/{param1}/{param2}")
	    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    @Produces(MediaType.APPLICATION_XML)
	    public String getMessageStr(@PathParam("param2")String userName,@DefaultValue("china")@QueryParam("address")String address) {
	    	System.out.println(address+"-==============");
	    	String str = "hello " + userName+"-"+address;
	        return str;
	    }
	    
	    @POST	
	    @Path("/post")
	    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    @Produces(MediaType.APPLICATION_JSON)
	    public Map<String, String> postMessage() {
	    	Map<String, String> map = new HashMap<String,String>(); 
	    	map.put("Id", "101");
	    	map.put("Name", "Lucy");
	        return map;
	    }
}
