package com.bolink.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class PostMultiData {
    public static void test(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String uri = "http://127.0.0.1:8080/encoding/servlet/RevFileServlet";
           // uri="http://120.24.7.159:8099/logview/log/upload";
            uri="http://127.0.0.1:8089/log/upload";
            HttpPost httppost = new HttpPost(uri);
            httppost.setHeader("Content-Type","multipart/form-data;charset=UTF-8");
            File file1 = new File("E:\\test/1/2.txt");
            String path="E:\\BaiduYunDownload/upp.log";
            File file = new File(path);
            FileBody bin = new FileBody(file);
            StringBody comment = new StringBody("你好ooo", ContentType.TEXT_PLAIN);
            StringBody comment1 = new StringBody("1234", ContentType.TEXT_PLAIN);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("file", bin)
                    .addPart("union_id", comment)
                    .addPart("park_id", comment1)
                    .addPart("local_id", comment)
                    .addPart("log_time", comment1)
                    .build();


            httppost.setEntity(reqEntity);
            System.out.println("executing request " + httppost.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
