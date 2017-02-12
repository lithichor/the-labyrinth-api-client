package com.labyrinth.client;

public class TurnsClient extends LabyrinthApiClient
{
	/**
	 * General constructor for when server is not local
	 * @param url
	 * @param username
	 * @param password
	 */
	public TurnsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * Constructor for localhost servers
	 * @param username
	 * @param password
	 */
	public TurnsClient(String username, String password)
	{
		super(username, password);
	}

	/**
	 * Get a Turn using an Integer ID
	 * @param turnId
	 * @return
	 */
	public String getTurn(Integer turnId)
	{
		return getResponse(makeGetMethod("turns/" + turnId));
	}

	/**
	 * Get a Turn using a String ID
	 * @param turnId
	 * @return
	 */
	public String getTurn(String turnId)
	{
		return getResponse(makeGetMethod("turns/" + turnId));
	}

	/**
	 * Get the current Turn for a Game using an Integer GameId
	 * @param gameId
	 * @return
	 */
	public String getTurnForGame(Integer gameId)
	{
		return getResponse(makeGetMethod("turns/game/" + gameId));
	}

	/**
	 * Get the current Turn for a Game using a String GameId
	 * @param gameId
	 * @return
	 */
	public String getTurnForGame(String gameId)
	{
		return getResponse(makeGetMethod("turns/game/" + gameId));
	}
}
