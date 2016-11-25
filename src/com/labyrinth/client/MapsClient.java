package com.labyrinth.client;

import org.apache.http.client.methods.HttpGet;

public class MapsClient extends LabyrinthApiClient
{

	public MapsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	public MapsClient(String username, String password)
	{
		super(username, password);
	}

	public String getCurrentGameMaps()
	{
		HttpGet get = makeGetMethod("maps");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	public String getMapsForGame(String gameId)
	{
		HttpGet get = makeGetMethod("maps?gameId=" + gameId);
		
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
}
