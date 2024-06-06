package com.masai.MicroSlack.service;

import com.masai.MicroSlack.Dao.ChannelDao;
import com.masai.MicroSlack.entity.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChannelService {
    private final ChannelDao channelDAO;

    @Autowired
    public ChannelService(ChannelDao channelDAO) {
        this.channelDAO = channelDAO;
    }

    public List<Channel> getAllChannels() {
        return channelDAO.getAllChannels();
    }

    public Optional<Channel> getChannelById(int id) {
        return channelDAO.getChannelById(id);
    }

    public void addChannel(Channel channel) {
        channelDAO.addChannel(channel);
    }

    public void updateChannel(Channel channel) {
        channelDAO.updateChannel(channel);
    }

    public void deleteChannel(int id) {
        channelDAO.deleteChannel(id);
    }
}
