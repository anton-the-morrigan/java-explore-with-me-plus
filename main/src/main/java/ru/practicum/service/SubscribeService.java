package ru.practicum.service;

import ru.practicum.dto.event.EventShortDto;
import ru.practicum.dto.user.UserShortDto;

import java.util.List;

public interface SubscribeService {
    void createSubscribe(long userId, long followedUserId);

    void deleteSubscribe(long userId, long followedUserId);

    List<UserShortDto> getSubscribes(long userId);

    List<EventShortDto> getEventsFeed(long userId);
}
