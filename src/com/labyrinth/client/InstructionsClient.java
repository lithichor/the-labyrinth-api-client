package com.labyrinth.client;

public class InstructionsClient extends LabyrinthApiClient
{
	/**
	 * General constructor
	 * @param url
	 * @param username
	 * @param password
	 */
	public InstructionsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * Constructor for server on localhost
	 * @param username
	 * @param password
	 */
	public InstructionsClient(String username, String password)
	{
		super(username, password);
	}
	
	/**
	 * No argument constructor, since this endpoint doesn't
	 * require authentication
	 */
	public InstructionsClient()
	{
		super(null, null);
	}

	/**
	 * Get the instructions for The Labyrinth
	 * @return
	 */
	public String getInstructions()
	{
		return getResponse(makeGetMethod("instructions"));
	}

	/**
	 * get the Options for the instructions endpoint
	 * @return
	 */
	public String getOptionsForInstructions()
	{
		return getResponse(makeOptionsMethod("instructions"));
	}
}
