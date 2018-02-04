import us.vetsoft.twitch.chat.event.*;
import us.vetsoft.twitch.chat.utilities.IChatListener;


public class TestListener implements IChatListener {

	@Override
	public void onJoin(JoinEvent event) {
		System.out.println("");
	}

	@Override
	public void onPart(PartEvent event) {
		System.out.println("");
	}

	@Override
	public void onPrivMsg(PrivMsgEvent event) {
		System.out.println("");
	}

	@Override
	public void onMode(ModeEvent event) {
		System.out.println("");
	}

	@Override
	public void onNames(NamesEvent event) {
		System.out.println("");
	}

	@Override
	public void onClearChat(ClearChatEvent event) {
		System.out.println("");
	}

	@Override
	public void onGlobalUserState(GlobalUserStateEvent event) {
		System.out.println("");

	}

	@Override
	public void onRoomstate(RoomstateEvent event) {
		System.out.println("");

	}

	@Override
	public void onUserNotice(UserNoticeEvent event) {
		System.out.println("");

	}

	@Override
	public void onUserState(UserStateEvent event) {
		System.out.println("");

	}

	@Override
	public void onHostTarget(HostTargetEvent event) {
		System.out.println("");

	}

	@Override
	public void onNotice(NoticeEvent event) {
		System.out.println("");

	}

	@Override
	public void onReconnect(ReconnectEvent event) {
		System.out.println("");

	}
}
