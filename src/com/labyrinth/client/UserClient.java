package com.labyrinth.client;

import org.apache.http.client.methods.HttpGet;

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
}
