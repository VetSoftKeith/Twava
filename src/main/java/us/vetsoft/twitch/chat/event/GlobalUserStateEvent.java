package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;
import us.vetsoft.twitch.chat.utilities.enums.UserType;

public class GlobalUserStateEvent {

	private String rawLine;
	private String color;
	private String displayName;
	private String emoteSets;
	private boolean hasTurbo;
	private String uuid;
	private UserType userType;

	/**
	 * On successful login.
	 */
	public GlobalUserStateEvent(ChatMessage message) {
		rawLine = message.getRawLine();
		color = message.getColor();
		displayName = message.getDisplayName();
		emoteSets = message.getTags().get("emote-sets");
		hasTurbo = message.isTurbo();
		uuid = message.getUserID();
		userType = message.getUserType();
	}

	public String getRawLine() {
		return rawLine;
	}

	/**
	 * Hexadecimal RGB color code. This is empty if it is never set.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * The user’s display name, escaped as described in the IRCv3 spec. This is empty if it is never set.
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 	A comma-separated list of emotes, belonging to one or more emote sets. This always contains at least 0.
	 */
	public String getEmoteSets() {
		return emoteSets;
	}

	public boolean HasTurbo() {
		return hasTurbo;
	}

	public String getUuid() {
		return uuid;
	}

	/**
	 * The user’s type. Valid values: empty, mod, global_mod, admin, staff. The broadcaster can have any of these.
	 */
	public UserType getUserType() {
		return userType;
	}
}
