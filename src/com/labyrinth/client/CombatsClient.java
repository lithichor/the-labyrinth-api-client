package com.labyrinth.client;

public class CombatsClient extends LabyrinthApiClient
{
	/**
	 * General constructor for arbitrary URL
	 * @param url
	 * @param username
	 * @param password
	 */
	public CombatsClient(String url, String username, String password)
	{
		super(url, username, password);
	}

	/**
	 * Constructor for localhost
	 * @param username
	 * @param password
	 */
	public CombatsClient(String username, String password)
	{
		super(username, password);
	}

	/**
	 * Get a Combat using an Integer ID
	 * @param combatId
	 * @return
	 */
	public String getCombat(Integer combatId)
	{
		return getResponse(makeGetMethod("combats/" + combatId));
	}

	/**
	 * Get a Combat using a String ID
	 * @param combatId
	 * @return
	 */
	public String getCombat(String combatId)
	{
		return getResponse(makeGetMethod("combats/" + combatId));
	}

	/**
	 * Update a Combat using an Integer ID
	 * @param combatId
	 * @param rawData
	 * @return
	 */
	public String updateCombat(Integer combatId, String rawData)
	{
		return getResponse(makePutMethod("combats/" + combatId), rawData);
	}

	/**
	 * Update a Combat using a String ID
	 * @param combatId
	 * @param rawData
	 * @return
	 */
	public String updateCombat(String combatId, String rawData)
	{
		return getResponse(makePutMethod("combats/" + combatId), rawData);
	}
	
	/**
	 * Get the Options for the combats endpoint
	 * @return
	 */
	public String getCombatsOptions()
	{
		return getResponse(makeOptionsMethod("combats"));
	}
}
