package com.collaboration.collaborationbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTestCase {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();

	}

}
