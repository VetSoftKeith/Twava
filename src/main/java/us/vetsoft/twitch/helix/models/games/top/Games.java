package us.vetsoft.twitch.helix.models.games.top;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Games {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Games withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Games)) {
            return false;
        }
        Games rhs = ((Games) other);
        return new EqualsBuilder().append(data, rhs.data).isEquals();
    }

}
