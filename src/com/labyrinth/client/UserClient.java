package com.labyrinth.client;

public class UserClient extends LabyrinthApiClient
{
	/**
	 * A more general constructor for arbitrary server urls
	 * 
	 * @param url - the url for the server
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public UserClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public UserClient(String username, String password)
	{
		super(username, password);
	}

	/**
	 * Get the data for the authenticated user
	 * @return The response from the server
	 */
	public String getUser()
	{
		return getResponse(makeGetMethod("user"));
	}
	
	/**
	 * Create a new user from the JSON data
	 * @param rawData - JSON-formatted String
	 * @return The response from the server
	 */
	public String createUser(String rawData)
	{
		return getResponse(makePostMethod("user"), rawData);
	}
	
	/**
	 * Update the user with JSON data
	 * @param rawData - JSON formatted string
	 * @return The response from the server
	 */
	public String updateUser(String rawData)
	{
		return getResponse(makePutMethod("user"), rawData);
	}
	
	/**
	 * Delete the user
	 * @return The response from the server
	 */
	public String deleteUser()
	{
		return getResponse(makeDeleteMethod("user"));
	}
}
