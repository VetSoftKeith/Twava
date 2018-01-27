package us.vetsoft.twitch.helix.utilities;

public enum Msg {
    MULTIPLE_COLLECTION_EXCEPTION("You may only set one list of: community id's, game id's, languages, user id's, user login's."),
    MAXIMUM_SIZE_EXCEPTION("You may only have a maximum amount of 100 items set at a time.");

    private final String token;

    Msg(String token) {
        this.token = token;
    }

    public String token() {
        return this.token;
    }
}
