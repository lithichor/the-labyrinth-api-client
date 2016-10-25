package com.labyrinth.client;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class UserClient extends LabyrinthApiClient
{

	public UserClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	public UserClient(String username, String password)
	{
		super(username, password);
	}

	public String getUser()
	{
		HttpGet get = makeGetMethod("user");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	public String createUser(String rawData)
	{
		HttpPost post = makePostMethod("user");
		StringEntity data = null;
		
		try
		{
			data = new StringEntity(rawData);
		}
		catch(UnsupportedEncodingException uee)
		{
			uee.printStackTrace();
		}
		
		post.setEntity(data);
		
		if(sendRequest(post))
		{
			return parseResponse();
		}
		
		return null;
	}
	
	public String deleteUser()
	{
		HttpDelete delete = makeDeleteMethod("user");
		if(sendRequest(delete))
		{
			return parseResponse();
		}
		return null;
	}
}
