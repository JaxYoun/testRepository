/**
 * 
 * 成都铁路局科研所
 * <ul>
 * <li>Author: 焦运磊</li>
 * <li>E-Mail: jylapple@163.com</li>
 * <li>T-Phone: 18628168078</li>
 * <li>Date: 2012-12-11</li>
 * <li>Description:</li>
 * <li>+-History-------------------------------------+</li>
 * <li>| Date Author Description</li>
 * <li>|2012-12-11 焦运磊 Created</li>
 * <li>+------------------------------------------------</li>
 * </ul>
 */
package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.common.constant.SystemConstant;



/**
 *日期工具类
 */
public class DateUtil {

	/**
	 * 把日期转化为字符类型
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param pattern
	 * @return String
	 */
	public static String nowStringDate(String pattern) {
		return dateToString(new Date(), pattern);
	}

	/**
	 * 得到当前日期 
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param pattern
	 * @return Date
	 */
	public static Date nowDate(String pattern) {
		String nowStringDate = nowStringDate(pattern);
		return stringToDate(nowStringDate, pattern);
	}

	/**
	 *  日期转化字符
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @param pattern
	 * @param locale
	 * @return String
	 */
	public static String dateToString(Date date, String pattern, Locale locale) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
			return sdf.format(date); 
		}
		catch(Exception e){
			return "";
		}
	}

	/**
	 * 日期转化字符
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static String dateToString(Date date, String pattern) {
		Locale locale = Locale.getDefault();
		return dateToString(date, pattern, locale);
	}

	/**
	 * 字符类型日期转化为长类型
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param strDate
	 * @param pattern
	 * @param locale
	 * @throws ParseException
	 * @return long
	 */
	public static long stringToLong(String strDate, String pattern, Locale locale)throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		Date date = sdf.parse(strDate);
		return date.getTime();
	}

	/**
	 * 字符类型日期转化为长类型 
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param strDate
	 * @param pattern
	 * @throws ParseException
	 * @return long
	 */
	public static long stringToLong(String strDate, String pattern) throws ParseException {
		Locale locale = Locale.CHINESE;
		return stringToLong(strDate, pattern, locale);
	}

	/**
	 * 字符转化为日期
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param strDate
	 * @param pattern
	 * @return Date
	 */
	public static Date stringToDate(String strDate, String pattern) {
		try{
			long ltime = stringToLong(strDate, pattern);
			return new Date(ltime);
		}
		catch(Exception ex){
			return null;
		}
	}

	/**
	 *  字符转化为日期
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param strDate
	 * @param pattern
	 * @param otherPattern
	 * @return Date
	 */
	public static Date stringToDate(String strDate, String pattern, String otherPattern) {
		try{
			long ltime = stringToLong(strDate, pattern);
			return new Date(ltime);
		}
		catch(Exception ex){
			try{
				long ltime = stringToLong(strDate, otherPattern);
				return new Date(ltime);
			}
			catch(Exception e){
				return null;
			}
		}
	}

	/**
	 *  格式化日期
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @param pattern
	 * @return Date
	 */
	public static Date formatDate(Date date, String pattern) {
		String s = dateToString(date, pattern);
		return stringToDate(s, pattern);
	}

	/**
	 *  取得当前日期的天分
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @return int
	 */
	public static int getEmbodyDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyDay = calendar.get(Calendar.DAY_OF_MONTH);
		return embodyDay;

	}

	/**
	 * 取得当前日期的月份
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @return int
	 */
	public static int getEmbodyMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyMonth = calendar.get(Calendar.MONTH) + 1;
		return embodyMonth;

	}

	/**
	 * 取得当前日期的年份
	 * 
	 * @author 焦运磊
	 * @date 2011-4-6
	 * @param date
	 * @return int
	 */
	public static int getEmbodyYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int embodyYear = calendar.get(Calendar.YEAR);
		return embodyYear;
	}
	
	/**
	 * 日期的增减
	 *
	 * @param date 传入日期
	 * @param type 0:天，1:月，2：年
	 * @param number 具体数值，若要减则传入负数
	 * @return Date
	 * @author luoqi 
	 * @date 2013-7-25
	 */
	public static Date getDate(Date date,int type,int number) {
		if (null == date) {  
		   return null;  
		}
		int xType = 0;
		switch (type) {
		case 0:
			xType = Calendar.DATE;
			break;
		case 1:
			xType = Calendar.MONTH;
			break;
		case 2:
			xType = Calendar.YEAR;
			break;
		default:
			return null;
		}
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);   //设置当前日期  
        calendar.add(xType, number); //
        return formatDate(calendar.getTime(),SystemConstant.DATE_PATTEN);  
	}
	
	/**
	 * 生成日期
	 *
	 * @param year
	 * @param month
	 * @param day
	 * @return void
	 * @author luoqi 
	 * @date 2013-7-25
	 */
	public static Date generateDate(Integer year,Integer month, Integer day) {
		Calendar calendar = Calendar.getInstance();
		if(year != null) {
			calendar.set(Calendar.YEAR, year);
		}
		if(month != null) {
			calendar.set(Calendar.MONTH, month-1);
		}
		if(day != null) {
			calendar.set(Calendar.DATE, day);
		}
		return formatDate(calendar.getTime(),SystemConstant.DATE_PATTEN);
	}
	
	public static void main(String[] args) {
		//Date a = generateDate(2013, 12,25);
		//Date b = generateDate(2013, 8,30);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015,14-1, 1);
		System.out.println(dateToString(calendar.getTime(), SystemConstant.DATE_PATTEN));
	}
	
	/**
	 * 获取月份有多少天
	 *
	 * @return int
	 * @author luoqi 
	 * @date 2013-8-14
	 */
	public static int getMonthDays(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DATE, 1);//把日期设置为当月第一天
		calendar.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
		int maxDate = calendar.get(Calendar.DATE);
		return maxDate;
	}
	
	/**
	 * 获取传入日期所属月份的开始日期
	 * @param date 传入日期
	 * @return
	 */
	public static Date getMonthStartDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND,0);
		if(day >= 25) {
			c.set(Calendar.DAY_OF_MONTH, 25);
			return c.getTime();
		} else {
			c.set(Calendar.DAY_OF_MONTH, 25);
			c.add(Calendar.MONTH, -1);
			return c.getTime();
		}
	}
	
	/**
	 * 获取传入日期所属月份的结束日期
	 * @return
	 */
	public static Date getMonthEndDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND,59);
		int day = c.get(Calendar.DAY_OF_MONTH);
		if(day >= 25) {
			c.add(Calendar.MONTH, 1);
			c.set(Calendar.DAY_OF_MONTH, 24);
			return c.getTime();
		} else {
			c.set(Calendar.DAY_OF_MONTH, 24);
			return c.getTime();
		}
	}
	
	/**
	 * 生产专用，用于判断传入的日期是否属于某一个月的计划。
	 * 
	 *@author 罗琦
	 *@date 2013-11-25
	 *@param date
	 *@return Date
	 */
	public static Date getActualPlanDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(day > 25) {
			month = month + 1;
		}
		return generateDate(year,month,1);
	}
	
	/**
	 * 根据传入日期 判断该日期属于哪年哪月 （计算周期为当月25~次月24）
	 * @param date
	 * @return Map<String,Integer>
	 */
	public static Map<String,Integer> getYearAndMonthByDate(Date date) {
		Map<String,Integer> yearAndMonthMap = new HashMap<String,Integer>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DAY_OF_MONTH);
		if(day >= 25) {
			c.add(Calendar.MONTH, 1);
		}
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		yearAndMonthMap.put("year", year);
		yearAndMonthMap.put("month", month + 1);
		return yearAndMonthMap;
	}
	
	/**
	 * 获取连续的年月分传入制定年月
	 * 
	 * @param year 开始年份
	 * @param month 开始月份
	 * @param serial 连续数
	 * @param type  1 ： 加  2 ：减
	 * @return Map<String,Integer>[] 结果map类型的数组
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Integer>[] getSerialYearAndMonth(int year, int month, int serial , int type) {
		Map<String, Integer>[] map = new Map[serial]; 
		for(int i=0; i < serial; i++) {
			if(type == 1) {
				Map<String, Integer> mi = new HashMap<String,Integer>();
				mi.put("year", year);
				mi.put("month", month);
				map[i] = mi;
				if(month == 12) {
					year = year + 1;
					month = 1;
				} else {
					month = month + 1;
				}
			}
			if(type == 2) {
				Map<String, Integer> mi = new HashMap<String,Integer>();
				mi.put("year", year);
				mi.put("month", month);
				map[i] = mi;
				if(month == 1) {
					year = year - 1;
					month = 12;
				} else {
					month = month - 1;
				}
			}
		}
		return map;
	}	
	
	public static List<String> getDayList(int year, int month) {
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M");
		for (int i = 1; i <= 25; i++) {
			String dayString = sdf.format(calendar.getTime()) + "-" + i;
			list.add(dayString);
		}
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		for (int i = 26; i <= calendar.get(Calendar.DAY_OF_MONTH); i++) {
			String dayString = sdf.format(calendar.getTime()) + "-" + i;
			list.add(dayString);
		}
		return list;
	}
	
}
