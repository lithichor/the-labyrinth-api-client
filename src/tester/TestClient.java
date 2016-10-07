package tester;

import com.labyrinth.client.GamesClient;

public class TestClient
{
	public static void main(String[] args)
	{
		GamesClient client = new GamesClient("eric@eric.corn", "1qweqwe");
		String responseString = client.getAllGames();
		
		System.out.println(responseString);
		
	}
}
