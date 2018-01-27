package us.vetsoft.twitch.helix.models.videos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("duration")
    @Expose
    private String duration;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Datum withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Datum withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Datum withPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Datum withViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Datum withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("userId", userId)
                .append("title", title).append("description", description)
                .append("createdAt", createdAt).append("publishedAt", publishedAt)
                .append("thumbnailUrl", thumbnailUrl).append("viewCount", viewCount)
                .append("language", language).append("duration", duration).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(publishedAt).append(id).append(duration).append(title).append(createdAt)
                .append(description).append(thumbnailUrl).append(userId).append(language).append(viewCount).toHashCode();
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
        return new EqualsBuilder().append(publishedAt, rhs.publishedAt).append(id, rhs.id).append(duration, rhs.duration)
                .append(title, rhs.title).append(createdAt, rhs.createdAt).append(description, rhs.description)
                .append(thumbnailUrl, rhs.thumbnailUrl).append(userId, rhs.userId).append(language, rhs.language)
                .append(viewCount, rhs.viewCount).isEquals();
    }

}
