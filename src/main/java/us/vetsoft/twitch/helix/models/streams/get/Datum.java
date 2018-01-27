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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Datum withId(String id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Datum withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Datum withGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public List<String> getCommunityIds() {
        return communityIds;
    }

    public void setCommunityIds(List<String> communityIds) {
        this.communityIds = communityIds;
    }

    public Datum withCommunityIds(List<String> communityIds) {
        this.communityIds = communityIds;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Datum withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getViewerCount() {
        return viewerCount;
    }

    public void setViewerCount(Integer viewerCount) {
        this.viewerCount = viewerCount;
    }

    public Datum withViewerCount(Integer viewerCount) {
        this.viewerCount = viewerCount;
        return this;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public Datum withStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Datum withLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
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
