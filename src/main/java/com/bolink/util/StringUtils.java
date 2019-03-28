package com.bolink.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringUtils {

	/*public static void main(String[] args) {
		String s = "{\"service_name\":\"query_price\",\"state\":1,\"errmsg\":\"success\",\"order_id\":\"wu-PAICHEb111516416590651\",\"park_id\":\"XL01\",\"price\":\"0.01\",\"duration\":1,\"total\":\"0.01\",\"free_out_time\":20,\"query_time\":1516416629,\"derate_money\":\"0.0\",\"derate_duration\":\"0.0\",\"query_order_no\":\"XL0120180120105031-742\",\"position\":\"quan-HAO%E8%BD%A6%E5%9C%BAB%E6%A0%8B%E5%95%86%E5%9C%88%E5%9C%B0%E4%B8%8B%E8%B4%9F%E4%B8%80%E5%B1%82%E4%B8%9C%E5%8C%BA%E2%80%94%E2%80%94102%E5%8C%BAA101%E8%BD%A6%E4%BD%8DHHHHHK%E5%98%9F%E5%95%A6%E5%95%A6%E2%80%94_%E9%83%BDKKKKKKKKKKKKKKGGGGGBBBBBBBBBB%E7%9C%8B%E7%9C%8B%E4%B9%A6%E7%9C%8B%E7%9C%8B\"}key=476BFE2C14D2DF26";
		String s2 = "123";
		System.out.println(StringUtils.MD5(s));
	}*/

	public static boolean isNotNull(String value) {
		if (value == null || value.equals(""))
			return false;
		return true;
	}

	public static boolean isNumber(String value) {
		if (value == null || value.equals(""))
			return false;
		try {
			Long a = Long.valueOf(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String intArrayToString(int[] values){
		if(values!=null){
			String ret = "";
			for(int i : values){
				ret +=i+",";
				
			}
			return ret.length()>0?ret.substring(0,ret.length()-1):ret;
		}
		return "";
	}
	
	public static boolean isDouble(String value) {
		if (value == null || value.equals(""))
			return false;
		try {
			Double a = new Double(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String _2null(String value) {
		if ("".equals(value))
			return null;
		return value;
	}

	public static Double getDoubleValue(String value) {
		Double double1 = null;
		try {
			double1 = Double.valueOf(value);
		} catch (Exception e) {
			double1 = 0.0d;
		}
		return double1;
	}

	public static double mul(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return bd1.multiply(bd2).doubleValue();
	}

	public static Long getLongMilliSecondFromStrDate(String strDate,
			String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		long millSeconds = new GregorianCalendar().getTimeInMillis();
		try {
			millSeconds = sdf.parse(strDate).getTime();
		} catch (Exception e) {
			// logger.error("---------get seconds error:"+e.getMessage());
		}
		return new Long(millSeconds);
	}

	public static String getPre(String value) {
		for (int i = 0; i < value.length(); i++) {
			char a = value.charAt(i);
			if (!String.valueOf(a).equals("0"))
				return value.substring(0, i);
		}
		return "";
	}

	public static Long getHour(Long start, Long end) {
		if (end != null && start != null) {
			Long hours = (end - start) / 3600;
			if ((end - start) % 60 != 0)
				hours += 1;
			return hours;
		}
		return 0L;
	}

	/*	*//**
	 * 生成 xml文件流
	 */
	/*
	 * public static String createXML(Map<String, String > info) {// 获取最大访客数XML
	 * StringBuffer xml = new StringBuffer();
	 * xml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
	 * xml.append("<content>"); for(String key : info.keySet()){
	 * xml.append("<"+key+">"+info.get(key)+"</"+key+">"); }
	 * xml.append("</content>"); return xml.toString(); }
	 */
	/**
	 * 生成 xml文件流
	 */
	public static String createXML(Map<String, Object> info) {// 获取最大访客数XML
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		xml.append("<content>");
		for (String key : info.keySet()) {
			xml.append("<" + key + ">" + info.get(key) + "</" + key + ">");
		}
		xml.append("</content>");
		return xml.toString();
	}

	/**
	 * 生成 xml文件流
	 */
	public static String createXML1(Map<String, String> info) {// 获取最大访客数XML
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		xml.append("<content>");
		for (String key : info.keySet()) {
			xml.append("<" + key + ">" + info.get(key) + "</" + key + ">");
		}
		xml.append("</content>");
		return xml.toString();
	}

	/**
	 * 生成 xml文件流
	 */
	public static String createXML(List<Map<String, Object>> info) {// 获取最大访客数XML
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		xml.append("<content>");
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				xml.append("<info>");
				for (String key : map.keySet()) {
					xml.append("<" + key + ">" + map.get(key) + "</" + key
							+ ">");
				}
				xml.append("</info>");
			}
		} else {
			xml.append("<info>");
			xml.append("没有数据");
			xml.append("</info>");
		}
		xml.append("</content>");
		return xml.toString();
	}

	/**
	 * 生成 xml文件流
	 */
	public static String createXML(List<Map<String, Object>> info, Long size) {// 获取最大访客数XML
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
		xml.append("<content count=\"" + size + "\">");
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				xml.append("<info>");
				for (String key : map.keySet()) {
					xml.append("<" + key + ">" + map.get(key) + "</" + key
							+ ">");
				}
				xml.append("</info>");
			}
		} else {
			xml.append("<info>");
			xml.append("没有数据");
			xml.append("</info>");
		}
		xml.append("</content>");
		return xml.toString();
	}

	public static String createJson(List<Map<String, Object>> info) {
		String json = "[";
		int i = 0;
		int j = 0;
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				if (i != 0)
					json += ",";
				json += "{";
				for (String key : map.keySet()) {
					if (j != 0)
						json += ",";
					Object v = map.get(key);
					if (v != null)
						v = v.toString().trim();
					// if(v instanceof Long||v instanceof Integer)
					// json +="\""+key+"\":"+map.get(key);
					// else {
					json += "\"" + key + "\":\"" + v + "\"";
					// }
					j++;
				}
				json += "}";
				i++;
				j = 0;
			}

		}
		json += "]";
		return json;
	}

	public static String createJson3(List<Map<String, Object>> info) {
		String json = "[";
		int i = 0;
		int j = 0;
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				if (i != 0)
					json += ",";
				json += "{";
				for (String key : map.keySet()) {
					if (j != 0)
						json += ",";
					Object v = map.get(key);
					if (v != null)
						v = v.toString().trim();
					if(key.equals("in_time") || key.equals("out_time"))
						json +="\""+key+"\":"+map.get(key);
					else {
						json += "\"" + key + "\":\"" + v + "\"";
					}
					j++;
				}
				json += "}";
				i++;
				j = 0;
			}

		}
		json += "]";
		return json;
	}

	public static String createJson(List<Map<String, Object>> info,
			String charset,String exculdeFiled[]) {
		String json = "[";
		int i = 0;
		int j = 0;
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				if (i != 0)
					json += ",";
				json += "{";
				for (String key : map.keySet()) {
					boolean isExculde = false;
					if(exculdeFiled!=null){
						for(String ef : exculdeFiled){
							if(ef.equals(key)){
								isExculde=true;
								break;
							}
						}
					}
					if(isExculde)
						continue;
					if (j != 0)
						json += ",";
					Object v = map.get(key);
					v=v==null?"":v;
					if (v != null)
						v = v.toString().trim();
					json += "\"" + key + "\":\""
							+ encodeUTF8(v.toString()) + "\"";
					j++;
				}
				json += "}";
				i++;
				j = 0;
			}

		}
		json += "]";
		return json;
	}

	public static String createJson2(List<Map<String, Object>> info) {
		String json = "[";
		int i = 0;
		int j = 0;
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				if (i != 0)
					json += ",";
				json += "{";
				for (String key : map.keySet()) {
					if (j != 0)
						json += ",";
					Object v = map.get(key);
					boolean startsWith = false;
					if (v != null) {
						v = v.toString().trim();
						startsWith = v.toString().startsWith("[");
					}
					// if(v instanceof Long||v instanceof Integer)
					// json +="\""+key+"\":"+map.get(key);
					// else {

					if (startsWith) {
						json += "\"" + key + "\":" + v + "";
					} else {
						json += "\"" + key + "\":\"" + v + "\"";
					}
					// }
					j++;
				}
				json += "}";
				i++;
				j = 0;
			}

		}
		json += "]";
		return json;
	}

	public static String getJson(List<Map<String, Object>> info) {
		String json = "[";
		int i = 0;
		int j = 0;
		if (info != null && info.size() > 0) {
			for (Map<String, Object> map : info) {
				if (i != 0)
					json += ",";
				json += "{";
				for (String key : map.keySet()) {
					if (j != 0)
						json += ",";
					Object v = map.get(key);
					// System.out.println(v);
					v = v == null ? "" : v;
					v = v.toString().equals("null") ? "" : v;
					if (v.toString().startsWith("["))
						json += "\"" + key + "\":" + map.get(key);
					else {
						json += "\"" + key + "\":\"" + map.get(key) + "\"";
					}
					j++;
				}
				json += "}";
				i++;
				j = 0;
			}

		}
		json += "]";
		return json;
	}

	public static String createJson(Map<String, Object> info) {
		String json = "";
		int j = 0;
		if (info != null && info.size() > 0) {
			json += "{";
			for (String key : info.keySet()) {
				// System.out.println(key);
				if (j != 0)
					json += ",";
				Object value = info.get(key);
				if (value == null)
					value = "";
				if (value instanceof Long || value instanceof Integer || value instanceof Double)
					json += "\"" + key + "\":" + value;
				else {
					json += "\"" + key + "\":\"" + value+ "\"";
				}
				j++;
			}
			json += "}";
		} else {
			json = "{}";
		}
		return json;
	}
	
	public static String createJsonUtf8(Map<String, Object> info) {
		String json = "";
		int j = 0;
		if (info != null && info.size() > 0) {
			json += "{";
			for (String key : info.keySet()) {
				// System.out.println(key);
				if (j != 0)
					json += ",";
				Object value = info.get(key);
				if (value == null)
					value = "";
				if (value instanceof Long || value instanceof Integer || value instanceof Double)
					json += "\"" + key + "\":" + value;
				else {
					json += "\"" + key + "\":\"" + encodeUTF8(value+"")+ "\"";
				}
				j++;
			}
			json += "}";
		} else {
			json = "{}";
		}
		return json;
	}

