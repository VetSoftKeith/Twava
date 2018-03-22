package us.vetsoft.twitch.chat;

import us.vetsoft.twitch.chat.event.*;
import us.vetsoft.twitch.chat.utilities.ChatParser;
import us.vetsoft.twitch.chat.utilities.IChatListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ChatThread extends Thread {

	private BufferedReader reader;
	private BufferedWriter writer;
	private List<IChatListener> listeners;

	public ChatThread(List<IChatListener> listeners, BufferedWriter writer, BufferedReader reader) {
		this.listeners = listeners;
		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public void run() {
		super.run();

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				if(line.contains("PING")) {
					try {
						writer.write("PONG :tmi.twitch.tv");
						writer.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if(line.contains("JOIN")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onJoin(new JoinEvent(ChatParser.parseJoinPart(finalLine))));
				} else if(line.contains("PART")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onPart(new PartEvent(ChatParser.parseJoinPart(finalLine))));
				} else if(line.contains("PRIVMSG")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onPrivMsg(new PrivMsgEvent(ChatParser.parsePrivMessage(finalLine))));
				} else if(line.contains("MODE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onMode(new ModeEvent(ChatParser.parseMode(finalLine))));
				} else if(line.contains("353") || line.contains("366")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onNames(new NamesEvent(ChatParser.parseNames(finalLine))));
				} else if(line.contains("CLEARCHAT")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onClearChat(new ClearChatEvent(ChatParser.parsePrivMessage(finalLine))));
				} else if(line.contains("GLOBALUSERSTATE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onGlobalUserState(new GlobalUserStateEvent(ChatParser.parsePrivMessage(finalLine))));
				} else if(line.contains("ROOMSTATE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onRoomstate(new RoomstateEvent(ChatParser.parseRoomstate(finalLine))));
				} else if(line.contains("USERNOTICE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onUserNotice(new UserNoticeEvent(ChatParser.parsePrivMessage(finalLine))));
				} else if(line.contains("USERSTATE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onUserState(new UserStateEvent(ChatParser.parseRoomstate(finalLine))));
				} else if(line.contains("HOSTTARGET")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onHostTarget(new HostTargetEvent(ChatParser.parseHostTarget(finalLine))));
				} else if(line.contains("NOTICE")) {
					String finalLine = line;
					listeners.forEach(listener -> listener.onNotice(new NoticeEvent(ChatParser.parsePrivMessage(finalLine))));
				} else if(line.contains("RECONNECT")) {
					listeners.forEach(listener -> listener.onReconnect(new ReconnectEvent(System.currentTimeMillis())));
				}
			}
		} catch(IOException ignored) {}
	}
}