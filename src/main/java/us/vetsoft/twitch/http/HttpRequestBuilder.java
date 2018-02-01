package us.vetsoft.twitch.http;

import us.vetsoft.twitch.helix.utilities.GlobalConstants;
import us.vetsoft.twitch.helix.utilities.QueryString;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Verify's and formats the passed data before sending it to okhttp
 */
public class HttpRequestBuilder {
    private URL url;
    private String query;

    public HttpRequestBuilder(String endpoint, QueryString query) {
        setUrl(endpoint);
        setQuery(query);
    }

    public HttpRequestBuilder build() {
        return this;
    }

    protected URL getUrl() {
        return url;
    }

    /**
     * Parse the requested endpoint into a valid {@link URL} for {@link HttpRequest}.
     *
     * @param endpoint The endpoint on Twitch API.
     */
    private void setUrl(String endpoint) {
        URL urlCheck = null;

        // TODO: Make this cleaner
        try {
            switch (endpoint) {
                case "/entitlements/upload":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_CREATE_ENTITLEMENT
                                    + query);
                    break;
                case "/streams/metadata":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_STREAMS_META
                                    + query);
                    break;
                case "/users/follows":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_USERS_FOLLOWS
                                    + query);
                    break;
                case "/games/top":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_GAMES_TOP
                                    + query);
                    break;
                case "/streams":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_STREAMS
                                    + query);
                    break;
                case "/videos":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_VIDEOS
                                    + query);
                    break;
                case "/clips":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_CLIPS
                                    + query);
                    break;
                case "/games":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_GAMES
                                    + query);
                    break;
                case "/users":
                    urlCheck = new URL(
                            GlobalConstants.TWITCH_HELIX_BASE
                                    + GlobalConstants.HELIX_USERS
                                    + query);
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported endpoint on Twitch");
            }

        } catch (MalformedURLException e) {
            System.out.println(e);// TODO: SLF4J
        }

        this.url = urlCheck;
    }

    protected String getQuery() {
        return query;
    }

    /**
     * Parses the {@link QueryString} object.
     *
     * @param query
     */
    private void setQuery(QueryString query) {
        String q = query.build();

        if (null == q) {
            this.query = "";
            return;
        }

        this.query = q;
    }
}
