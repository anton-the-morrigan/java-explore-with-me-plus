package ru.practicum.service.impl;

import org.springframework.stereotype.Service;
import ru.practicum.dto.event.EventShortDto;
import ru.practicum.dto.user.UserShortDto;
import ru.practicum.service.SubscribeService;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Override
    public void createSubscribe(long userId, long followedUserId) {

    }

    @Override
    public void deleteSubscribe(long userId, long followedUserId) {

    }

    @Override
    public List<UserShortDto> getSubscribes(long userId) {
        return null;
    }

    @Override
    public List<EventShortDto> getEventsFeed(long userId) {
        return null;
    }
}
