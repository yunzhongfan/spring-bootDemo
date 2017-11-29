package com.imooc.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
@ConfigurationProperties(prefix = "com.dudu")
public class ConfigBean {
	
	 private String name;
	 private String want;


}
