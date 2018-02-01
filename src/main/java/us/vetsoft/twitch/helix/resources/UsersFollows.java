package us.vetsoft.twitch.helix.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import us.vetsoft.twitch.helix.models.users.follows.Follows;
import us.vetsoft.twitch.helix.utilities.QueryStringBuilder;
import us.vetsoft.twitch.http.HttpRequest;

/**
 * Fetches a Users follwers per the {@link us.vetsoft.twitch.helix.utilities.QueryString}.
 */
public class UsersFollows {
    private Follows follows = null;

    /**
     * Creates the {@link HttpRequest} object and returns it to the application.
     *
     * @param getUsersQuery The query string builder object.
     * @param clientId The passed Twitch Client ID
     * @param appToken The optional Application Token passed in from {@link us.vetsoft.twitch.helix.Helix}.
     */
    public UsersFollows(QueryStringBuilder getUsersQuery, String clientId, String appToken) {
        sendToApplication(new HttpRequest("/users", getUsersQuery.build(), clientId, appToken, null).get());
    }

    /**
     * Parses the response form the API into a usable format.
     *
     * @param request The finished {@link HttpRequest} object.
     */
    private void sendToApplication(HttpRequest request) {
        Gson gson = new Gson();
        JsonObject responseJson = new JsonParser().parse(request.getBody()).getAsJsonObject();
        setFollows(gson.fromJson(responseJson, Follows.class));
    }

    /**
     * Returns the {@link Follows} object fot the application to use.
     *
     * @return {@link Follows} object
     */
    public Follows getFollows() {
        return follows;
    }

    private void setFollows(Follows follows) {
        this.follows = follows;
    }
}
