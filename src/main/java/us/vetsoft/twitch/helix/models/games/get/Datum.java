package us.vetsoft.twitch.helix.models.games.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("box_art_url")
    @Expose
    private String boxArtUrl;

    /**
     * @return Game ID.
     */
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public Datum withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return Game name.
     */
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return Template URL for the game’s box art.
     */
    public String getBoxArtUrl() {
        return boxArtUrl;
    }

    private void setBoxArtUrl(String boxArtUrl) {
        this.boxArtUrl = boxArtUrl;
    }

    public Datum withBoxArtUrl(String boxArtUrl) {
        this.boxArtUrl = boxArtUrl;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("boxArtUrl", boxArtUrl).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(boxArtUrl).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(boxArtUrl, rhs.boxArtUrl).isEquals();
    }

}
