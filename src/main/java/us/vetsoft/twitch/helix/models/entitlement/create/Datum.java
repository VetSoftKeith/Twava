package us.vetsoft.twitch.helix.models.entitlement.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Datum {

    @SerializedName("url")
    @Expose
    private String url;

    /**
     * <b>Note:</b> You must replace all occurrences of <code>\\u0026</code> with an ampersand (<code>&amp;</code>)
     * character. See the Drops Guide.
     *
     * @return The URL where you will upload the manifest file. This is the URL of a pre-signed S3 bucket. Lease time:
     * 15 minutes.
     */
    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public Datum withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(url).toHashCode();
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
        return new EqualsBuilder().append(url, rhs.url).isEquals();
    }

}
