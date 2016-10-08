package tester;

import com.labyrinth.client.UserClient;

public class TestClient
{
	public static void main(String[] args)
	{
		UserClient client = new UserClient("eric@eric.corn", "1qweqwe");
		String responseString = client.getUser();
		
		System.out.println(responseString);
		
	}
}
