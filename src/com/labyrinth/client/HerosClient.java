package com.labyrinth.client;

public class HerosClient extends LabyrinthApiClient
{
	/**
	 * The constructor using localhost as the server url
	 * 
	 * @param username - email address for the authenticated user
	 * @param password - password for the authenticated user
	 */
	public HerosClient(String username, String password)
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
	public HerosClient(String url, String username, String password)
	{
		super(url, username, password);
	}
	
	/**
	 * Returns all heros for the user.
	 * @param heroId
	 * @return the response from the GET method in String form
	 */
	public String getHeros()
	{
		return getResponse(makeGetMethod("heros"));
	}
	
	/**
	 * Get the hero with the Integer heroId
	 * @param heroId
	 * @return
	 */
	public String getHero(Integer heroId)
	{
		return getResponse(makeGetMethod("heros/" + heroId));
	}
	
	/**
	 * Get the hero with the String heroId
	 * @param heroId
	 * @return
	 */
	public String getHero(String heroId)
	{
		return getResponse(makeGetMethod("heros/" + heroId));
	}
	
	@Deprecated
	public String updateCurrentHero(Integer heroId, String rawData)
	{
		return updateHero(heroId, rawData);
	}
	
	/**
	 * Update the hero with the heroId
	 * @param heroId
	 * @param rawData
	 * @return
	 */
	public String updateHero(Integer heroId, String rawData)
	{
		return getResponse(makePutMethod("heros/" + heroId), rawData);
	}
	
	/**
	 * Get the options for the heros endpoint
	 * @return
	 */
	public String getHeroOptions()
	{
		return getResponse(makeOptionsMethod("heros"));
	}
	
	/**
	 * Get the options for the heros/game endpoint
	 * @return
	 */
	public String getHerosGameOptions()
	{
		return getResponse(makeOptionsMethod("heros/game"));
	}
}
