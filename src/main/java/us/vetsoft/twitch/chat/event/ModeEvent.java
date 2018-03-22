package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class ModeEvent {

	private String rawLine;
	private String channel;
	private String user;
	private boolean isOpped;

	public ModeEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.channel = message.getChannel();
		this.user = message.getMessage();
		this.isOpped = this.rawLine.contains("+o");
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getChannel() {
		return channel;
	}

	public String getUser() {
		return user;
	}

	public boolean isOpped() {
		return isOpped;
	}
}
