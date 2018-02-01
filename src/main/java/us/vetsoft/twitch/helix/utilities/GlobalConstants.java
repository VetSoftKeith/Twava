package us.vetsoft.twitch.helix.utilities;

import java.util.ArrayList;
import java.util.List;

public class GlobalConstants {
    public static final String TWITCH_HELIX_BASE = "https://api/twitch.tv/helix";
    public static final String HELIX_CREATE_ENTITLEMENT = "/entitlements/upload";
    public static final String HELIX_STREAMS_META = "/steams/metadata";
    public static final String HELIX_USERS_FOLLOWS = "/users/follows";
    public static final String HELIX_GAMES_TOP = "/games/top";
    public static final String HELIX_STREAMS = "/streams";
    public static final String HELIX_VIDEOS = "/videos";
    public static final String HELIX_CLIPS = "/clips";
    public static final String HELIX_GAMES = "/games";
    public static final String HELIX_USERS = "/users";

    public static final String[] httpMethods = {"GET", "POST", "PUT", "POST"};

    public static List<String> createClipsScopes() {
        List<String> scopes = new ArrayList<>(0);
        scopes.add("clips:edit");

        return scopes;
    }
}
