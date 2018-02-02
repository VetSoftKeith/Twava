package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class PartEvent {

	private String rawLine;
	private String user;
	private String channel;

	public PartEvent(ChatMessage message) {
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
