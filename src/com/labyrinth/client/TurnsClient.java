package com.labyrinth.client;

public class TurnsClient extends LabyrinthApiClient
{
	public TurnsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	public TurnsClient(String username, String password)
	{
		super(username, password);
	}

	public String getTurn(Integer turnId)
	{
		return getResponse(makeGetMethod("turns/" + turnId));
	}

	public String getTurn(String turnId)
	{
		return getResponse(makeGetMethod("turns/" + turnId));
	}

	public String getTurnForGame(Integer gameId)
	{
		return getResponse(makeGetMethod("turns/game/" + gameId));
	}

	public String getTurnForGame(String gameId)
	{
		return getResponse(makeGetMethod("turns/game/" + gameId));
	}
}
