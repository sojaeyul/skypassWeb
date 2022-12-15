package com.koreanair.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.koreanair.api.mybatis.TestMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MybaService {
	@Autowired
	TestMapper mapper;
	
	@Autowired
	PlatformTransactionManager manager;
	
	public int totSize(String str) {
		
		TransactionStatus status = 
				manager.getTransaction(new DefaultTransactionDefinition());
		int totSize =0;
		try {
			totSize = mapper.totSize("");
			log.debug("totSize ::"+ totSize);

			manager.commit(status);
		}catch(Exception ex) {
			ex.printStackTrace();
			manager.rollback(status);
		}finally {
			
		}
		return totSize;
	}
	
}