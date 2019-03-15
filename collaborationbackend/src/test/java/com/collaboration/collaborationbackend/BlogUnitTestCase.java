package com.collaboration.collaborationbackend;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.collaboration.collaborationbackend.dao.BlogDao;
//import com.collaboration.collaborationbackend.model.Blog;
//import com.collaboration.collaborationbackend.model.UserDetail;

public class BlogUnitTestCase {

//	@Autowired
//	BlogDao blogdao;

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();

	}

//	@Test
//	public void createBlogUnitTest() {
//		// UserDetail d=new UserDetail();
//		// d.setEmailId("mu@gmail.com");
//		// d.setFirstName("dfd");
//		// d.setIsOnline("offline");
//		// d.setLastName("sfsf0");
//		// d.setPassword("dfsdfsd");
//		// d.setRole("dfd");
//		// d.setUser_Id(34);
//		//
//		Blog blog = new Blog();
//
//		blog.setBlogName("nivetha");
//		blog.setBlogContent("good");
//		blog.setCreateDate(new Date());
//		blog.setLikes(1);
//		blog.setStatus("online");
//		// blog.setUser(d);
//
//		//assertTrue(blogdao.addBlog(blog));
//
//	}

}
