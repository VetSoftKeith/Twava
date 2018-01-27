package us.vetsoft.twitch.helix.resources;

import us.vetsoft.twitch.helix.GlobalConstants;
import us.vetsoft.twitch.helix.Twitch;

import java.util.List;

public class CreateClipResource {
    private final String clientId = Twitch.getClientId();
    private final String oauthToken = Twitch.getOauthToken();
    private final List<String> requiredScope = GlobalConstants.createClipsScopes();


}
