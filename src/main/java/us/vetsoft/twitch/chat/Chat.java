package us.vetsoft.twitch.chat;

import us.vetsoft.twitch.chat.utilities.IChatListener;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Chat {

	private final String OAUTH;
	private final String NICK;
	private final List<String> CHANNELS;
	private final List<IChatListener> LISTENERS;

	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;

	public Chat(String defaultChannel, String nick, String oauth) {
		this(nick, oauth);
		CHANNELS.add(defaultChannel);
	}

	public Chat(String nick, String oauth) {
		NICK = nick;
		OAUTH = oauth;
		CHANNELS = new ArrayList<>();
		LISTENERS = new ArrayList<>();
		try {
			this.socket = new Socket("irc.chat.twitch.tv", 6667);
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void connect() throws IOException {
		//sendServerMessage("PASS", OAUTH);
		sendServerMessage("NICK", NICK);

		sendServerMessage("CAP REQ", ":twitch.tv/membership");
		sendServerMessage("CAP REQ", ":twitch.tv/tags");
		sendServerMessage("CAP REQ", ":twitch.tv/commands");

		String line;
		boolean running = true;
		while((line = reader.readLine()) != null && running){
			System.out.println("< " + line);
			if(line.contains("004")) running = false;
		}

		if(!CHANNELS.isEmpty()) {
			CHANNELS.forEach(this::joinChannel);
		} else {
			System.out.println("No channels to join");
		}

		ChatThread thread = new ChatThread(LISTENERS, writer, reader);
		thread.run();
	}

	/**
	 * Please add all your listeners before connecting to chat
	 */
	public void addChatListener(IChatListener chatListener) {
		LISTENERS.add(chatListener);
	}

	private void joinChannel(String channel) {
		sendServerMessage("JOIN", channel);
	}

	private void leaveChannel(String channel) {
		sendServerMessage("PART", channel);
	}

	private void sendServerMessage(String command, String message){
		System.out.println(String.format("> %s %s", command, message));
		try {
			writer.write(String.format("%s %s\r\n", command, message));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String channel, String message) {
		sendServerMessage("PRIVMSG", channel + ":" + message);
	}
}
