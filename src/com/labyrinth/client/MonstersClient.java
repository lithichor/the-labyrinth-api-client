package com.labyrinth.client;

public class MonstersClient extends LabyrinthApiClient
{
	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public MonstersClient(String username, String password)
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
	public MonstersClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	/**
	 * get a Monster using the monsterId as an Integer
	 * @param monsterId
	 * @return
	 */
	public String getMonster(Integer monsterId)
	{
		return getResponse(makeGetMethod("monsters/" + monsterId));
	}

	/**
	 * get a Monster using the monsterId as a String
	 * @param monsterId
	 * @return
	 */
	public String getMonster(String monsterId)
	{
		return getResponse(makeGetMethod("monsters/" + monsterId));
	}

	/**
	 * Get a Monster using the Tile ID (Integer)
	 * @param tileId
	 * @return
	 */
	public String getMonsterForTile(Integer tileId)
	{
		return getResponse(makeGetMethod("monsters/tile/" + tileId));
	}

	/**
	 * Get a Monster using the Tile ID (String)
	 * @param tileId
	 * @return
	 */
	public String getMonsterForTile(String tileId)
	{
		return getResponse(makeGetMethod("monsters/tile/" + tileId));
	}
}
