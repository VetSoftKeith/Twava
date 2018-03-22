package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;
import us.vetsoft.twitch.chat.utilities.enums.UserType;

import java.util.List;

public class PrivMsgEvent {

	private List<String> badges;
	private String bits;
	private String color;
	private String displayName;
	private String emotes;
	private String id;
	private String message;
	private boolean isMod;
	private String roomID;
	private boolean isSub;
	private String timestamp;
	private boolean isTurbo;
	private String uuid;
	private UserType userType;

	public PrivMsgEvent(ChatMessage message) {
		this.badges = message.getBadges();
		this.bits = message.getBits();
		this.color = message.getColor();
		this.displayName = message.getDisplayName();
		this.emotes = message.getDisplayName();
		this.id = message.getId();
		this.message = message.getMessage();
		this.isMod = message.isMod();
		this.roomID = message.getRoomID();
		this.isSub = message.isSub();
		this.timestamp = message.getTimestamp();
		this.isTurbo = message.isTurbo();
		this.uuid = message.getUserID();
		this.userType = message.getUserType();
	}

	public List<String> getBadges() {
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

	public boolean isMod() {
		return isMod;
	}

	public String getRoomID() {
		return roomID;
	}

	public boolean isSub() {
		return isSub;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean isTurbo() {
		return isTurbo;
	}

	public String getUuid() {
		return uuid;
	}

	public UserType getUserType() {
		return userType;
	}
}