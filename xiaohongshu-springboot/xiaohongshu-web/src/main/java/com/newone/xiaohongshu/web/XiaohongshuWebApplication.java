package com.newone.xiaohongshu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.newone.xiaohongshu.*"})
public class XiaohongshuWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaohongshuWebApplication.class, args);
	}

}
