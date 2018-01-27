package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HearthstoneOpponentHero {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("class")
    @Expose
    private String heroClass;
    @SerializedName("name")
    @Expose
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HearthstoneOpponentHero withType(String type) {
        this.type = type;
        return this;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public HearthstoneOpponentHero withHeroClass(String heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HearthstoneOpponentHero withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("heroClass", heroClass).append("name", name).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(heroClass).append(name).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof HearthstoneOpponentHero)) {
            return false;
        }
        HearthstoneOpponentHero rhs = ((HearthstoneOpponentHero) other);
        return new EqualsBuilder().append(heroClass, rhs.heroClass).append(name, rhs.name).append(type, rhs.type).isEquals();
    }

}
