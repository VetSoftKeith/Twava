package us.vetsoft.twitch.http;

import okhttp3.*;
import us.vetsoft.twitch.helix.utilities.QueryString;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class will invoke the HttpRequestBuilder, passing in the QueryString object, the URL object, and the required
 * method for the call.  This class will then pass the validated data from the builder to okhttp and return the response
 * to be handled by the resource class.
 */
public class HttpRequest {
    private Map<String, List<String>> headers = new ConcurrentHashMap<>(0);
    private Reader body = null;
    private String clientId = null;
    private String appToken = null;
    private String userToken = null;
    private OkHttpClient client = new OkHttpClient();

    private HttpRequestBuilder rBuilder;

    public HttpRequest(String endpoint, QueryString queryString, String clientId, String appToken, String userToken) {
        if (null != userToken) setUserToken(userToken);
        if (null != appToken) setAppToken(appToken);
        setClientId(clientId);

        setrBuilder(new HttpRequestBuilder(endpoint, queryString));
    }

    /**
     * Generates a GET request and sends it to Twitch.  Returns the full, un-parsed response to the Resource
     *
     * @return Return the response for parsing by the Resource
     */
    public synchronized HttpRequest get() {
        Request request = new Request.Builder()
                .url(getrBuilder().getUrl())
                .headers(createHeaders(getClientId(), getAppToken(), getUserToken()))
                .build();

        try (Response response = client.newCall(request).execute()) {

            if (response.code() == 200) {
                ResponseBody rBody = response.body();

                // Return null if the response body is empty
                if (null == rBody) {
                    setBody(null);
                } else {
                    setBody(rBody.charStream());
                }

                setHeaders(response.headers().toMultimap());
            }
        } catch (IOException e) {
            System.out.println(e);// TODO: SLF4J
        } catch (NullPointerException npe) {
            // Return NULL is the response body was empty
            return null;
        }

        return this;
    }

    private Headers createHeaders(String clientId, String appToken, String userToken) {
        Headers.Builder hBuilder = new Headers.Builder();

        if (null == clientId) {
            throw new NullPointerException("Client ID must not be null. See: https://dev.twitch.tv/dashboard if you need a Client ID.");
        } else {
            hBuilder.add("Client-ID", clientId);
        }

        // Add the user token to the Auth header as a primary
        if (null != userToken) {
            hBuilder.add("Authorization", "Bearer " + userToken);
        } else if (null != appToken) {
            hBuilder.add("Authorization", "Bearer " + appToken);
        }
        hBuilder.add("Content-Type", "application/json");
        hBuilder.add("User-Agent", "Powered by Twava");

        return hBuilder.build();
    }

    //TODO:  Expose these to the user in case they want to use them for something
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    private void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Reader getBody() {
        return body;
    }

    private void setBody(Reader body) {
        this.body = body;
    }

    private String getClientId() {
        return clientId;
    }

    private void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private String getAppToken() {
        return appToken;
    }

    private void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    private String getUserToken() {
        return userToken;
    }

    private void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    private HttpRequestBuilder getrBuilder() {
        return rBuilder;
    }

    private void setrBuilder(HttpRequestBuilder rBuilder) {
        this.rBuilder = rBuilder;
    }
}
