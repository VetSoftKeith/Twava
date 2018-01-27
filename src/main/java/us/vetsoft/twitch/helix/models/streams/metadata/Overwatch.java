package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Overwatch {

    @SerializedName("broadcaster")
    @Expose
    private OverwatchBroadcaster overwatchBroadcaster;

    public OverwatchBroadcaster getOverwatchBroadcaster() {
        return overwatchBroadcaster;
    }

    public void setOverwatchBroadcaster(OverwatchBroadcaster overwatchBroadcaster) {
        this.overwatchBroadcaster = overwatchBroadcaster;
    }

    public Overwatch withBroadcaster(OverwatchBroadcaster overwatchBroadcaster) {
        this.overwatchBroadcaster = overwatchBroadcaster;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("overwatchBroadcaster", overwatchBroadcaster).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(overwatchBroadcaster).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Overwatch)) {
            return false;
        }
        Overwatch rhs = ((Overwatch) other);
        return new EqualsBuilder().append(overwatchBroadcaster, rhs.overwatchBroadcaster).isEquals();
    }

}
