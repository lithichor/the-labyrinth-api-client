package com.labyrinth.client;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class UserClient extends LabyrinthApiClient
{
	/**
	 * A more general constructor for arbitrary server urls
	 * 
	 * @param url - the url for the server
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public UserClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public UserClient(String username, String password)
	{
		super(username, password);
	}

	/**
	 * Get the data for the authenticated user
	 * @return The response from the server
	 */
	public String getUser()
	{
		HttpGet get = makeGetMethod("user");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	/**
	 * Create a new user from the JSON data
	 * @param rawData - JSON-formatted String
	 * @return The response from the server
	 */
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
	
	/**
	 * Update the user with JSON data
	 * @param rawData - JSON formatted string
	 * @return The response from the server
	 */
	public String updateUser(String rawData)
	{
		HttpPut put = makePutMethod("user");
		StringEntity data = null;
		
		try
		{
			data = new StringEntity(rawData);
		}
		catch(UnsupportedEncodingException uee)
		{
			uee.printStackTrace();
		}
		
		put.setEntity(data);
		
		if(sendRequest(put))
		{
			return parseResponse();
		}
		
		return null;
	}
	
	/**
	 * Delete the user
	 * @return The response from the server
	 */
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
