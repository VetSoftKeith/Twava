package us.vetsoft.twitch.helix;

import us.vetsoft.twitch.helix.resources.*;
import us.vetsoft.twitch.helix.utilities.QueryStringBuilder;

import java.util.Collection;

/**
 * API wrapper for the Twitch Helix REST API.
 *
 * @see <a href="https://dev.twitch.tv/docs/api/reference">New Twitch API Reference</a>
 */
public class Helix {
    private String clientId;
    private String userToken = null;
    private String appToken = null;

    /**
     * @param clientId The application's Client ID
     */
    public Helix(String clientId) {
        setClientId(clientId);
    }

    /**
     * @param clientId        The application's Client ID
     * @param userAccessToken The OAuth token provided for a User channel to the app upon proper authorization
     */
    public Helix(String clientId, String userAccessToken) {
        setClientId(clientId);
        setUserToken(userAccessToken);
    }

    /**
     * @param clientId        The application's Client ID
     * @param appAccessToken  The App Access token provided for for the application
     * @param userAccessToken The OAuth token provided for a User channel to the app upon proper authorization
     */
    public Helix(String clientId, String appAccessToken, String userAccessToken) {
        setClientId(clientId);
        setAppToken(appAccessToken);
        setUserToken(userAccessToken);
    }

    /**
     * Creates a clip programmatically.  Returns the CreateClip object containing the <code>ID</code> and the
     * <code>edit_url</code> of the clip.
     * <p>
     * Token requires OAuth Scope: <code>clips:edit</code>.
     * <p>
     * This endpoint has a global rate limit, across all callers.
     *
     * @param broadcasterId ID of the stream from which the clip will be made.
     *
     * @return CreateClipResource The response object from creating the clip.
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#create-clip">Create Clip</a>
     */
    public CreateClipResource createClip(String broadcasterId) {
        return new CreateClipResource(broadcasterId, getClientId(), getUserToken());
    }

    /**
     * Creates a URL where you can upload a manifest file and notify users that they have an entitlement. Entitlements
     * are digital items that users are entitled to use. Twitch entitlements are granted to users gratis or as part of a
     * purchase on Twitch.
     *
     * @param manifestId Unique identifier of the manifest file to be uploaded. Must be 1-64 characters.
     *
     * @return CreateEntitlementResource
     *
     * @throws IllegalStateException Thrown if the <code>manifestId</code> is not between 1 and 64 characters in
     *                               length.
     * @see <a href="https://dev.twitch.tv/docs/api/reference#create-entitlement-grants-upload-url">Create Entitlement
     * Grants Upload URL</a>
     */
    public CreateEntitlementResource createEntitlementGrant(String manifestId) {
        if (manifestId.length() < 1 || manifestId.length() > 64)
            throw new IllegalStateException("Manifest ID must be between 1 and 64 characters in length.");

        return new CreateEntitlementResource(manifestId, "bulk_drops_grant", getClientId(), getAppToken());
    }

    /**
     * Gets information about a specified clip.
     *
     * @return GetClipResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-clip">Get Clip</a>
     */
    public GetClipResource getClip() {
        return new GetClipResource(getClientId(), getAppToken());
    }

    /**
     * Gets information about a specified clip.
     *
     * @param clipId ID of the clip being queried. Limit 1.
     *
     * @return GetClipResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-clip">Get Clip</a>
     */
    public GetClipResource getClip(String clipId) {
        return new GetClipResource(clipId, getClientId(), getAppToken());
    }

    /**
     * Gets game information by game ID or name.
     *
     * @param games A mixed Collection of <code>id</code> and <code>name</code> of games. At most 100 <code>id</code>
     *              values can be specified. The name must be an exact match. For instance, "Pokemon" will not return a
     *              list of Pokemon games; instead, query the specific Pokemon game(s) in which you are interested. At
     *              most 100 <code>name</code> values can be specified.
     *
     * @return GetGamesResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-games">Get Games</a>
     */
    public GetGamesResource getGames(Collection<String> games) {
        return new GetGamesResource(games, getClientId(), getAppToken());
    }

    /**
     * Gets game information by game ID or name.
     *
     * @param gameIds   Game ID. At most 100 id values can be specified.
     * @param gameNames Game name. The name must be an exact match. For instance, "Pokemon" will not return a list of
     *                  Pokemon games; instead, query the specific Pokemon game(s) in which you are interested. At most
     *                  100 name values can be specified.
     *
     * @return GetGameResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-games">Get Games</a>
     */
    public GetGamesResource getGames(Collection<String> gameIds, Collection<String> gameNames) {
        if (Math.addExact(gameIds.size(), gameNames.size()) > 100)
            throw new IllegalStateException("You can only send 100 total game IDs and names per call.");

        return new GetGamesResource(gameIds, gameNames, getClientId(), getAppToken());
    }

