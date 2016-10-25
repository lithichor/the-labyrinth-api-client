package com.labyrinth.client;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

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
			return parseResponse();
		}
		return null;
	}

	public String getOneGame(Integer id)
	{
		HttpGet get = makeGetMethod("games/" + id);
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	public String getLastGame()
	{
		HttpGet get = makeGetMethod("games/last");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}

	public String createGame()
	{
		HttpPost post = makePostMethod("games");
		if(sendRequest(post))
		{
			return parseResponse();
		}
		return null;
	}

	public String deleteGame(Integer id)
	{
		HttpDelete delete = makeDeleteMethod("games/" + id);
		if(sendRequest(delete))
		{
			return parseResponse();
		}
		return null;
	}

	public String deleteGame(String id)
	{
		HttpDelete delete = makeDeleteMethod("games/" + id);
		if(sendRequest(delete))
		{
			return parseResponse();
		}
		return null;
	}
}
