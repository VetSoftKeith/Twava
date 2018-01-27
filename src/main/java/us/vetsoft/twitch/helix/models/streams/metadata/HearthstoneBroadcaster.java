package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HearthstoneBroadcaster {

    @SerializedName("hero")
    @Expose
    private HearthstoneBroadcasterHero hero;

    public HearthstoneBroadcasterHero getHero() {
        return hero;
    }

    public void setHero(HearthstoneBroadcasterHero hero) {
        this.hero = hero;
    }

    public HearthstoneBroadcaster withHero(HearthstoneBroadcasterHero hero) {
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
        if (!(other instanceof HearthstoneBroadcaster)) {
            return false;
        }
        HearthstoneBroadcaster rhs = ((HearthstoneBroadcaster) other);
        return new EqualsBuilder().append(hero, rhs.hero).isEquals();
    }

}
