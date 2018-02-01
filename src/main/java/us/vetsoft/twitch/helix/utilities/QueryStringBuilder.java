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

    /**
     * <p>
     * Sets the <code>user_id</code> variable given all tests are passed first.  You are able to pass only one of these
     * variable types at a time in a query string.
     * </p>
     * <ul>
     * <li><code>game_id</code></li>
     * <li><code>community_id</code></li>
     * <li><code>user_id</code></li>
     * <li><code>user_login</code></li>
     * <li><code>language</code></li>
     * </ul>
     *
     * @param userIds Collection of <code>user_id</code> to pass to the query string.
     */
    public void setUserIds(Collection<String> userIds) {
        if (!this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userIds = userIds;
    }

    /**
     * <p>
     * Sets the <code>user_login</code> variable given all tests are passed first.  You are able to pass only one of
     * these variable types at a time in a query string.
     * </p>
     * <ul>
     * <li><code>game_id</code></li>
     * <li><code>community_id</code></li>
     * <li><code>user_id</code></li>
     * <li><code>user_login</code></li>
     * <li><code>language</code></li>
     * </ul>
     *
     * @param userLogins Collection of <code>user_login</code> to pass to the query string.
     */
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

    /**
     * <p>
     * Sets the <code>community_id</code> variable given all tests are passed first.  You are able to pass only one of
     * these variable types at a time in a query string.
     * </p>
     * <ul>
     * <li><code>game_id</code></li>
     * <li><code>community_id</code></li>
     * <li><code>user_id</code></li>
     * <li><code>user_login</code></li>
     * <li><code>language</code></li>
     * </ul>
     *
     * @param communityIds Collection of <code>community_id</code> to pass to the query string.
     */
    public void setCommunityIds(Collection<String> communityIds) {
        if (!this.gameIds.isEmpty() || !this.language.isEmpty() || !this.userIds.isEmpty() || !this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (communityIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.communityIds = communityIds;
    }

    /**
     * <p>
     * Sets the <code>game_id</code> variable given all tests are passed first.  You are able to pass only one of these
     * variable types at a time in a query string.
     * </p>
     * <ul>
     * <li><code>game_id</code></li>
     * <li><code>community_id</code></li>
     * <li><code>user_id</code></li>
     * <li><code>user_login</code></li>
     * <li><code>language</code></li>
     * </ul>
     *
     * @param gameIds Collection of <code>game_id</code> to pass to the query string.
     */
    public void setGameIds(Collection<String> gameIds) {
        if (!this.communityIds.isEmpty() || !this.language.isEmpty() || !this.userIds.isEmpty() || !this.userLogins.isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (gameIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.gameIds = gameIds;
    }

    /**
     * <p>
     * Sets the <code>language</code> variable given all tests are passed first.  You are able to pass only one of these
     * variable types at a time in a query string.
     * </p>
     * <ul>
     * <li><code>game_id</code></li>
     * <li><code>community_id</code></li>
     * <li><code>user_id</code></li>
     * <li><code>user_login</code></li>
     * <li><code>language</code></li>
     * </ul>
     *
     * @param language Collection of <code>language</code> to pass in the query string.
     */
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
