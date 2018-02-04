package us.vetsoft.twitch.chat.utilities;

import us.vetsoft.twitch.chat.utilities.enums.EnumHelper;
import us.vetsoft.twitch.chat.utilities.enums.UserType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChatMessage {

	private List<String> badges;
	private String bits;
	private String color;
	private String displayName;
	private String emotes;
	private String id;
	private String message;
	private boolean mod;
	private String channel;
	private String timestamp;
	private boolean turbo;
	private String userID;
	private UserType userType;
	private String roomID;
	private boolean isSub;
	private String rawLine;
	private boolean mercury;
	private Map<String, String> tags;

	public ChatMessage(Map<String, String> tags, String channel, String message, String rawLine)  {
		if(tags.containsKey("badges")) this.badges = Arrays.asList(tags.get("badges").split(","));
		this.bits = tags.get("bits");
		this.color = tags.get("color");
		this.displayName = tags.get("display-name");
		this.emotes = tags.get("emotes");
		this.id = tags.get("id");
		this.message = message.startsWith(":")? message.substring(1) : message;
		if(tags.containsKey("mod")) this.mod = tags.get("mod").equals("1");
		this.channel = channel;
		this.timestamp = tags.get("tmi-sent-ts");
		if(tags.containsKey("turbo")) this.turbo = tags.get("turbo").equals("1");
		this.userID = tags.get("user-id");
		this.roomID = tags.get("room-id");
		if(tags.containsKey("subscriber")) this.isSub = tags.get("subscriber").equals("1");
		if(tags.containsKey("mercury")) this.mercury = tags.get("mercury").equals("1");
		this.userType = EnumHelper.getUserTypeFromString(tags.get("user-type"));
		this.rawLine = rawLine;
		this.tags = tags;
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
		return mod;
	}

	public String getChannel() {
		return channel;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public boolean isTurbo() {
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

	public String getRoomID() {
		return roomID;
	}

	public boolean isSub() {
		return isSub;
	}

	public boolean isMercury() {
		return mercury;
	}
}
