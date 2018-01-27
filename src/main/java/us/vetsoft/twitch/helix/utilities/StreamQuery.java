package us.vetsoft.twitch.helix.utilities;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class StreamQuery {
    private int first = 20;
    private String after = "";
    private String before = "";
    private String type = "all";
    private Collection<String> communityIds = new CopyOnWriteArrayList<>();
    private Collection<String> gameIds = new CopyOnWriteArrayList<>();
    private Collection<String> language = new CopyOnWriteArrayList<>();
    private Collection<String> userIds = new CopyOnWriteArrayList<>();
    private Collection<String> userLogins = new CopyOnWriteArrayList<>();

    private String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    private String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    private int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    private String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Collection<String> getCommunityIds() {
        return communityIds;
    }

    public void setCommunityIds(Collection<String> communityIds) {
        if (!getGameIds().isEmpty() || !getLanguage().isEmpty() || !getUserIds().isEmpty() || !getUserLogins().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (communityIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.communityIds = communityIds;
    }

    private Collection<String> getGameIds() {
        return gameIds;
    }

    public void setGameIds(Collection<String> gameIds) {
        if (!getCommunityIds().isEmpty() || !getLanguage().isEmpty() || !getUserIds().isEmpty() || !getUserLogins().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (gameIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.gameIds = gameIds;
    }

    private Collection<String> getLanguage() {
        return language;
    }

    public void setLanguage(Collection<String> language) {
        if (!getGameIds().isEmpty() || !getCommunityIds().isEmpty() || !getUserIds().isEmpty() || !getUserLogins().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (language.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.language = language;
    }

    private Collection<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(Collection<String> userIds) {
        if (!getGameIds().isEmpty() || !getLanguage().isEmpty() || !getCommunityIds().isEmpty() || !getUserLogins().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userIds = userIds;
    }

    private Collection<String> getUserLogins() {
        return userLogins;
    }

    public void setUserLogins(Collection<String> userLogins) {
        if (!getGameIds().isEmpty() || !getLanguage().isEmpty() || !getUserIds().isEmpty() || !getCommunityIds().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userLogins.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userLogins = userLogins;
    }

    public StreamQuery build() {
        return this;
    }
}
