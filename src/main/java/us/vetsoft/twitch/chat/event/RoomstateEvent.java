package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class RoomstateEvent {

	private String rawLine;
	private String broadcasterLang;
	private boolean isR9K;
	private boolean isSlow;
	private int slow;
	private boolean isSub;

	public RoomstateEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.broadcasterLang = message.getTags().get("broadcaster-lang");
		this.isR9K = message.getTags().get("r9k").equals("1");
		this.isSlow = !message.getTags().get("slow").equals("0");
		if(!this.isSlow)
			this.slow = Integer.valueOf(message.getTags().get("slow"));
		this.isSub = message.getTags().get("subs-only").equals("1");
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getBroadcasterLang() {
		return broadcasterLang;
	}

	public boolean isR9K() {
		return isR9K;
	}

	public boolean isSlowMode() {
		return isSlow;
	}

	public int getSlowModeSeconds() {
		return slow;
	}

	public boolean isSubOnly() {
		return isSub;
	}
}
