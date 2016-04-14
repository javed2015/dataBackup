package com.votsh.build;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.json.JSONException;

public class NetClientPost {
	
	
	public String buildStatus(String jobName,String jobType){
		String status ="";
		NetClientPost client = new NetClientPost();
	try {
		while(client.isBuildRun(jobName).equals("true")) {
			Thread.sleep(1000);
		}
		if(client.isBuildRun(jobName).equals("false")) {
			Thread.sleep(1000);
			if(jobName.equalsIgnoreCase(jobType)){
			client.buildJob(jobName);
			}
		}	
		status = client.status(jobName, "false");
	} catch (MalformedURLException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return status;
}

	
	// 404 Exception handling for XML document ***** See isBuildRun() 	
	public void domRead(String jobName) throws MalformedURLException, InterruptedException {
		NetClientPost client = new NetClientPost();
		client.isBuildRun(jobName);
	}
	
	public String buildJob(String jobName, String repoUser, String repoPass,String buildRepoPath,String userId,String jobType ) throws JSONException, InterruptedException
    {
		String content = "Building Job 1";
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://52.76.12.9:8082/job/"+jobType+"/buildWithParameters");
		content = "Building Job 2";
		
		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("jobname", jobName));
		params.add(new BasicNameValuePair("username", repoUser));
		params.add(new BasicNameValuePair("password", repoPass));
		params.add(new BasicNameValuePair("repoPath", buildRepoPath));
		params.add(new BasicNameValuePair("USERID", userId));
		try {
			httpPost.addHeader("content-type", "application/x-www-form-urlencoded");
		    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}
		
		 // Execute the HTTP Request
		try {
		    HttpResponse response = httpClient.execute(httpPost);
		} catch (ClientProtocolException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
        return content;
    }
	
	
	public void buildJob(String jobName) throws InterruptedException {
	try {
		 System.out.println("in buildJob param 1 in top");
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet("http://52.76.12.9:8082/job/" + jobName
					+ "/build");
			client.execute(get);
			 System.out.println("in buildJob param 1");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String status(String jobName, String status) throws NumberFormatException, InterruptedException, MalformedURLException, DocumentException {
		URL url;
		System.out.println("status method called");
		
			url = new URL("http://52.76.12.9:8082/job/"+jobName+"/lastBuild/api/xml");

			Document dom = new SAXReader().read(url);
			System.out.println("estimatedDuration"+dom.getRootElement().elementText(
					"duration"));
			String wai = dom.getRootElement().elementText("duration");
			System.out.println("number"+dom.getRootElement().elementText("number"));
			System.out.println("id===="+dom.getRootElement().elementText("id"));
			System.out.println("result"+dom.getRootElement().elementText("result"));
			if(status.equals("true"))
				return(wai);
			else
				return(dom.getRootElement().elementText("result"));
	}
	
	
	public String isBuildRun(String jobName) throws MalformedURLException, InterruptedException {
		URL url;
		String status = "";
		System.out.println("jobName in isBuildRun "+jobName);
		url = new URL("http://52.76.12.9:8082/job/"+jobName+"/lastBuild/api/xml?depth=1&xpath=*/building");

		Document dom ;
		try {
			dom = new SAXReader().read(url);
			status = dom.getStringValue();
			System.out.println(status + "------try block");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			NetClientPost client = new NetClientPost();
			System.out.println("document exception");
			Thread.sleep(10000);
			client.domRead(jobName);
			status =  "true";
		}
		return status;
	}
	
	
}
