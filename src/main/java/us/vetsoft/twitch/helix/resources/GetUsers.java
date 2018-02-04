package us.vetsoft.twitch.helix.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import us.vetsoft.twitch.helix.models.users.get.Users;
import us.vetsoft.twitch.helix.utilities.QueryStringBuilder;
import us.vetsoft.twitch.http.HttpRequest;

public class GetUsers {
    private Users users = null;

    /**
     * Creates the {@link HttpRequest} object and returns it to the application.
     *
     * @param getUsersQuery The query string builder object.
     * @param clientId      The passed Twitch Client ID
     * @param appToken      The optional Application Token passed in from {@link us.vetsoft.twitch.helix.Helix}.
     * @param userToken     Required only if needing additional OAuth protected User information.
     */
    public GetUsers(QueryStringBuilder getUsersQuery, String clientId, String appToken, String userToken) {
        sendToApplication(new HttpRequest("/users", getUsersQuery.build(), clientId, appToken, userToken).get());
    }

    /**
     * Parses the response form the API into a usable format.
     *
     * @param request The finished {@link HttpRequest} object.
     */
    private void sendToApplication(HttpRequest request) {
        Gson gson = new Gson();
        JsonObject responseJson = new JsonParser().parse(request.getBody()).getAsJsonObject();
        setUsers(gson.fromJson(responseJson, Users.class));
    }

    /**
     * Returns the {@link Users} object fot the application to use.
     *
     * @return {@link Users} object
     */
    public Users getUsers() {
        return users;
    }

    private void setUsers(Users users) {
        this.users = users;
    }
}
