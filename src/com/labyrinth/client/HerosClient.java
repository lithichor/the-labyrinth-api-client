package com.labyrinth.client;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class HerosClient extends LabyrinthApiClient
{
	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public HerosClient(String username, String password)
	{
		super(username, password);
	}
	/**
	 * A more general constructor for arbitrary server urls
	 * 
	 * @param url - the url for the server
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public HerosClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	/**
	 * Returns the most recent Hero. This is the Hero associated with
	 * the most recent Game for the authenticated user.
	 * @param heroId
	 * @return the response from the GET method in String form
	 */
	public String getCurrentHero()
	{
		HttpGet get = makeGetMethod("heros");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	public String updateCurrentHero(String rawData)
	{
		HttpPut put = makePutMethod("heros");
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
}
