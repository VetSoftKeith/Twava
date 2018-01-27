package us.vetsoft.twitch.helix.utilities;

import java.util.ArrayList;
import java.util.List;

public class GlobalConstants {
    public static List<String> createClipsScopes() {
        List<String> scopes = new ArrayList<>(0);
        scopes.add("clips:edit");

        return scopes;
    }
}
