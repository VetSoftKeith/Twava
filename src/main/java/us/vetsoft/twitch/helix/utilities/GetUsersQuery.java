package us.vetsoft.twitch.helix.utilities;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetUsersQuery {
    private Collection<String> userIds = new CopyOnWriteArrayList<>();
    private Collection<String> userLogins = new CopyOnWriteArrayList<>();

    private Collection<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(Collection<String> userIds) {
        if (!getUserLogins().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userIds.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userIds = userIds;
    }

    private Collection<String> getUserLogins() {
        return userLogins;
    }

    public void setUserLogins(Collection<String> userLogins) {
        if (!getUserIds().isEmpty())
            throw new IllegalStateException(Msg.MULTIPLE_COLLECTION_EXCEPTION.token());

        if (userLogins.size() > 100)
            throw new IllegalStateException(Msg.MAXIMUM_SIZE_EXCEPTION.token());

        this.userLogins = userLogins;
    }

    public GetUsersQuery build() {
        return this;
    }
}
