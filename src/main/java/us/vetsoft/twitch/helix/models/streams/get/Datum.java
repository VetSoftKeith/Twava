package us.vetsoft.twitch.helix.models.streams.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("community_ids")
    @Expose
    private List<String> communityIds = new ArrayList<>();
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("viewer_count")
    @Expose
    private Integer viewerCount;
    @SerializedName("started_at")
    @Expose
    private String startedAt;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;

    /**
     * @return Stream ID.
     */
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Datum withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return ID of the user who is streaming.
     */
    public String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    public Datum withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * @return ID of the game being played on the stream.
     */
    public String getGameId() {
        return gameId;
    }

    private void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Datum withGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * @return Array of community IDs.
     */
    public List<String> getCommunityIds() {
        return communityIds;
    }

    private void setCommunityIds(List<String> communityIds) {
        this.communityIds = communityIds;
    }

    public Datum withCommunityIds(List<String> communityIds) {
        this.communityIds = communityIds;
        return this;
    }

    /**
     * @return Stream type: <code>"live"</code>, <code>"rerun"</code>, <code>"premiere"</code>, or <code>""</code>.
     */
    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * @return Stream title.
     */
    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public Datum withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return Number of viewers watching the stream at the time of the query.
     */
    public Integer getViewerCount() {
        return viewerCount;
    }

    private void setViewerCount(Integer viewerCount) {
        this.viewerCount = viewerCount;
    }

    public Datum withViewerCount(Integer viewerCount) {
        this.viewerCount = viewerCount;
        return this;
    }

    /**
     * @return UTC timestamp.
     */
    public String getStartedAt() {
        return startedAt;
    }

    private void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public Datum withStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * @return Stream language.
     */
    public String getLanguage() {
        return language;
    }

    private void setLanguage(String language) {
        this.language = language;
    }

    public Datum withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * All image URLs have variable width and height. You can replace <code>{width}</code> and <code>{height}</code>
     * with any values to get that size image
     *
     * @return Thumbnail URL of the stream.
     */
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    private void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Datum withThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("gameId", gameId)
                .append("communityIds", communityIds)
                .append("type", type)
                .append("title", title)
                .append("viewerCount", viewerCount)
                .append("startedAt", startedAt)
                .append("language", language)
                .append("thumbnailUrl", thumbnailUrl)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(title)
                .append(viewerCount)
                .append(communityIds)
                .append(thumbnailUrl)
                .append(gameId)
                .append(userId)
                .append(startedAt)
                .append(language)
                .append(type)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Datum)) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return new EqualsBuilder()
                .append(id, rhs.id)
                .append(title, rhs.title)
                .append(viewerCount, rhs.viewerCount)
                .append(communityIds, rhs.communityIds)
                .append(thumbnailUrl, rhs.thumbnailUrl)
                .append(gameId, rhs.gameId)
                .append(userId, rhs.userId)
                .append(startedAt, rhs.startedAt)
                .append(language, rhs.language)
                .append(type, rhs.type)
                .isEquals();
    }

}
