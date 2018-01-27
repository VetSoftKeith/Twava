package us.vetsoft.twitch.helix;

public class Twitch {
    private static String clientId = null;
    private static String oauthToken = null;

    public Twitch() {

    }

    public static String getClientId() {
        return clientId;
    }

    public static void setClientId(final String clientId) {
        Twitch.clientId = clientId;
    }

    public static String getOauthToken() {
        return oauthToken;
    }

    public static void setOauthToken(final String oauthToken) {
        Twitch.oauthToken = oauthToken;
    }
}
