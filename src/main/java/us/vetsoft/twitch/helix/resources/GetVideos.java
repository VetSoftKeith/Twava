package us.vetsoft.twitch.helix.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import us.vetsoft.twitch.helix.models.videos.Videos;
import us.vetsoft.twitch.helix.utilities.QueryStringBuilder;
import us.vetsoft.twitch.http.HttpRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class GetVideos {
    private Videos videos = null;

    /**
     * Use of this constructor to passd a collection of vide ID's you want data for.
     *
     * @param videoIds Collection of video IDs passed as a collection of strings.
     * @param clientId The Client ID provided to the main {@link us.vetsoft.twitch.helix.Helix Helix} object.
     * @param appToken The (optional) Application token passed to the main {@link us.vetsoft.twitch.helix.Helix Helix}
     *                 object.
     */
    public GetVideos(Collection<String> videoIds, String clientId, String appToken) {
        if (videoIds.size() > 100 || videoIds.isEmpty())
            throw new IllegalArgumentException("Video list must contain between 1 and 100 video ID's");

        QueryStringBuilder qBuilder = new QueryStringBuilder();

        // If there's only one video ID present, just stringify it and move on
        // otherwise, join them together as one long string.  Should prob move this to QueryBuilder
        if (videoIds.size() == 1) qBuilder.setId("id=" + videoIds.stream().collect(Collectors.joining()));
        else qBuilder.setId(videoIds.stream().collect(Collectors.joining("&id=", "id=", "")));

        sendToApplication(new HttpRequest("/videos", qBuilder.build(), clientId, appToken, null));
    }

    /**
     * Use this method call to get the video list for the specified Twitch User or Game.
     *
     * Use of this constructor requires the following: One of id type: <code>game</code> or <code>user</code>
     *
     * @param id       The user or game ID.
     * @param idType   The type of ID.  Requires one of: <code>game</code> or <code>user</code>.
     * @param clientId The Client ID provided to the main {@link us.vetsoft.twitch.helix.Helix Helix} object.
     * @param appToken The (optional) Application token passed to the main {@link us.vetsoft.twitch.helix.Helix Helix}
     *                 object.
     *
     * @throws UnsupportedOperationException Throws this is the parameter <code>idType</code> is anything other than
     *                                       <code>game</code> or <code>user</code>.
     */
    public GetVideos(String id, String idType, String clientId, String appToken) {
        // probably shuld delegate building the Query to the application
        QueryStringBuilder qBuilder = new QueryStringBuilder();
        ArrayList<String> ids = new ArrayList<>(0);

        if (idType.equalsIgnoreCase("game")) {
            ids.add(id);
            qBuilder.setGameIds(ids);
        } else if (idType.equalsIgnoreCase("user")) {
            ids.add(id);
            qBuilder.setUserIds(ids);
        } else {
            throw new UnsupportedOperationException("This endpoint only supports game and user id types.");
        }

        sendToApplication(new HttpRequest("/videos", qBuilder.build(), clientId, appToken, null));
    }

    /**
     * Parses the response form the API into a usable format.
     *
     * @param request The finished {@link HttpRequest HttpRequest} object.
     */
    private void sendToApplication(HttpRequest request) {
        Gson gson = new Gson();
        JsonObject responseJson = new JsonParser().parse(request.getBody()).getAsJsonObject();
        setVideos(gson.fromJson(responseJson, Videos.class));
    }

    public Videos getVideos() {
        return videos;
    }

    private void setVideos(Videos videos) {
        this.videos = videos;
    }
}
