package us.vetsoft.twitch.helix.models.clips.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("edit_url")
    @Expose
    private String editUrl;

    /**
     * @return ID of the clip that was created.
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
     * @return URL of the edit page for the clip.
     */
    public String getEditUrl() {
        return editUrl;
    }

    private void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public Datum withEditUrl(String editUrl) {
        this.editUrl = editUrl;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("editUrl", editUrl).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(editUrl).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(editUrl, rhs.editUrl).isEquals();
    }

}
