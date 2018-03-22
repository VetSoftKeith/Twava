package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;
import us.vetsoft.twitch.chat.utilities.enums.*;

import java.util.List;

public class UserNoticeEvent {

	private String rawLine;
	private List<String> badges;
	private String color;
	private String displayName;
	private String emotes;
	private String id;
	private String login;
	private String message;
	private boolean isMod;
	private UserNoticeType type;
	private String channelRaidingFormatted;
	private String channelRaiding;
	private String months;
	private SubType subType;
	private String subPlanName;
	private int viewerCount;
	private RitualType ritual;
	private String roomID;
	private boolean isSub;
	private String systemMessage;
	private String timestamp;
	private boolean isTurbo;
	private String uuid;
	private UserType userType;

	public UserNoticeEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.badges = message.getBadges();
		this.color = message.getColor();
		this.displayName = message.getDisplayName();
		this.emotes = message.getEmotes();
		this.id = message.getId();
		this.login = message.getTags().get("login");
		this.message = message.getMessage();
		this.isMod = message.isMod();
		this.type = EnumHelper.getUserNoticeTypeFromString(message.getTags().get("msg-id"));
		this.channelRaidingFormatted = message.getTags().get("msg-param-displayName");
		this.channelRaiding = message.getTags().get("msg-param-login");
		this.months = message.getTags().get("msg-param-months");
		this.subType = EnumHelper.getSubTypeFromString(message.getTags().get("msg-param-sub-plan"));
		this.subPlanName = message.getTags().get("msg-param-sub-plan-name");
		this.viewerCount = Integer.parseInt(message.getTags().get("msg-param-viewerCount"));
		this.ritual = EnumHelper.getRitualTypeFromString(message.getTags().get("msg-param-ritual-name"));
		this.roomID = message.getRoomID();
		this.isSub = message.isSub();
		this.systemMessage = message.getTags().get("system-msg");
		this.timestamp = message.getTimestamp();
		this.isTurbo = message.isTurbo();
		this.uuid = message.getUserID();
		this.userType = message.getUserType();
	}

	public List<String> getBadges() {
		return badges;
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

	public String getLogin() {
		return login;
	}

	public String getMessage() {
		return message;
	}

	public boolean isMod() {
		return isMod;
	}

	public UserNoticeType getType() {
		return type;
	}

	public String getChannelRaidingFormatted() {
		return channelRaidingFormatted;
	}

	public String getChannelRaiding() {
		return channelRaiding;
	}

	public String getMonths() {
		return months;
	}

	public SubType getSubType() {
		return subType;
	}

	public String getSubPlanName() {
		return subPlanName;
	}

	public int getViewerCount() {
		return viewerCount;
	}

	public RitualType getRitual() {
		return ritual;
	}

	public String getRoomID() {
		return roomID;
	}

	public boolean isSub() {
		return isSub;
	}

	public String getSystemMessage() {
		return systemMessage;
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

	public String getRawLine() {
		return rawLine;
	}
}