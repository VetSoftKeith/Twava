package us.vetsoft.twitch.helix.models.users.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("broadcaster_type")
    @Expose
    private String broadcasterType;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("offline_image_url")
    @Expose
    private String offlineImageUrl;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("email")
    @Expose
    private String email = null;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Datum withLogin(String login) {
        this.login = login;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Datum withDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getBroadcasterType() {
        return broadcasterType;
    }

    public void setBroadcasterType(String broadcasterType) {
        this.broadcasterType = broadcasterType;
    }

    public Datum withBroadcasterType(String broadcasterType) {
        this.broadcasterType = broadcasterType;
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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Datum withProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
        return this;
    }

    public String getOfflineImageUrl() {
        return offlineImageUrl;
    }

    public void setOfflineImageUrl(String offlineImageUrl) {
        this.offlineImageUrl = offlineImageUrl;
    }

    public Datum withOfflineImageUrl(String offlineImageUrl) {
        this.offlineImageUrl = offlineImageUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Datum withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("login", login)
                .append("displayName", displayName)
                .append("type", type)
                .append("broadcasterType", broadcasterType)
                .append("description", description)
                .append("profileImageUrl", profileImageUrl)
                .append("offlineImageUrl", offlineImageUrl)
                .append("viewCount", viewCount)
                .append("email", email)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(broadcasterType)
                .append(email)
                .append(description)
                .append(offlineImageUrl)
                .append(profileImageUrl)
                .append(login)
                .append(type)
                .append(displayName)
                .append(viewCount)
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
                .append(broadcasterType, rhs.broadcasterType)
                .append(email, rhs.email)
                .append(description, rhs.description)
                .append(offlineImageUrl, rhs.offlineImageUrl)
                .append(profileImageUrl, rhs.profileImageUrl)
                .append(login, rhs.login)
                .append(type, rhs.type)
                .append(displayName, rhs.displayName)
                .append(viewCount, rhs.viewCount)
                .isEquals();
    }

}
