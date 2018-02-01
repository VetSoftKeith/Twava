package us.vetsoft.twitch.helix.utilities;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class QueryString {
    private QueryStringBuilder qBuilder;
    private List<String> query;

    QueryString(QueryStringBuilder queryStringBuilder) {
        this.qBuilder = queryStringBuilder;
        this.query = populateQueryList();
    }

    public String build() {
        return this.query.stream().collect(Collectors.joining("&", "?", ""));
    }

    private List<String> populateQueryList() {
        List<String> queryList = new LinkedList<>();

        queryList.add("first=" + getFirst());
        if (!getAfter().isEmpty()) queryList.add("after=" + getAfter());
        if (!getBefore().isEmpty()) queryList.add("before=" + getBefore());
        if (!getType().isEmpty()) queryList.add("type=" + getType());
        if (!getFromId().isEmpty()) queryList.add("from_id=" + getFromId());
        if (!getToId().isEmpty()) queryList.add("to_id=" + getToId());
        if (!getId().isEmpty()) queryList.add("id=" + getId());
        if (!getBroadcasterId().isEmpty()) queryList.add("broadcaster_id=" + getBroadcasterId());
        if (!getManifestId().isEmpty()) {
            queryList.add("manifest_id=" + getManifestId());
            queryList.add("type=bulk_drops_grant");// TODO: Check to see if "type" was already set and if so replace it
        }

        // Filter out duplicate objects, NULL objects, empty objects for each Collection
        if (!getUserIds().isEmpty()) {
            queryList.add(
                    getUserIds().stream().distinct().filter(Objects::nonNull).filter((String userId) -> !userId.isEmpty())
                            .collect(Collectors.joining("&user_id", "user_id=", "")));
        }

        if (!getUserLogins().isEmpty()) {
            queryList.add(
                    getUserLogins().stream().distinct().filter(Objects::nonNull).filter((String userLogin) -> !userLogin.isEmpty())
                            .collect(Collectors.joining("&user_login", "user_login=", "")));
        }

        if (!getCommunityIds().isEmpty()) {
            queryList.add(
                    getCommunityIds().stream().distinct().filter(Objects::nonNull).filter((String communityId) -> !communityId.isEmpty())
                            .collect(Collectors.joining("&community_id", "community_id=", "")));
        }

        if (!getGameIds().isEmpty()) {
            queryList.add(
                    getGameIds().stream().distinct().filter(Objects::nonNull).filter((String gameId) -> !gameId.isEmpty())
                            .collect(Collectors.joining("&game_id", "game_id=", "")));
        }

        if (!getLanguage().isEmpty()) {
            queryList.add(
                    getLanguage().stream().distinct().filter(Objects::nonNull).filter((String lang) -> !lang.isEmpty())
                            .collect(Collectors.joining("&language", "language=", "")));
        }

        return queryList;
    }

    public String getId() {
        return qBuilder.id;
    }

    public String getManifestId() {
        return qBuilder.manifestId;
    }

    public String getAfter() {
        return qBuilder.after;
    }

    public String getBroadcasterId() {
        return qBuilder.bId;
    }

    public String getBefore() {
        return qBuilder.before;
    }

    public int getFirst() {
        return qBuilder.first;
    }

    public String getFromId() {
        return qBuilder.fromId;
    }

    public String getToId() {
        return qBuilder.toId;
    }

    public Collection<String> getUserIds() {
        return qBuilder.userIds;
    }

    private Collection<String> getUserLogins() {
        return qBuilder.userLogins;
    }

    public String getType() {
        return qBuilder.type;
    }

    private Collection<String> getCommunityIds() {
        return qBuilder.communityIds;
    }

    private Collection<String> getGameIds() {
        return qBuilder.gameIds;
    }

    private Collection<String> getLanguage() {
        return qBuilder.language;
    }
}