/*	public static String createTcpBackJson(Map<String, Object> info) {
		String json = "";
		int j = 0;
		if (info != null && info.size() > 0) {
			json += "{";
			for (String key : info.keySet()) {
				if (j != 0)
					json += ",";
				Object value = info.get(key);
				if (value instanceof Long 
						|| value instanceof Integer 
						|| value instanceof Double)
					json += "\"" + key + "\":" + value;
				else if(key.equals("errmsg")){
					json += "\"" +key + "\":\"" +  encodeUTF8(value+"") + "\"";
				}else {
					json += "\"" + key + "\":\"" + value + "\"";
				}
				j++;
			}
			json += "}";
		} else {
			json = "{}";
		}
		return json;
	}*/
	
	public static String createLinkString(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = params.get(key);
			if (value == null || value.toString().trim().equals("")||value.toString().trim().equals("null"))
				continue;
			prestr += key + "=" + value + "&";
		}
		if (prestr.endsWith("&"))
			prestr = prestr.substring(0, prestr.length() - 1);
		return prestr;
	}

	public static String createLinkString(String data) {
		JSONObject jsonObject = JSONObject.parseObject(data);
		List<String> keys = new ArrayList<String>(jsonObject.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			Object value = jsonObject.get(key);
			if (value == null || value.toString().trim().equals("")||value.toString().trim().equals("null"))
				continue;
			prestr += key + "=" + value + "&";
		}
		if (prestr.endsWith("&"))
			prestr = prestr.substring(0, prestr.length() - 1);
		return prestr;
	}

	public static String createLinkedJson(Map<String, Object> info) {

		String json = "";
		int j = 0;
		if (info != null && info.size() > 0) {
			json += "{";
			List<String> keys = new ArrayList<String>(info.keySet());
			Collections.sort(keys);
			String prestr = "";
			for (int i = 0; i < keys.size(); i++) {
				String key = keys.get(i);
				String value = (String) info.get(key);
				if (value == null || "".equals(value.trim()))
					continue;
				if (j != 0)
					json += ",";
				json += "\"" + key + "\":\"" + value + "\"";
				j++;
			}
			json += "}";
		} else {
			json = "{}";
		}
		return json;
	}

	/**
	 * 计算停车费
	 * 
	 * @param start
	 * @param end
	 * @param price
	 * @return
	 */
	public static String getAccount(Long start, Long end, Double price) {
		if (start != null && end != null) {
			Long duration = getHour(start, end);
			return Math.round(Double.valueOf(price + "")
					* Double.valueOf(duration))
					+ ".00";
		}
		return "";
	}

	public static String getTimeString(Long start, Long end) {
		Long hour = (end - start) / 3600;
		Long minute = ((end - start) % 3600) / 60;
		if (hour == 0 && minute == 0)
			minute = 1L;
		String result = "";
		int day = 0;
		if (hour == 0)
			result = minute + "分钟";
		else
			result = hour + "小时" + minute + "分钟";
		if (hour > 24) {
			day = hour.intValue() / 24;
			hour = hour % 24;
			result = day + "天 " + hour + "小时" + minute + "分钟";
		}
		// System.out.println(">>>>>>>>>>>>b:"+start+",e:"+end+",duration:"+result);
		return result;
	}

	public static String getTimeStringSenconds(Long start, Long end) {
		Long day = (end - start) / (24 * 60 * 60);
		Long lackDay = (end - start) % (24 * 60 * 60);
		Long hour = lackDay / (60 * 60);
		Long lackHour = lackDay % (60 * 60);
		Long minute = lackHour / 60;
		Long sencond = lackHour % 60;
		String result = "";
		if (day > 0) {
			result += day + "天";
		}
		if (hour > 0) {
			result += hour + "小时";
		}
		if (minute > 0) {
			result += minute + "分钟";
		}
		if (sencond > 0) {
			result += sencond + "秒";
		}
		return result;
	}

	public static String getDayString(Long start, Long end) {
		Long hour = (end - start) / 3600;
		String result = "";
		int day = 0;
		day = hour.intValue() / 24;
		result = day + "";
		// System.out.println(">>>>>>>>>>>>b:"+start+",e:"+end+",duration:"+result);
		return result;
	}

	public static String getTimeString(Long duartion) {
		Long hour = duartion / 3600;
		Long minute = (duartion % 3600) / 60;
		String result = "";
		int day = 0;
		/*if (hour == 0)
			result = minute + "分钟";
		else
			result = hour + "小时" + minute + "分钟";*/
		result = hour + "小时" + minute + "分钟";
		if (hour > 24) {
			day = hour.intValue() / 24;
			hour = hour % 24;
			result = day + "天 " + hour + "小时" + minute + "分钟";
		}
		return result;
	}

	public static String objArry2String(Object[] values) {
		StringBuffer rBuffer = new StringBuffer();
		if (values != null && values.length > 0) {
			for (Object o : values) {
				rBuffer.append(o + ",");
			}
		}
		return rBuffer.toString();
	}

	public static String[] list2Array(List<String> list) {
		if (list != null) {
			String[] arrays = new String[list.size()];
			for (int i = 0; i < list.size(); i++)
				arrays[i] = list.get(i);
			return arrays;
		}
		return new String[0];
	}

	public static List<String> array2List(String[] arrays) {
		if (arrays != null) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < arrays.length; i++)
				list.add(arrays[i]);
			return list;
		}
		return new ArrayList<String>();
	}

	public static List<Object> array2List(Object[] arrays) {
		if (arrays != null) {
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < arrays.length; i++)
				list.add(arrays[i]);
			return list;
		}
		return new ArrayList<Object>();
	}
	// public static void main(String[] args) {
	// String s = null;
	// try {
	// s = MD5("laoyao11111140888993");
	// } catch (Exception e) {
	// }
	// System.out.println(s);
	// }
	public static String getMondayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 1);
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		return df2.format(c.getTime());
	}

	public static String getFistdayOfMonth() {
		Date nowTime = new Date(System.currentTimeMillis());// 取系统时间
		try {
			SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-01");
			return sformat.format(nowTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String getLastFistdayOfMonth() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		c.add(Calendar.MONTH, -1);
		Date nowTime = new Date(c.getTimeInMillis());// 取系统时间
		try {
			SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-01");
			return sformat.format(nowTime);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算两地的距离，返回单位：公里
	 * 
	 * @param _Longitude1
	 * @param _Latidute1
	 * @param _Longitude2
	 * @param _Latidute2
	 * @return
	 */
	public static double distanceByLnglat(double _Longitude1,
			double _Latidute1, double _Longitude2, double _Latidute2) {
		// 0.09446
		double radLat1 = _Latidute1 * Math.PI / 180;
		double radLat2 = _Latidute2 * Math.PI / 180;
		double a = radLat1 - radLat2;
		double b = _Longitude1 * Math.PI / 180 - _Longitude2 * Math.PI / 180;
		double s = 2 * Math.atan(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		s = Math.round(s * 10000) / 10000;
		s = (s / 1000) * 0.621371192;
		// int result = (int) Math.ceil(s);
		// System.out.println(_Longitude1+","+_Latidute1+","+_Longitude2+","+_Latidute2);
		// System.out.println(s);
		return s;
	}

	/**
	 * 计算地球上任意两点(经纬度)距离 *
	 * 
	 * @param long1
	 *            * 第一点经度
	 * @param lat1
	 *            * 第一点纬度
	 * @param long2
	 *            * 第二点经度
	 * @param lat2
	 *            * 第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double distance(double long1, double lat1, double long2,
			double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2
				* R
				* Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
						* Math.cos(lat2) * sb2 * sb2));
		return d;
	}

	/**
	 * 生成MD5
	 */
	public static String MD5(String s) {
		//System.err.println(s);
		try {
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
			messagedigest.reset();
			byte abyte0[] = messagedigest.digest(s.getBytes("utf-8"));
			return byteToString(abyte0);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static String byteToString(byte abyte0[]) {
		int i = abyte0.length;
		char ac[] = new char[i * 2];
		int j = 0;
		for (int k = 0; k < i; k++) {
			byte byte0 = abyte0[k];
			ac[j++] = hexDigits[byte0 >>> 4 & 0xf];
			ac[j++] = hexDigits[byte0 & 0xf];
		}

		return new String(ac);
	}

	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String encodingFileName(String fileName) {
		String returnFileName = "";
		try {
			returnFileName = new String(fileName.getBytes("gb2312"),
					"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return returnFileName;
	}

	public static String replaceEnter(String str) {
		Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
		Matcher m = CRLF.matcher(str);
		if (m.find()) {
			str = m.replaceAll("<br>");
		}
		return str;
	}

	/**
	 * 验证车牌号:注意将小写转为大写再做匹配
	 * 
	 * @param plate
	 * @return
	 */
	public static boolean checkPlate(String plate) {
		if (plate == null || "".equals(plate)) {
			return false;
		}
		plate = plate.toUpperCase();
		String province = String.valueOf(plate.charAt(0));
		String[] provinces = new String[] { "京", "沪", "浙", "苏", "粤", "鲁", "晋",
				"冀", "豫", "川", "渝", "辽", "吉", "黑", "皖", "鄂", "湘", "赣", "闽",
				"陕", "甘", "宁", "蒙", "津", "贵", "云", "桂", "琼", "青", "新", "藏",
				"港", "澳", "使", "军", "空", "海", "北", "沈", "兰", "济", "南", "广",
				"成", "WJ", "警", "消", "边", "水", "电", "林", "通" };
		for (int i = 0; i < provinces.length; i++) {
			if (province.equals(provinces[i])) {
				break;
			}
			if (i == provinces.length - 1) {
				return false;
			}
		}
		String check = "^[A-Z]{1}[A-Z_0-9]{5}$";
		if (province.equals("使")) {
			check = "^[A-Z_0-9]{6}$";
		}
		plate = plate.substring(1);
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(plate);
		return m.matches();
	}

	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile) {
		Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	static double generateRandomNumber() {
		// generate random number based on normal distribution
		double r = new Random().nextDouble();
		return new Random().nextDouble() * r;
	}

	static Double sum(Double[] results) {
		double sum = 0d;
		for (double d : results) {
			sum += d;
		}
		return sum;
	}

	public static List<Integer> getBonusIngteger(Integer total, int bum, int max) {
		// 8,3 18,8
		// 拿到四个随机数，可以做个池什么的每次取四个来提升效率
		Double[] results = new Double[bum];
		for (int i = 0; i < bum; i++) {
			results[i] = generateRandomNumber();
		}
		// //排序
		// r.sort(new Comparator<Double>() {
		// @Override
		// public int compare(Double o1, Double o2) {
		// return o1 < o2 ? -1 : 1;
		// }
		// });
		// 用这四个随机数来打断一个数，来取得五份分解之后的数
		List<Integer> out = new ArrayList<Integer>();
		double ratio = total / sum(results);
		int _total = 0;
		for (int i = 0; i < bum; i++) {
			int c = (int) (results[i] * ratio);
			if (c == 0)
				c = 1;
			_total += c;
			out.add(c);
		}
		if (_total < total) {
			out.add(bum - 1, out.get(bum - 1) + (total - _total));
			out.remove(bum);
		} else if (_total > total) {
			System.out.println(out);
			for (int i = 0; i < out.size(); i++) {
				if (out.get(i) > (_total - total + 1)) {
					Integer old = out.get(i);
					out.remove(i);
					out.add(i, old - (_total - total));
					break;
				}
			}
		}

		Integer lastTotal = 0;
		for (int i = 0; i < out.size(); i++) {
			Integer in = out.get(i);
			if (in > max) {
				out.remove(i);
				out.add(i, max);
				lastTotal += in - max;
			}
		}
		// System.out.println(out);
		// System.out.println(lastTotal);
		Integer stotal = 0;
		if (lastTotal > 0) {
			for (int i = 0; i < out.size(); i++) {
				int old = out.get(i);
				if (old < max && lastTotal > 0) {
					out.remove(i);
					if (lastTotal > 1) {
						if ((old + lastTotal) < max) {
							out.add(i, lastTotal + old);
							lastTotal = 0;
						} else {
							out.add(i, max);
							lastTotal = lastTotal - (max - old);
						}
					} else {
						out.add(i, old + 1);
						lastTotal = lastTotal - 1;
					}
				}
				if (lastTotal == 0)
					break;
			}
		}
		for (Integer integer : out) {
			stotal += integer;
		}
		Collections.sort(out);
		System.out.println(out + ":" + stotal);
		return out;
	}

	public static String getWeek(int week) {
		switch (week) {
		case 2:
			return "一";
		case 3:
			return "二";
		case 4:
			return "三";
		case 5:
			return "四";
		case 6:
			return "五";
		case 7:
			return "六";
		case 1:
			return "日";
		}
		return "";
	}

	public static String getParkUserPass() {
		String[] passes = new String[] { "333666", "999666", "111222",
				"333444", "555666", "454545", "858585", "989898", "777333",
				"222444", "999111", "000222", "555000", "525252", "676767",
				"919191", "020202", "353535", "646464", "828282", "111444",
				"666555", "222555", "666333", "333777", "999888", "888555",
				"666444", "111999", "222555", "000222", "135135", "124124",
				"258258", "147147", "369369", "963963", "321321", "654654",
				"987987", "120120", "320320", "210210", "258258", "595959",
				"535353", "575757", "545454", "151515", "525252", "626262",
				"202020", "555222", "626262", "303030", "989898", "969696",
				"939393", "929292", "949494", "979797", "848484", "828282",
				"838383", "868686" };
		int rang = new Random().nextInt(passes.length);
		return passes[rang];
	}

	/**
	 * 解码Ajax urf-8编码后的url形式中文参数 返回UTF-8结果
	 * 
	 */
	public static String decodeUTF8(String someStr) {
		String newStr = null;
		if (someStr != null && someStr.equals(""))
			return "";
		if (someStr != null && !someStr.equals("")) {
			try {
				newStr = URLDecoder.decode(someStr, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return newStr;
	}

	/**
	 * 编码Ajax urf-8编码后的url形式中文参数 返回UTF-8结果
	 *
	 */
	public static String encodeUTF8(String someStr) {
		String newStr = null;
		if (someStr != null && someStr.equals(""))
			return "";
		if (someStr != null && !someStr.equals("")) {
			try {
				newStr = URLEncoder.encode(someStr, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return newStr;
	}

	public static void ajaxOutput(HttpServletResponse response,
			String outputString)  {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET");
			PrintWriter printWriter = response.getWriter();
			printWriter.write(outputString);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 多层代理获取客户端真实IP
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && !"".equals(ip)) {
			if (ip.indexOf(",") > 0) {
				ip = ip.split(",")[0];
			}
		}
		// System.out.println("Redirecting com_ip 01 ==> " + ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			// System.out.println("Redirecting com_ip 02 ==> " + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			// System.out.println("Redirecting com_ip 03 ==> " + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			// System.out.println("Redirecting com_ip 04 ==> " + ip);
		}
		return ip;
	}
	/**
	 * 判断字符数组是否为空
	 */
	public static boolean areNotEmpty(String... values) {
		boolean result = true;
		if (values == null || values.length == 0) {
			result = false;
		} else {
			for (String value : values) {
				result &= !isNotNull(value);
			}
		}
		return result;
	}
	
	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkStrings(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
	

	public static String getTimeString(Integer minute) {
		Integer hour =  minute/ 60;
		if (hour == 0 && minute == 0)
			minute = 0;
		String result = "";
		int day = 0;
		/*if (hour == 0)
			result = minute + "分钟";
		else
			result = hour + "小时" + minute%60 + "分钟";*/
		result = hour + "小时" + minute%60 + "分钟";
		if (hour > 24) {
			day = hour / 24;
			hour = hour % 24;
			result = day + "天 " + hour + "小时" + minute%60 + "分钟";
		}
		// System.out.println(">>>>>>>>>>>>b:"+start+",e:"+end+",duration:"+result);
		return result;
	}
	
	//驼峰转下划线
	public static String camelCaseToUnderscore(String line){
		 if(line==null||"".equals(line)){
	            return "";
	        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
	}
	/**
     * 下划线转驼峰法
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }



	/**
	 * http提交参数转为Map
	 *
	 * @param params
	 * @return Map<String, String>
	 */
	public static Map<String, String> stringToMap(String params) {
		Map<String, String> map = new HashMap<String, String>();
		if (params != null) {
			String param[] = params.split("&");
			for (int i = 0; i < param.length; i++) {
				String pString = param[i];
				String p[] = pString.split("=");
				if (p != null && p.length == 2) {
					String key = p[0];//参数名转数据库字段名
					if(key!=null&&!"".equals(key)){
						map.put(key.toLowerCase(),pString.substring(key.length()+1));
					}
				}
			}
		}
		return map;
	}
	public static String createXML(Map<String, Object> info,String uKey) {//
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		xml.append("<MessageSuit version=\"v1.0.0\">");
		xml.append("<Message>");
		xml.append("<Plain>");
		StringBuffer signData = new StringBuffer();
		signData.append("<Plain>");
		for (String key : info.keySet()) {
			xml.append("<" + key + ">" + info.get(key) + "</" + key + ">");
			signData.append("<" + key + ">" + info.get(key) + "</" + key + ">");
		}
		xml.append("</Plain>");
		signData.append("</Plain>");
		String sign="";
		try {
			Base64.encodeBase64String(signData.toString().getBytes("GBK"));
			sign = Base64.encodeBase64URLSafeString(DigestUtils.sha((signData.toString()+uKey).getBytes("GBK")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//HSA1 加密,bease64转码
		xml.append("<Signature>");
		xml.append("<SignatureValue>");
		xml.append(sign);
		xml.append("</SignatureValue>");
		xml.append("</Signature>");
		xml.append("</Message>");
		xml.append("</MessageSuit>");
		return xml.toString();
	}

	public static String getDataFromXML(String xmlData,String pElementNam,String elementName,String cElementName) {//获取无感支付银联返回数据
		String elementValue = "";
		try {
			Document document = document = DocumentHelper.parseText(xmlData);
			Element root = document.getRootElement();// 获取根元素
			Element plain = root.element("Message").element(pElementNam);//签名数据域
			if(cElementName == null){
				elementValue = elementValue = plain.elementText(elementName);//
			}else{
				elementValue = plain.element(elementName).elementText(cElementName);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return elementValue;
	}
	public static String getDataFromXML(String xmlData,String pElementNam,String elementName) {//获取无感支付银联返回数据
		String elementValue = "";
		try {
			Document document = document = DocumentHelper.parseText(xmlData);
			Element root = document.getRootElement();// 获取根元素
			Element plain = root.element("Message").element(pElementNam);//签名数据域
			elementValue = plain.elementText(elementName);//
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return elementValue;
	}
	public static List<String> getCarsFromXML(String xmlData,String pElementNam,String elementName) {//获取无感支付银联返回数据中的车牌号
		List<String> elementValues = new ArrayList<String>();
		try {
			Document document = document = DocumentHelper.parseText(xmlData);
			Element root = document.getRootElement();// 获取根元素
			Element plain = root.element("Message").element(pElementNam);//签名数据域
			List<Element> elements =  plain.element(elementName).elements();
			for(Element e : elements){
				elementValues.add(e.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return elementValues;
	}
}
