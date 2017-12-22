package com.util;

import java.io.IOException;
import java.util.Properties;

public  class ConfigUtil {
	
	static Properties pro = new Properties();
	
	static{
		try {
			pro.load(ConfigUtil.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 通过键获取值
	 * @param key
	 * @return
	 */
	//静态方法，通过类名调用
	public static String getProValues(String key){
		return pro.getProperty(key);
	}
	
	
}
