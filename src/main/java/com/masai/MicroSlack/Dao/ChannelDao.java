package com.masai.MicroSlack.Dao;

import com.masai.MicroSlack.entity.Channel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChannelDao {
    private List<Channel> channels = new ArrayList<>();

    @PostConstruct
    public void init() {
        channels.add(new Channel(1, "Placements"));
        channels.add(new Channel(2, "Crash course"));
    }

    public List<Channel> getAllChannels() {
        return channels;
    }

    public Optional<Channel> getChannelById(int id) {
        return channels.stream().filter(channel -> channel.getId() == id).findFirst();
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void updateChannel(Channel channel) {
        channels.stream()
                .filter(c -> c.getId() == channel.getId())
                .findFirst()
                .ifPresent(c -> {
                    c.setName(channel.getName());
                });
    }

    public void deleteChannel(int id) {
        channels.removeIf(channel -> channel.getId() == id);
    }
}
