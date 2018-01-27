package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Metadata {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Metadata withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Metadata withPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).append("pagination", pagination).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).append(pagination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata rhs = ((Metadata) other);
        return new EqualsBuilder().append(data, rhs.data).append(pagination, rhs.pagination).isEquals();
    }

}
