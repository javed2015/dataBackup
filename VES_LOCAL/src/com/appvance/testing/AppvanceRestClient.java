/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appvance.testing;

import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author Luis
 */
public class AppvanceRestClient {

    private String baseUrl;
    private DefaultHttpClient httpclient;
    private String file;
    private String output;
    private int currentPos;
    private String config;
    private long exeId;
    private String originalURL;
    private int success;
    private int failures;

    public AppvanceRestClient(String theUrl) {
        originalURL = theUrl;
        baseUrl = "http://" + theUrl + "/AppvanceServer/rest/";
        httpclient = new DefaultHttpClient();
        output = "";
        currentPos = 0;
    }


    public String getBody(HttpEntity entity1) throws Exception {
        InputStream is = entity1.getContent();
        StringBuilder sb = new StringBuilder();
        byte[] data = new byte[1000];
        int read;
        while ((read = is.read(data)) >= 0) {
            sb.append(new String(data, 0, read));
        }
        is.close();
        EntityUtils.consume(entity1);
        return sb.toString();
    }

    //http://localhost:8080/TestMakerServer/rest/execution/startExecution?file=D%3A%2FNetworkTest%2Fhtmlunit2.7.scenario&_=1372899787303
    public void startScenario(String theFile) throws Exception {
        file = theFile;
        output = "";
        currentPos = 0;
        HttpGet httpGet = new HttpGet(baseUrl + "execution/startExecution?file=" + file);
        HttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println("Executing " + file);
            System.out.println(getBody(response1.getEntity()));
        } finally {
            httpGet.releaseConnection();
        }
    }

    public boolean logIn(String username, String password) throws Exception {
        HttpGet httpGet = new HttpGet(baseUrl + "admin/loggin?username=" + username + "&password=" + password);
        HttpResponse response1 = httpclient.execute(httpGet);
        try {
        	//String jsonString = EntityUtils.toString(getBody(response1.getEntity()));
            JSONObject login = new JSONObject(getBody(response1.getEntity()));
            return login.getBoolean("logged");
        } finally {
            httpGet.releaseConnection();
        }
    }
    

    //http://localhost:8080/TestMakerServer/rest/execution/getStatus?file=D%3A%2FNetworkTest%2Fhtmlunit2.7.scenario&realtimeTXCount=5&_=1372900754967
    public boolean isRunning() throws Exception {
        HttpGet httpGet = new HttpGet(baseUrl + "execution/getStatus?realtimeTXCount=0&file=" + file);
        HttpResponse response1 = httpclient.execute(httpGet);
        try {
            JSONObject obj = new JSONObject(getBody(response1.getEntity()));
            output = obj.getString("output");
            try {
                config = obj.getString("config");
            } catch (Exception e) {
            }
            try {
                exeId = obj.getLong("exeId");
            } catch (Exception e) {
            }
            try {
                success = obj.getInt("success");
            } catch (Exception e) {
            }
            try {
                failures = obj.getInt("failures");
            } catch (Exception e) {
            }
            return !obj.getBoolean("complete");

            // do something useful with the response body
            // and ensure it is fully consumed
        } finally {
            httpGet.releaseConnection();
        }
    }

    public String getReportURL(){
        return "http://" +originalURL+"/Appvance/analyze.html?config="+config+"&exeId="+exeId;
    }

    public String getNextOutput() {
        if (currentPos >= output.length()) {
            return "";
        }
        String s = output.substring(currentPos);
        currentPos = output.length();
        return s;
    }

    public int getSuccess(){
        return success;
    }

     public int getFailures(){
        return failures;
    }

}
