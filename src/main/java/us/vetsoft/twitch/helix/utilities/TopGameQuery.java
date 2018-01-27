package us.vetsoft.twitch.helix.utilities;

public class TopGameQuery {
    private String after = "";
    private String before = "";
    private int first = 20;

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

    public TopGameQuery build() {
        return this;
    }
}
