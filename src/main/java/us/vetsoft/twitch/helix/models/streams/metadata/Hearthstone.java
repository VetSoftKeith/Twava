package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hearthstone {

    @SerializedName("broadcaster")
    @Expose
    private HearthstoneBroadcaster broadcaster;
    @SerializedName("opponent")
    @Expose
    private HearthstoneOpponent hearthstoneOpponent;

    public HearthstoneBroadcaster getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(HearthstoneBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }

    public Hearthstone withBroadcaster(HearthstoneBroadcaster broadcaster) {
        this.broadcaster = broadcaster;
        return this;
    }

    public HearthstoneOpponent getOpponent() {
        return hearthstoneOpponent;
    }

    public void setOpponent(HearthstoneOpponent hearthstoneOpponent) {
        this.hearthstoneOpponent = hearthstoneOpponent;
    }

    public Hearthstone withOpponent(HearthstoneOpponent hearthstoneOpponent) {
        this.hearthstoneOpponent = hearthstoneOpponent;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("broadcaster", broadcaster).append("hearthstoneOpponent", hearthstoneOpponent).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hearthstoneOpponent).append(broadcaster).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Hearthstone)) {
            return false;
        }
        Hearthstone rhs = ((Hearthstone) other);
        return new EqualsBuilder().append(hearthstoneOpponent, rhs.hearthstoneOpponent).append(broadcaster, rhs.broadcaster).isEquals();
    }

}
