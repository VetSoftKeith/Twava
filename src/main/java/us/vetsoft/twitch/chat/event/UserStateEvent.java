package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;
import us.vetsoft.twitch.chat.utilities.enums.UserType;

public class UserStateEvent {

	private String rawLine;
	private String color;
	private String displayName;
	private String emotes;
	private boolean isMod;
	private boolean isSub;
	private boolean isTurbo;
	private UserType userType;

	public UserStateEvent(ChatMessage message ) {
		this.rawLine = message.getRawLine();
		this.color = message.getColor();
		this.displayName = message.getDisplayName();
		this.emotes = message.getEmotes();
		this.isMod = message.isMod();
		this.isSub = message.isSub();
		this.isTurbo = message.isTurbo();
		this.userType = message.getUserType();
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getColor() {
		return color;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getEmotes() {
		return emotes;
	}

	public boolean isMod() {
		return isMod;
	}

	public boolean isSub() {
		return isSub;
	}

	public boolean isTurbo() {
		return isTurbo;
	}

	public UserType getUserType() {
		return userType;
	}
}