package us.vetsoft.twitch.helix.models.streams.metadata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OverwatchHero {

    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ability")
    @Expose
    private String ability;

    /**
     * @return Role of the Overwatch hero.
     */
    public String getRole() {
        return role;
    }

    private void setRole(String role) {
        this.role = role;
    }

    public OverwatchHero withRole(String role) {
        this.role = role;
        return this;
    }

    /**
     * @return Name of the Overwatch hero.
     */
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public OverwatchHero withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return Ability being used by the broadcaster.
     */
    public String getAbility() {
        return ability;
    }

    private void setAbility(String ability) {
        this.ability = ability;
    }

    public OverwatchHero withAbility(String ability) {
        this.ability = ability;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("role", role).append("name", name).append("ability", ability).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(role).append(ability).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof OverwatchHero)) {
            return false;
        }
        OverwatchHero rhs = ((OverwatchHero) other);
        return new EqualsBuilder().append(name, rhs.name).append(role, rhs.role).append(ability, rhs.ability).isEquals();
    }

}
