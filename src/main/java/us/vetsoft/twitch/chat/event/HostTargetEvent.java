package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class HostTargetEvent {

	private String rawLine;
	private String channel;
	private Integer numberOfViewers;
	private boolean isHosted;

	public HostTargetEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.channel = message.getChannel();
		this.numberOfViewers = Integer.valueOf(message.getMessage());
		isHosted = !this.rawLine.contains(":-");
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getChannel() {
		return channel;
	}

	public Integer getNumberOfViewers() {
		return numberOfViewers;
	}

	public boolean isHosted() {
		return isHosted;
	}
}