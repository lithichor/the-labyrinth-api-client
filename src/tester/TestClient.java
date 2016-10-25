package tester;

import com.labyrinth.client.GamesClient;
import com.labyrinth.client.UserClient;

public class TestClient
{
	public static void main(String[] args)
	{
		GamesClient games = new GamesClient("eric@eric.corn", "1qweqwe");
		UserClient user = new UserClient("eric@eric.corn", "1qweqwe");
		
		String data = "{firstName: \"astrid\", lastName: \"astor\", email: \"astrid@astor.corn\", password: \"1qweqwe\"}";
		
		
		String responseString1 = games.getAllGames();
		String responseString2 = games.getOneGame("last");
		String responseString3 = games.getLastGame();
		
		System.out.println("All: " + responseString1);
		System.out.println("Last: " + responseString2);
		System.out.println("Last: " + responseString3);
		
	}
}
