package us.vetsoft.twitch.chat.event;

import us.vetsoft.twitch.chat.utilities.ChatMessage;

public class NoticeEvent {

	private String rawLine;
	private String message;
	private String msgID;
	private String channel;

	public NoticeEvent(ChatMessage message) {
		this.rawLine = message.getRawLine();
		this.message = message.getMessage();
		this.msgID = message.getTags().get("msg-id");
		this.channel = message.getChannel();
	}

	public String getRawLine() {
		return rawLine;
	}

	public String getMessage() {
		return message;
	}

	public String getMsgID() {
		return msgID;
	}

	public String getChannel() {
		return channel;
	}
}