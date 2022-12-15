package com.koreanair.api.runner;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(2)
public class ApplicationInfoRunner implements ApplicationRunner{

	@Autowired
	private ApplicationContext applicationContext;	
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		InetAddress Address = InetAddress.getLocalHost();
		int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 1080);
		log.debug("로컬 컴퓨터의 이름 : "+Address.getHostName());
		log.debug("로컬 컴퓨터의 IP 주소 : "+Address.getHostAddress());
		log.debug("로컬 컴퓨터의 Port 주소 : "+port);
	}
}
