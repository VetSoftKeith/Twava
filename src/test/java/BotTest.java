import us.vetsoft.twitch.chat.Chat;

import java.io.IOException;

public class BotTest {

	private static Chat chat;

	public static void main(String[] args) {
		chat = new Chat("#cohhcarnage", "justinfan54321", "");
		chat.addChatListener(new TestListener());
		try {
			chat.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
