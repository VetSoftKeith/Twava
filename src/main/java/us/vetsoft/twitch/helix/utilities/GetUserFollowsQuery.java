package us.vetsoft.twitch.helix.utilities;

public class GetUserFollowsQuery {
    private int first = 20;
    private String after = "";
    private String before = "";
    private String fromId = "";
    private String toId = "";

    private String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    private String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    private int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    private String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    private String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public GetUserFollowsQuery build() {
        return this;
    }
}
