package com.labyrinth.client;

public class ConstantsClient extends LabyrinthApiClient
{
	/**
	 * Constructor that allows you to use a non-local URL
	 * @param url
	 * @param username
	 * @param password
	 */
	public ConstantsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * Constructor for localhost server
	 * @param username
	 * @param password
	 */
	public ConstantsClient(String username, String password)
	{
		super(username, password);
	}

	public String getConstants()
	{
		return getResponse(makeGetMethod("constants"));
	}
}
