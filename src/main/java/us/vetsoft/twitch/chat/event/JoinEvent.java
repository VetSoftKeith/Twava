package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class JoinEvent {

	private String rawLine;
	private String user;
	private String channel;

	public JoinEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.user = message.getMessage();
		this.channel = message.getChannel();
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getUser() {
		return user;
	}

	public String getChannel() {
		return channel;
	}
}
