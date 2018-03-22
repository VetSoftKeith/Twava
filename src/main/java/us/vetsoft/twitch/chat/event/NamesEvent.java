package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

import java.util.Arrays;
import java.util.List;

public class NamesEvent {

	private String rawLine;
	private List<String> usernames;
	private String channel;

	public NamesEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.usernames = Arrays.asList(message.getMessage().split(";"));
		this.channel = message.getChannel();
	}

	public String getRawLine() {
		return rawLine;
	}

	public List<String> getUsernames() {
		return usernames;
	}

	public String getChannel() {
		return channel;
	}
}
