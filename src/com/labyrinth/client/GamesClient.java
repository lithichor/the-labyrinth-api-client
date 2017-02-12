package com.labyrinth.client;

public class GamesClient extends LabyrinthApiClient
{
	/**
	 * Constructor to be used when server is on localhost
	 * @param username
	 * @param password
	 */
	public GamesClient(String username, String password)
	{
		super(username, password);
	}
	
	/**
	 * General constructor that can be used regardless of where
	 * the server is hosted
	 * @param url
	 * @param username
	 * @param password
	 */
	public GamesClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	/**
	 * Get all Games for the user
	 * @return
	 */
	public String getAllGames()
	{
		return getResponse(makeGetMethod("games"));
	}
	
	/**
	 * Get a single Game by providing a String ID
	 * @param id
	 * @return
	 */
	public String getOneGame(String id)
	{
		return getResponse(makeGetMethod("games/" + id));
	}

	/**
	 * Get a single Game by providing an Integer ID
	 * @param id
	 * @return
	 */
	public String getOneGame(Integer id)
	{
		return getResponse(makeGetMethod("games/" + id));
	}
	
	/**
	 * Get the last (most recent) Game for a user
	 * @return
	 */
	public String getLastGame()
	{
		return getResponse(makeGetMethod("games/last"));
	}

	/**
	 * Create a new Game
	 * @return
	 */
	public String createGame()
	{
		return getResponse(makePostMethod("games"));
	}

	/**
	 * Delete a Game using an Integer ID
	 * @param id
	 * @return
	 */
	public String deleteGame(Integer id)
	{
		return getResponse(makeDeleteMethod("games/" + id));
	}

	/**
	 * Delete a Game using a String ID
	 * @param id
	 * @return
	 */
	public String deleteGame(String id)
	{
		return getResponse(makeDeleteMethod("games/" + id));
	}
	
	/**
	 * Get the options for the game endpoint
	 * @return
	 */
	public String getGameOptions()
	{
		return getResponse(makeOptionsMethod("games"));
	}
}
