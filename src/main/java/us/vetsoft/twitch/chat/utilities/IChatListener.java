package us.vetsoft.twitch.chat.utilities;

import us.vetsoft.twitch.chat.event.*;

public interface IChatListener {
	void onJoin(JoinEvent event);
	void onPart(PartEvent event);
	void onPrivMsg(PrivMsgEvent event);
	void onMode(ModeEvent event);
	void onNames(NamesEvent event);
	void onClearChat(ClearChatEvent event);
	void onGlobalUserState(GlobalUserStateEvent event);
	void onRoomstate(RoomstateEvent event);
	void onUserNotice(UserNoticeEvent event);
	void onUserState(UserStateEvent event);
	void onHostTarget(HostTargetEvent event);
	void onNotice(NoticeEvent event);
	void onReconnect(ReconnectEvent event);
}