package com.takemehand.p2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2PApplication {

	public static void main(String[] args) {
		SpringApplication.run(P2PApplication.class, args);
		System.out.println("系统启动正常");
	}

}
