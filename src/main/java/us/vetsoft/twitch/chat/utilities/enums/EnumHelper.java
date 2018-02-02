package us.vetsoft.twitch.chat.utilities.enums;

public class EnumHelper {

	public static UserNoticeType getUserNoticeTypeFromString(String name) {
		switch (name) {
			case "sub":
				return UserNoticeType.SUB;
			case "resub":
				return UserNoticeType.RESUB;
			case "raid":
				return UserNoticeType.RAID;
			case "ritual":
				return UserNoticeType.RITUAL;
			case "charity":
				return UserNoticeType.CHARITY;
		}

		return null;
	}

	public static SubType getSubTypeFromString(String name) {
		switch(name) {
			case "Prime":
				return SubType.PRIME;
			case "1000":
				return SubType.TIER1;
			case "2000":
				return SubType.TIER2;
			case "3000":
				return SubType.TIER3;
		}

		return null;
	}

	public static RitualType getRitualTypeFromString(String name) {
		switch(name) {
			case "new_chatter":
				return RitualType.NEWCHATTER;
		}

		return null;
	}

	public static UserType getUserTypeFromString(String name) {
		switch(name) {
			case "empty":
				return UserType.EMPTY;
			case "mod":
				return UserType.MOD;
			case "global_mod":
				return UserType.GLOBAL_MOD;
			case "admin":
				return UserType.ADMIN;
			case "staff":
				return UserType.STAFF;
		}

		return null;
	}
}