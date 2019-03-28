package com.bolink.util.baidu;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class HttpProxy {

	public static String doBodyPost(String url,String content){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		String result = "";
		try {
			httpClient.setConnectionTimeout(1000*20);
			post.addRequestHeader("Content-Type", "application/json;charset=utf-8");
			RequestEntity requestEntity = new StringRequestEntity(content);
			post.setRequestEntity(requestEntity);
			state = httpClient.executeMethod(post);
			if(state==HttpStatus.SC_OK){
				result= post.getResponseBodyAsString();
			}else {
				result = state+"";
			}
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}

	public  byte[] doBodyPostGetBtyes(String url,String content){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		byte[] result  =null;
		try {
			httpClient.setConnectionTimeout(1000*20);
			post.addRequestHeader("Content-Type", "application/json;charset=utf-8");
			RequestEntity requestEntity = new StringRequestEntity(content);
			post.setRequestEntity(requestEntity);
			state = httpClient.executeMethod(post);
			if(state==HttpStatus.SC_OK){
				result = post.getResponseBody();
			}else {
				result = new byte[0];
			}
			post.releaseConnection();
		} catch (Exception e) {
			result = new byte[0];
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}
	/**
	 * GET 请求，返回字符
	 * @param url
	 * @return
	 */
	public  String doGet(String url){
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			httpClient.setConnectionTimeout(1000*10);
			httpClient.executeMethod(method);
			if(method.getStatusCode()==200){
				String result = method.getResponseBodyAsString();
				return result;
			}else {
				System.err.println(method.getResponseBodyAsString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(method!=null)
				method.releaseConnection();
		}
		return null;
	}
	/**
	 * GET 请求，返回字符
	 * @param url
	 * @return
	 */
	public  byte[]  doBtyeGet(String url){
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			httpClient.setConnectionTimeout(1000*10);
			httpClient.executeMethod(method);
			System.out.println("http status:"+method.getStatusCode());
			if(method.getStatusCode()==200){
				return method.getResponseBody();
			}else {
				System.err.println(method.getResponseBodyAsString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(method!=null)
				method.releaseConnection();
		}
		return null;
	}
	/**
	 * POST 请求，返回字符
	 * @param url
	 * @param params
	 * @return
	 */
	public  String doPost(String url,Map<String,String> params){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		String result = "";
		try {
			
			NameValuePair[] pairs = new NameValuePair[params.size()];
			int i = 0;
			for(String key : params.keySet()){
				pairs[i]=new NameValuePair(key,params.get(key));
				i++;
			}
			post.setRequestBody( pairs);
		    httpClient.setConnectionTimeout(1000*20);
		    state = httpClient.executeMethod(post);
		  //  System.out.println(state);
			if(state==HttpStatus.SC_OK){
				result= post.getResponseBodyAsString();
			}else {
				result = state+"";
			}
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}

	public String doTeldPost(String url, String content){
		return doTeldPost(url,"",content);
	}

	public String doTeldPost(String url,String hearder,String content){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		String result = "";
		try {
			httpClient.setTimeout(1000*5);
			httpClient.setConnectionTimeout(1000*5);
		    httpClient.getState().setCredentials(new AuthScope(AuthScope.ANY), new UsernamePasswordCredentials("Bearer", hearder));
		    httpClient.getParams().setAuthenticationPreemptive(true);
		    post.addRequestHeader("Content-Type", "application/json;charset=utf-8");
		    RequestEntity requestEntity = new StringRequestEntity(new String(content.getBytes("utf-8")));
		    post.setRequestEntity(requestEntity);
		    state = httpClient.executeMethod(post);
			if(state==HttpStatus.SC_OK){
				BufferedReader br = new BufferedReader(new InputStreamReader(
						post.getResponseBodyAsStream()));
	            StringBuffer stringBuffer = new StringBuffer();
	            String str = "";
	            while ((str = br.readLine()) != null) {
	                  stringBuffer.append(str);
	            }
	            result= stringBuffer.toString();
			}else {
				System.err.println(post.getResponseBodyAsString());
				result = state+"";
			}
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 *
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		CloseableHttpClient httpClient = getHttpClient();
		String result = "";
		try {
			HttpPost post = new HttpPost(url);
			//创建参数列表
			List<org.apache.http.NameValuePair> list = new ArrayList<org.apache.http.NameValuePair>();
			list.add(new BasicNameValuePair("PACKET", param));
			//url格式编码
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"GBK");
			uefEntity.setContentEncoding("GBK");
			uefEntity.setContentType("application/x-www-form-urlencoded;charset=gbk");
			post.setEntity(uefEntity);
			System.out.println("POST 请求...." + EntityUtils.toString(uefEntity));
			//执行请求
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			try{
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity){
					result = EntityUtils.toString(entity,"GBK");
				}
			} finally{
				httpResponse.close();
			}

		} catch( UnsupportedEncodingException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				closeHttpClient(httpClient);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	private static CloseableHttpClient getHttpClient(){
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setSocketTimeout(3000)
				.setConnectTimeout(3000)
				.setConnectionRequestTimeout(3000)
				.setStaleConnectionCheckEnabled(true)
				.build();
		return HttpClients.custom()
				.setDefaultRequestConfig(defaultRequestConfig)
				.build();
	}

	private static void closeHttpClient(CloseableHttpClient client) throws IOException{
		if (client != null){
			client.close();
		}
	}
	
}
