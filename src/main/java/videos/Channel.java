package videos;

public class Channel {

    private String channelName;
    private int numberOfSubscriber;
    private int numberOfVideos;

    public Channel(String channelName, int numberOfSubscriber, int numberOfVideos) {
        this.channelName = channelName;
        this.numberOfSubscriber = numberOfSubscriber;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getNumberOfSubscriber() {
        return numberOfSubscriber;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}
