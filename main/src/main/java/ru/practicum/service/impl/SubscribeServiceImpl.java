package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.dto.event.EventShortDto;
import ru.practicum.dto.user.UserShortDto;
import ru.practicum.entity.Subscribe;
import ru.practicum.entity.User;
import ru.practicum.exception.NotFoundException;
import ru.practicum.mapper.UserMapperStruct;
import ru.practicum.repository.EventRepository;
import ru.practicum.repository.SubscribeRepository;
import ru.practicum.repository.UserRepository;
import ru.practicum.service.SubscribeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscribeServiceImpl implements SubscribeService {
    private final SubscribeRepository subscribeRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final UserMapperStruct userMapper;

    @Override
    @Transactional
    public void createSubscribe(long followerUserId, long followedToUserId) {
        log.debug("Запрос на создание подписки пользователя id = {} на пользователя id = {}", followerUserId, followedToUserId);
        User follower = getUserOrElseThrow(followerUserId);
        User followedTo = getUserOrElseThrow(followedToUserId);
        Subscribe subscribe = new Subscribe(follower, followedTo);
        subscribeRepository.save(subscribe);
        log.info("Создана подписка пользователя id = {} на пользователя id = {}", followerUserId, followedToUserId);
    }

    @Override
    @Transactional
    public void deleteSubscribe(long followerUserId, long followedToUserId) {
        log.debug("Запрос на удаление подписки пользователя id = {} на пользователя id = {}", followerUserId, followedToUserId);
        subscribeRepository.deleteByFollower_IdIsAndFollowedTo_Id(followerUserId, followedToUserId);
        log.info("Удалена подписка пользователя id = {} на пользователя id = {}", followerUserId, followedToUserId);
    }

    @Override
    public List<UserShortDto> getSubscribes(long userId, int from, int size) {
        log.debug("Запрос на получение подписок пользователя id = {}", userId);
/*        List<Long> followedUsersIds = subscribeRepository.findSubscribesByFollower_IdIs(userId).stream()
                .map(subscribe -> subscribe.getFollowedTo().getId()).toList();*/
        List<Long> followedUsersIds = subscribeRepository.findFollowedUsersIds(userId);
        List<User> users = userRepository.findAllByIdIn(followedUsersIds, PageRequest.of(from / size, size));
        return users.stream().map(userMapper::toShortDto).toList();
    }

    @Override
    public List<EventShortDto> getEventsFeed(long userId) {
        log.debug("Запрос на получение ленты событий пользователя id = {}", userId);
        List<Long> followedUsersIds = subscribeRepository.findFollowedUsersIds(userId);
        return null;
    }

    private User getUserOrElseThrow(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь id = " + userId + " не существует"));
    }
}