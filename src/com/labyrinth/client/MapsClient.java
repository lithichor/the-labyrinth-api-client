package com.labyrinth.client;

import org.apache.http.client.methods.HttpGet;

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
		HttpGet get = makeGetMethod("maps");
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	/**
	 * This method gets the Map corresponding to the specified mapId
	 * @param mapId
	 * @return the response from the server
	 */
	public String getMapsFromMapId(Integer mapId)
	{
		HttpGet get = makeGetMethod("maps/" + mapId);
		
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	/**
	 * A convenience method for getMapsFromMapId(Integer mapId)
	 * @param mapId
	 * @return the response from the server
	 */
	public String getMapsFromMapId(String mapId)
	{
		HttpGet get = makeGetMethod("maps/" + mapId);
		
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	/**
	 * This method gets the Maps for the Game specified by gameId
	 * @param gameId
	 * @return the response from the server
	 */
	public String getMapsForGame(String gameId)
	{
		HttpGet get = makeGetMethod("maps/games/" + gameId);
		
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
	
	/**
	 * A convenience method so you don't need to change your Integer
	 * to a String. Ain't that something?
	 * @param gameId
	 * @return
	 */
	public String getMapsForGame(Integer gameId)
	{
		HttpGet get = makeGetMethod("maps/games/" + gameId);
		
		if(sendRequest(get))
		{
			return parseResponse();
		}
		return null;
	}
}
