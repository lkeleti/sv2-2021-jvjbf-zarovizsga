package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return new ArrayList<>(channels);
    }

    public void readDataFromFile(Path path) {
        try (
            BufferedReader br = Files.newBufferedReader(path);
        ) {
            String line = br.readLine();
            while ((line = br.readLine())!= null) {
                String[] channelDatas = line.split(";");
                channels.add(
                        new Channel(channelDatas[0], Integer.parseInt(channelDatas[1]), Integer.parseInt(channelDatas[2]))
                );
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public long calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos).sum();
    }
}
