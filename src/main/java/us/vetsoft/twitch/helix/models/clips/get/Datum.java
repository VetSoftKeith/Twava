package us.vetsoft.twitch.helix.models.clips.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;
    @SerializedName("broadcaster_id")
    @Expose
    private String broadcasterId;
    @SerializedName("creator_id")
    @Expose
    private String creatorId;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;

    /**
     * @return ID of the clip being queried.
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
     * @return URL where the clip can be viewed.
     */
    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public Datum withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return URL to embed the clip.
     */
    public String getEmbedUrl() {
        return embedUrl;
    }

    private void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public Datum withEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
        return this;
    }

    /**
     * @return User ID of the stream from which the clip was created.
     */
    public String getBroadcasterId() {
        return broadcasterId;
    }

    private void setBroadcasterId(String broadcasterId) {
        this.broadcasterId = broadcasterId;
    }

    public Datum withBroadcasterId(String broadcasterId) {
        this.broadcasterId = broadcasterId;
        return this;
    }

    /**
     * @return ID of the user who created the clip.
     */
    public String getCreatorId() {
        return creatorId;
    }

    private void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Datum withCreatorId(String creatorId) {
        this.creatorId = creatorId;
        return this;
    }

    /**
     * @return ID of the video from which the clip was created.
     */
    public String getVideoId() {
        return videoId;
    }

    private void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Datum withVideoId(String videoId) {
        this.videoId = videoId;
        return this;
    }

    /**
     * @return ID of the game assigned to the stream when the clip was created.
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
     * @return Language of the stream from which the clip was created.
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
     * @return Title of the clip.
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
     * @return Number of times the clip has been viewed.
     */
    public Integer getViewCount() {
        return viewCount;
    }

    private void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Datum withViewCount(Integer viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    /**
     * @return Date when the clip was created.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Datum withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * @return URL of the clip thumbnail.
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
        return new ToStringBuilder(this).append("id", id).append("url", url).append("embedUrl", embedUrl).append("broadcasterId", broadcasterId).append("creatorId", creatorId).append("videoId", videoId).append("gameId", gameId).append("language", language).append("title", title).append("viewCount", viewCount).append("createdAt", createdAt).append("thumbnailUrl", thumbnailUrl).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gameId).append(creatorId).append(embedUrl).append(url).append(id).append(title).append(createdAt).append(thumbnailUrl).append(videoId).append(broadcasterId).append(language).append(viewCount).toHashCode();
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
        return new EqualsBuilder().append(gameId, rhs.gameId).append(creatorId, rhs.creatorId).append(embedUrl, rhs.embedUrl).append(url, rhs.url).append(id, rhs.id).append(title, rhs.title).append(createdAt, rhs.createdAt).append(thumbnailUrl, rhs.thumbnailUrl).append(videoId, rhs.videoId).append(broadcasterId, rhs.broadcasterId).append(language, rhs.language).append(viewCount, rhs.viewCount).isEquals();
    }

}
