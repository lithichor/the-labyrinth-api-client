package com.labyrinth.client;

public class MapsClient extends LabyrinthApiClient
{
	/**
	 * A more general constructor for arbitrary server urls
	 * 
	 * @param url - the url for the server
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public MapsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public MapsClient(String username, String password)
	{
		super(username, password);
	}

	/**
	 * This method gets the Maps for the most recent Game
	 * @return the response from the server
	 */
	public String getCurrentGameMaps()
	{
		return getResponse(makeGetMethod("maps"));
	}
	
	/**
	 * This method gets the Map corresponding to the specified mapId
	 * @param mapId
	 * @return the response from the server
	 */
	public String getMapsFromMapId(Integer mapId)
	{
		return getResponse(makeGetMethod("maps/" + mapId));
	}
	
	/**
	 * A convenience method for getMapsFromMapId(Integer mapId)
	 * @param mapId
	 * @return the response from the server
	 */
	public String getMapsFromMapId(String mapId)
	{
		return getResponse(makeGetMethod("maps/" + mapId));
	}
	
	/**
	 * This method gets the Maps for the Game specified by gameId
	 * @param gameId
	 * @return the response from the server
	 */
	public String getMapsForGame(String gameId)
	{
		return getResponse(makeGetMethod("maps/games/" + gameId));
	}
	
	/**
	 * A convenience method so you don't need to change your Integer
	 * to a String. Ain't that something?
	 * @param gameId
	 * @return
	 */
	public String getMapsForGame(Integer gameId)
	{
		return getResponse(makeGetMethod("maps/games/" + gameId));
	}

	/**
	 * Create a new Map from a JSON-formatted string
	 * @param rawData - JSON-formatted data
	 * @return The response from the server
	 */
	public String makeNewMapForGame(String rawData)
	{
		return getResponse(makePostMethod("maps"), rawData);
	}
}
