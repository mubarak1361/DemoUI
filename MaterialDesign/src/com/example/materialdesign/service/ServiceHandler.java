package com.example.materialdesign.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;
 
public class ServiceHandler {
 
    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    public final static int LOGIN = 0;
    private static DefaultHttpClient httpClient;
    private CookieStore cookieStore;
    private static ServiceHandler serviceHandler;

 
    public ServiceHandler() {
        
    }
    
    public static ServiceHandler Instance(){
		if(serviceHandler==null){
			serviceHandler = new ServiceHandler();
			 httpClient = new DefaultHttpClient();
			
		}
		return serviceHandler;
	}
 

    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method,3, null);
    }
    
    public String makeServiceCall(String url, int method,List<NameValuePair> params) {
        return this.makeServiceCall(url, method,3, params);
    }
 

    public String makeServiceCall(String url, int method,int type,
            List<NameValuePair> params) {
        try {
            // http client
                 
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
             
            // Checking http request method type
            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);
                // adding post params
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
                }
 
                httpResponse = httpClient.execute(httpPost);
 
            } else if (method == GET) {
                // appending params to url
                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                
                HttpGet httpGet = new HttpGet(url);

                if(type == LOGIN) {            	
                	
                	httpResponse = httpClient.execute(httpGet);
                	
                	cookieStore = new BasicCookieStore();
                	cookieStore = httpClient.getCookieStore();
                	
                	List<Cookie> cookies =  httpClient.getCookieStore().getCookies();
                	for (Cookie cookie : cookies) {
                		
					Log.d("Name", cookie.getName());
					Log.d("Value", cookie.getValue());
					Log.d("Expires",""+ cookie.getExpiryDate());
					 
                	}
                }          
                else {
                	httpClient.setCookieStore(cookieStore);
                	 httpResponse = httpClient.execute(httpGet); 
                	 
                }
 
            }
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return response;
 
    }
}