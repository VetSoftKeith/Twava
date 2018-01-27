package us.vetsoft.twitch.helix.models.users.follows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("from_id")
    @Expose
    private String fromId;
    @SerializedName("to_id")
    @Expose
    private String toId;
    @SerializedName("followed_at")
    @Expose
    private String followedAt;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public Datum withFromId(String fromId) {
        this.fromId = fromId;
        return this;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public Datum withToId(String toId) {
        this.toId = toId;
        return this;
    }

    public String getFollowedAt() {
        return followedAt;
    }

    public void setFollowedAt(String followedAt) {
        this.followedAt = followedAt;
    }

    public Datum withFollowedAt(String followedAt) {
        this.followedAt = followedAt;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fromId", fromId).append("toId", toId)
                .append("followedAt", followedAt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fromId).append(toId).append(followedAt).toHashCode();
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
        return new EqualsBuilder().append(fromId, rhs.fromId).append(toId, rhs.toId).append(followedAt, rhs.followedAt).isEquals();
    }

}
