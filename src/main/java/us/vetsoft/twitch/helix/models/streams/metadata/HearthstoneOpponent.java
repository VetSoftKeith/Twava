package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HearthstoneOpponent {

    @SerializedName("hero")
    @Expose
    private HearthstoneOpponentHero hero;

    public HearthstoneOpponentHero getHero() {
        return hero;
    }

    public void setHero(HearthstoneOpponentHero hero) {
        this.hero = hero;
    }

    public HearthstoneOpponent withHero(HearthstoneOpponentHero hero) {
        this.hero = hero;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("hero", hero).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hero).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof HearthstoneOpponent)) {
            return false;
        }
        HearthstoneOpponent rhs = ((HearthstoneOpponent) other);
        return new EqualsBuilder().append(hero, rhs.hero).isEquals();
    }

}
