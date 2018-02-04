package us.vetsoft.twitch.chat.utilities;

import java.util.*;

public class ChatParser {

	public static ChatMessage parsePrivMessage(String rawLine) {
		String[] parts = rawLine.split(" ");
		String tags = parts[0];
		String channel = parts[3].substring(1);
		String message = parts[4];

		String[] tagArray = tags.split(";");
		Map<String, String> tagMap = new HashMap<>();
		Arrays.asList(tagArray).forEach(tag -> tagMap.put(tag.split("=")[0], tag.split("=").length == 2? tag.split("=")[1] : null));
		return new ChatMessage(tagMap, channel, message, rawLine);
	}

	public static ChatMessage parseHostTarget(String rawLine) {
		String[] parts = rawLine.split(" ");
		if(rawLine.contains(":-")) {
			//Hosting
			return new ChatMessage(new HashMap<>(), parts[2], parts[4], rawLine);
		} else {
			//Hosted
			return new ChatMessage(new HashMap<>(), parts[3], parts[4], rawLine);
		}
	}

	public static ChatMessage parseJoinPart(String rawLine) {
		String[] parts = rawLine.split(" ");
		return new ChatMessage(new HashMap<>(), parts[2], parts[0].split("!")[0].substring(1), rawLine);
	}

	public static ChatMessage parseMode(String rawLine) {
		String[] parts = rawLine.split(" ");
		return new ChatMessage(new HashMap<>(), parts[2], parts[4], rawLine);
	}

	public static ChatMessage parseNames(String rawLine) {
		String[] parts = rawLine.split(" ");
		List<String> usernames = new ArrayList<>();
		if(rawLine.contains("366")) {
			return new ChatMessage(new HashMap<>(), parts[3], "END",  rawLine);
		} else {
			for(int c = 5; c < parts.length; c++) {
				String username = parts[c];
				if(username.startsWith(":")) username = username.substring(1);
				usernames.add(username);
			}

			String message = String.join(";", usernames);
			return new ChatMessage(new HashMap<>(), parts[4], message, rawLine);
		}
	}

	public static ChatMessage parseRoomstate(String rawLine) {
		String[] parts = rawLine.split(" ");
		String tags = parts[0];
		String[] tagArray = tags.split(";");
		Map<String, String> tagMap = new HashMap<>();
		Arrays.asList(tagArray).forEach(tag -> tagMap.put(tag.split("=")[0], tag.split("=").length == 2? tag.split("=")[1] : null));
		return new ChatMessage(tagMap, parts[3], null, rawLine);
	}
}