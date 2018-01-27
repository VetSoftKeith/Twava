package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("game_id")
    @Expose
    private String gameId;
    @SerializedName("overwatch")
    @Expose
    private Overwatch overwatch;
    @SerializedName("hearthstone")
    @Expose
    private Hearthstone hearthstone;

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

    public Overwatch getOverwatch() {
        return overwatch;
    }

    public void setOverwatch(Overwatch overwatch) {
        this.overwatch = overwatch;
    }

    public Datum withOverwatch(Overwatch overwatch) {
        this.overwatch = overwatch;
        return this;
    }

    public Hearthstone getHearthstone() {
        return hearthstone;
    }

    public void setHearthstone(Hearthstone hearthstone) {
        this.hearthstone = hearthstone;
    }

    public Datum withHearthstone(Hearthstone hearthstone) {
        this.hearthstone = hearthstone;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userId", userId).append("gameId", gameId).append("overwatch", overwatch).append("hearthstone", hearthstone).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hearthstone).append(gameId).append(userId).append(overwatch).toHashCode();
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
        return new EqualsBuilder().append(hearthstone, rhs.hearthstone).append(gameId, rhs.gameId).append(userId, rhs.userId).append(overwatch, rhs.overwatch).isEquals();
    }

}
