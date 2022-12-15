package com.koreanair;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import com.koreanair.api.runner.DatabaseRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GradleSkyPassWebProjectApplication implements ApplicationListener{

	
	@Autowired
	private ApplicationContext applicationContext;	
	public int portnum;
	
		
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		try {
			InetAddress Address = InetAddress.getLocalHost();
			int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);
			portnum = port;	
			   
			log.debug("로컬 컴퓨터의 이름 : "+Address.getHostName());
			log.debug("로컬 컴퓨터의 IP 주소 : "+Address.getHostAddress());
			log.debug("로컬 컴퓨터의 Port 주소 : "+port);
		   } catch (UnknownHostException e) {
		       e.printStackTrace();
		   }		
	}
	
	public static void main(String[] args) {		
		log.debug("!!!! Start GradleSkyPassWebProjectApplication !!!!");
		SpringApplication.run(GradleSkyPassWebProjectApplication.class, args);
	}

}
