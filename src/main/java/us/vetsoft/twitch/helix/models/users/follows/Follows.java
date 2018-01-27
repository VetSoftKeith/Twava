package us.vetsoft.twitch.helix.models.users.follows;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Follows {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Follows withTotal(Integer total) {
        this.total = total;
        return this;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Follows withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Follows withPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("total", total).append("data", data)
                .append("pagination", pagination).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(data).append(pagination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Follows)) {
            return false;
        }
        Follows rhs = ((Follows) other);
        return new EqualsBuilder().append(total, rhs.total).append(data, rhs.data).append(pagination, rhs.pagination)
                .isEquals();
    }

}
