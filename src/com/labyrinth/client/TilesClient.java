package com.labyrinth.client;

public class TilesClient extends LabyrinthApiClient
{

	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public TilesClient(String username, String password)
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
	public TilesClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	/**
	 * Get a Tile by passing in the ID as a String
	 * @param id
	 * @return the response from the server
	 */
	public String getTiles(String id)
	{
		return getResponse(makeGetMethod("tiles/" + id));
	}
	
	/**
	 * Get a Tile by passing in the ID as an Integer
	 * @param id
	 * @return the response from the server
	 */
	public String getTiles(Integer id)
	{
		return getResponse(makeGetMethod("tiles/" + id));
	}
	
	/**
	 * Get all Tiles for a given Map ID
	 * @param mapId
	 * @return the response from the server
	 */
	public String getTilesForMap(String mapId)
	{
		return getResponse(makeGetMethod("tiles/map/" + mapId));
	}
	
	/**
	 * Get all Tiles for a given Map ID
	 * @param mapId
	 * @return the response from the server
	 */
	public String getTilesForMap(Integer mapId)
	{
		return getResponse(makeGetMethod("tiles/map/" + mapId));
	}
	
}
