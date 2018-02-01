package us.vetsoft.twitch.helix.utilities;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Populates the data to be used to build the Query String.
 */
public class QueryStringBuilder {
    int first = 20;
    String after = "";
    String id = "";
    String before = "";
    String type = "all";
    String fromId = "";
    String toId = "";
    String bId = "";// Broadcaster ID
    String manifestId = "";
    Collection<String> userIds = new CopyOnWriteArrayList<>();
    Collection<String> userLogins = new CopyOnWriteArrayList<>();
    Collection<String> communityIds = new CopyOnWriteArrayList<>();
    Collection<String> gameIds = new CopyOnWriteArrayList<>();
    Collection<String> language = new CopyOnWriteArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setManifestId(String manifestId) {
        this.manifestId = manifestId;
    }

    public void setBroadcasterId(String broadcasterId) {
        if (broadcasterId.isEmpty()) throw new IllegalArgumentException("The Broadcaster ID is a required field.");

        this.bId = broadcasterId;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public void setUserIds(Collection<String> userIds) {
        if (!this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userIds = userIds;
    }

    public void setUserLogins(Collection<String> userLogins) {
        if (!this.userIds.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userLogins.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userLogins = userLogins;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCommunityIds(Collection<String> communityIds) {
        if (!this.gameIds.isEmpty() || !this.language.isEmpty() || !this.userIds.isEmpty() || !this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (communityIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.communityIds = communityIds;
    }

    public void setGameIds(Collection<String> gameIds) {
        if (!this.communityIds.isEmpty() || !this.language.isEmpty() || !this.userIds.isEmpty() || !this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (gameIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.gameIds = gameIds;
    }

    public void setLanguage(Collection<String> language) {
        if (!this.gameIds.isEmpty() || !this.communityIds.isEmpty() || !this.userIds.isEmpty() || !this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (language.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.language = language;
    }

    public QueryString build() {
        return new QueryString(this);
    }
}
