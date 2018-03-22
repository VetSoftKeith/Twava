package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class ClearChatEvent {

	private String rawLine;
	private Integer banDuration;
	private String banReason;

	/**
	 * Temporary or permanent ban on a channel.
	 * @param message
	 */
	public ClearChatEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		banDuration = Integer.valueOf(message.getTags().get("ban-duration"));
		banReason = message.getTags().get("ban-reason");
	}

	public String getRawLine() {
		return rawLine;
	}

	/**
	 * (Optional) Duration of the timeout, in seconds. If omitted, the ban is permanent.
	 */
	public Integer getBanDuration() {
		return banDuration;
	}

	/**
	 * The moderator’s reason for the timeout or ban.
	 */
	public String getBanReason() {
		return banReason;
	}
}
