package com.labyrinth.client;

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
		return getResponse(makeGetMethod("games"));
	}
	
	public String getOneGame(String id)
	{
		return getResponse(makeGetMethod("games/" + id));
	}

	public String getOneGame(Integer id)
	{
		return getResponse(makeGetMethod("games/" + id));
	}
	
	public String getLastGame()
	{
		return getResponse(makeGetMethod("games/last"));
	}

	public String createGame()
	{
		return getResponse(makePostMethod("games"));
	}

	public String deleteGame(Integer id)
	{
		return getResponse(makeDeleteMethod("games/" + id));
	}

	public String deleteGame(String id)
	{
		return getResponse(makeDeleteMethod("games/" + id));
	}
}