    /**
     * Gets information about active streams. Streams are returned sorted by number of current viewers, in descending
     * order. Across multiple pages of results, there may be duplicate or missing streams, as viewers join and leave
     * streams.
     *
     * @param query A {@link QueryStringBuilder QueryStringBuilder} query builder object.
     *
     * @return GetStreamsResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-streams">Get Streams</a>
     */
    public GetStreamsResource getStreams(QueryStringBuilder query) {
        return new GetStreamsResource(query, getClientId(), getAppToken());
    }

    /**
     * Gets metadata information about active streams playing Overwatch or Hearthstone. Streams are sorted by number of
     * current viewers, in descending order. Across multiple pages of results, there may be duplicate or missing
     * streams, as viewers join and leave streams.
     * <p>
     * This endpoint has a global rate limit, across all callers.
     *
     * @param streamMetaQuery A {@link QueryStringBuilder QueryStringBuilder} query builder object.
     *
     * @return GetStreamsMetadataResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-streams-metadata">Get Streams Metadata</a>
     */
    public GetStreamsMetadataResource getStreamsMetadata(QueryStringBuilder streamMetaQuery) {
        return new GetStreamsMetadataResource(streamMetaQuery, getClientId(), getAppToken());
    }

    /**
     * Gets games sorted by number of current viewers on Twitch, most popular first.
     *
     * @param topGamesQuery A {@link QueryStringBuilder QueryStringBuilder} query builder object.
     *
     * @return GetTopGamesResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-top-games">Get Top Games</a>
     */
    public GetTopGamesResource getTopGames(QueryStringBuilder topGamesQuery) {
        return new GetTopGamesResource(topGamesQuery, getClientId(), getAppToken());
    }

    /**
     * Gets information about one or more specified Twitch users. Users are identified by optional user IDs and/or login
     * name. If neither a user ID nor a login name is specified, the user is looked up by Bearer token.
     *
     * Optional scope: <code>user:read:email</code>. If this is provided, the response includes the user's email
     * address.
     *
     * @param query A {@link QueryStringBuilder QueryStringBuilder} query builder object.
     *
     * @return GetUsersResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-users">Get Users</a>
     */
    public GetUsersResource getUsers(QueryStringBuilder query) {
        return new GetUsersResource(query, getClientId(), getAppToken(), getUserToken());
    }

    /**
     * Gets information on follow relationships between two Twitch users. Information returned is sorted in order, most
     * recent follow first. This can return information like "who is lirik following," "who is following lirik," or "is
     * user X following user Y."
     *
     * @param query A {@link QueryStringBuilder QueryStringBuilder} query builder object.
     *
     * @return UsersFollows
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-users-follows">Get Users Follows</a>
     */
    public UsersFollows getUsersFollows(QueryStringBuilder query) {
        return new UsersFollows(query, getClientId(), getAppToken());
    }

    /**
     * Updates the description of a user specified by a Bearer token.
     * <p>
     * Required scope: <code>user:edit</code>.
     *
     * @param description The channel description to be updated.
     *
     * @return UpdateUserResource
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#update-user">Update User</a>
     */
    public UpdateUserResource updateUser(String description) {
        return new UpdateUserResource(description, getClientId(), getAppToken(), getUserToken());
    }

    /**
     * Gets video information by video ID (one or more), user ID (one only), or game ID (one only).
     *
     * @param videoIds Collection of no more than 100 video ID strings
     *
     * @return GetVideos
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-videos">Get GetVideos</a>
     */
    public GetVideos getVideos(Collection<String> videoIds) {
        return new GetVideos(videoIds, getClientId(), getAppToken());
    }

    /**
     * Gets video information by video ID (one or more), user ID (one only), or game ID (one only).
     *
     * @param id     ID of a user or a game
     * @param idType <code>user</code> or <code>game</code>. The type of ID passed in the <code>id</code> param.
     *
     * @return GetVideos
     *
     * @see <a href="https://dev.twitch.tv/docs/api/reference#get-videos">Get GetVideos</a>
     */
    public GetVideos getVideos(String id, String idType) {
        return new GetVideos(id, idType, getClientId(), getAppToken());
    }

    private String getAppToken() {
        return appToken;
    }

    private void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    private String getClientId() {
        return this.clientId;
    }

    private void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    private String getUserToken() {
        return this.userToken;
    }

    private void setUserToken(final String oauthToken) {
        this.userToken = oauthToken;
    }
}
