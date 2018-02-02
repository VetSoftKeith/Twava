package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Pagination {

    @SerializedName("cursor")
    @Expose
    private String cursor;

    /**
     * @return Pagination cursor
     */
    public String getCursor() {
        return cursor;
    }

    private void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public Pagination withCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cursor", cursor).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cursor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pagination)) {
            return false;
        }
        Pagination rhs = ((Pagination) other);
        return new EqualsBuilder().append(cursor, rhs.cursor).isEquals();
    }

}
