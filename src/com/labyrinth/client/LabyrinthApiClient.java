package com.labyrinth.client;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author spiralgyre
 *
 */
public class LabyrinthApiClient
{
	protected HttpClient request = HttpClients.createDefault();
	protected CloseableHttpResponse response = null;
	protected String responseString = "{\"message\": \"There was a problem with the response\"}";
	
	protected String baseUrl = "";
	protected String username = "";
	protected String password = "";
	
	protected LabyrinthApiClient(String username, String password)
	{
		baseUrl = "http://localhost:8080/TheLabyrinth";
		this.username = username;
		this.password = password;
	}
	
	protected LabyrinthApiClient(String url, String username, String password)
	{
		baseUrl = url;
		this.username = username;
		this.password = password;
	}
	
	protected boolean sendRequest(HttpRequestBase req)
	{
		boolean successful = false;
		
		try
		{
			response = (CloseableHttpResponse) request.execute(req);
			successful = true;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.out.println("There was an error getting the response: " + ioe.getMessage());
		}
		
		return successful;
	}
	
	protected String parseResponse()
	{
		try
		{
			responseString = EntityUtils.toString(response.getEntity());
		}
		catch(ParseException | IOException pe_ioe)
		{
			pe_ioe.printStackTrace();
			System.out.println("There was an error parsing the response: " + pe_ioe.getMessage());
		}
		return responseString;
	}

	private String encrypt64(String username, String password)
	{
		// http://stackoverflow.com/a/10319155
		byte[] strAsBytes = StringUtils.getBytesUtf8(username + ":" + password);
		return Base64.encodeBase64String(strAsBytes);
	}

	protected HttpGet makeGetMethod(String endpoint)
	{
		HttpGet get = new HttpGet(baseUrl + "/api/" + endpoint);
		get.setHeader("authorization", "Basic " + encrypt64(username, password));

		return get;
	}

	protected HttpPost makePostMethod(String endpoint)
	{
		HttpPost post = new HttpPost(baseUrl + "/api/" + endpoint);
		post.setHeader("authorization", "Basic " + encrypt64(username, password));

		return post;
	}

	protected HttpDelete makeDeleteMethod(String endpoint)
	{
		HttpDelete delete = new HttpDelete(baseUrl + "/api/" + endpoint);
		delete.setHeader("authorization", "Basic " + encrypt64(username, password));
		
		return delete;
	}
}
