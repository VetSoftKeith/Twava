package us.vetsoft.twitch.chat.event;

public class ReconnectEvent {

	private long timestamp;

	public ReconnectEvent(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getTimestamp() {
		return timestamp;
	}
}
