package com.labyrinth.client;

import org.apache.http.client.methods.HttpGet;

public class GamesClient extends LabyrinthApiClient
{
	public GamesClient(String username, String password)
	{
		super(username, password);
	}
	
	public GamesClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	public String getAllGames()
	{
		HttpGet get = makeGetMethod("games");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	public String getOneGame(String id)
	{
		HttpGet get = makeGetMethod("games/" + id);
		if(sendRequest(get))
		{
			return responseString;
		}
		return null;
	}

	public String getOneGame(Integer id)
	{
		HttpGet get = makeGetMethod("games/" + id);
		if(sendRequest(get))
		{
			return responseString;
		}
		return null;
	}
}
