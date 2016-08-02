package com.common.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PropertiesUtil {
	
	/**
	 * 根据传入文件地址，返回map类型的键值对结果
	 * 
	 *@author 罗琦
	 *@date 2013-7-8
	 *@param url
	 *@throws Exception
	 *@return Map<String,String>
	 */
	public static Map<String, String> getPropertiesMap(String url) throws Exception{
		Map<String,String> resultMap = new HashMap<String,String>();
		
		try {
			Properties prop = new Properties();
			//路径如："com/tlj/scxt/common/properties/createDefaulField.properties"
			InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(url);
			prop.load(in);
			Set<Object> keyValue = prop.keySet();
			for (Iterator<Object> it = keyValue.iterator(); it.hasNext();) {
				String key = (String) it.next();
				String value = prop.getProperty(key);
				//对于结果有可能为中文所以需要进行转码操作				
				value = new String(value.getBytes("iso-8859-1"),"UTF-8");
				resultMap.put(key, value);
			}
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
