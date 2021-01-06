package com.rst.helloworld.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "Learn here DevOps Tools - Jenkins, Maven, Git, GitHub, Docker, Kuberneties, Nagios etc. ";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "vCanIT Services, Inc.";
		}else{
			return name;
		}
		
	}

}
