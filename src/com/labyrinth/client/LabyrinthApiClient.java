package com.labyrinth.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
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
	
	public String makeArbitraryAPICall(String endpoint, String method)
	{
		HttpRequestBase request = null;
		
		switch(method.toUpperCase())
		{
		case "GET":
			request = new HttpGet(baseUrl + "/api/" + endpoint);
			break;
		case "POST":
			request = new HttpPost(baseUrl + "/api/" + endpoint);
			break;
		case "PUT":
			request = new HttpPut(baseUrl + "/api/" + endpoint);
			break;
		case "DELETE":
			request = new HttpDelete(baseUrl + "/api/" + endpoint);
			break;
		case "OPTIONS":
			request = new HttpOptions(baseUrl + "/api/" + endpoint);
			break;
		case "HEAD":
			request = new HttpHead(baseUrl + "/api/" + endpoint);
			break;
		default:
			System.out.println("The " + method + " method is not supported");
			return null;
		}
		request.setHeader("authorization", "Basic " + encrypt64(username, password));
		
		if(sendRequest(request))
		{
			return parseResponse();
		}
		return null;
		
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
	
	protected String getResponse(HttpRequestBase req)
	{
		if(sendRequest(req))
		{
			return parseResponse();
		}
		return null;
	}

	protected String getResponse(HttpEntityEnclosingRequestBase post, String rawData)
	{
		StringEntity data = null;
		
		try
		{
			data = new StringEntity(rawData);
		}
		catch(UnsupportedEncodingException uee)
		{
			uee.printStackTrace();
		}

		(post).setEntity(data);
		
		if(sendRequest(post))
		{
			return parseResponse();
		}
		return null;
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

	protected HttpPut makePutMethod(String endpoint)
	{
		HttpPut put = new HttpPut(baseUrl + "/api/" + endpoint);
		put.setHeader("authorization", "Basic " + encrypt64(username, password));

		return put;
	}

	protected HttpDelete makeDeleteMethod(String endpoint)
	{
		HttpDelete delete = new HttpDelete(baseUrl + "/api/" + endpoint);
		delete.setHeader("authorization", "Basic " + encrypt64(username, password));
		
		return delete;
	}

	protected HttpOptions makeOptionsMethod(String endpoint)
	{
		HttpOptions options = new HttpOptions(baseUrl + "/api/" + endpoint);
		options.setHeader("authorization", "Basic " + encrypt64(username, password));
		
		return options;
	}
}
