package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OverwatchBroadcaster {

    @SerializedName("hero")
    @Expose
    private OverwatchHero overwatchHero;

    /**
     * @return Metadata about the Overwatch hero selected by the broadcaster. null if empty.
     */
    public OverwatchHero getHero() {
        return overwatchHero;
    }

    public void setHero(OverwatchHero overwatchHero) {
        this.overwatchHero = overwatchHero;
    }

    public OverwatchBroadcaster withHero(OverwatchHero overwatchHero) {
        this.overwatchHero = overwatchHero;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("overwatchHero", overwatchHero).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(overwatchHero).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof OverwatchBroadcaster)) {
            return false;
        }
        OverwatchBroadcaster rhs = ((OverwatchBroadcaster) other);
        return new EqualsBuilder().append(overwatchHero, rhs.overwatchHero).isEquals();
    }

}
