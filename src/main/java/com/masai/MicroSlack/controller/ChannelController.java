package com.masai.MicroSlack.controller;

import com.masai.MicroSlack.entity.Channel;
import com.masai.MicroSlack.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/getAll")
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @GetMapping("get/{id}")
    public Optional<Channel> getChannelById(@PathVariable int id) {
        return channelService.getChannelById(id);
    }

    @PostMapping("/add")
    public void addChannel(@RequestBody Channel channel) {
        channelService.addChannel(channel);
    }

    @PutMapping("update/{id}")
    public void updateChannel(@PathVariable int id, @RequestBody Channel channel) {
        channel.setId(id);
        channelService.updateChannel(channel);
    }

    @DeleteMapping("delete/{id}")
    public void deleteChannel(@PathVariable int id) {
        channelService.deleteChannel(id);
    }
}
