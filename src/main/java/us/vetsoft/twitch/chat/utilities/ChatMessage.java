package us.vetsoft.twitch.chat.utilities;

import java.util.Map;

public class ChatMessage {

	private String badges;
	private String bits;
	private String color;
	private String displayName;
	private String emotes;
	private String id;
	private String message;
	private String mod;
	private String channel;
	private String timestamp;
	private boolean turbo;
	private String userID;
	private UserType userType;
	private String rawLine;
	private Map<String, String> tags;

	public ChatMessage(Map<String, String> tags, String channel, String message, String rawLine)  {
		this.badges = tags.get("badges");
		this.bits = tags.get("bits");
		this.color = tags.get("color");
		this.displayName = tags.get("display-name");
		this.emotes = tags.get("emotes");
		this.id = tags.get("id");
		this.message = message;
		this.mod = tags.get("mod");
		this.channel = channel;
		this.timestamp = tags.get("tmi-sent-ts");
		this.turbo = tags.get("turbo").equals("1");
		this.userID = tags.get("user-id");
		switch(tags.get("user-type")) {
			case "empty":
				this.userType = UserType.EMPTY;
				break;
			case "mod":
				this.userType = UserType.MOD;
				break;
			case "global_mod":
				this.userType = UserType.GLOBAL_MOD;
				break;
			case "admin":
				this.userType = UserType.ADMIN;
				break;
			case "staff":
				this.userType = UserType.STAFF;
				break;
		}
		this.rawLine = rawLine;
		this.tags = tags;
	}

	public String getBadges() {
		return badges;
	}

	public String getBits() {
		return bits;
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

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getMod() {
		return mod;
	}

	public String getChannel() {
		return channel;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean getTurbo() {
		return turbo;
	}

	public String getUserID() {
		return userID;
	}

	public UserType getUserType() {
		return userType;
	}

	public String getRawLine() {
		return rawLine;
	}

	public Map<String, String> getTags() {
		return tags;
	}
}
