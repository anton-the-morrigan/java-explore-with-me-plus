package ru.practicum.controller.privateAPI;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.event.EventShortDto;
import ru.practicum.dto.user.UserShortDto;
import ru.practicum.service.SubscribeService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PrivateSubscribeController {
    private final SubscribeService subscribeService;

    @PutMapping("/{userId}/subscribes")
    public void createSubscribe(@PathVariable @Positive long userId,
                                @RequestParam @Positive long followedUserId) {
        subscribeService.createSubscribe(userId, followedUserId);
    }

    @DeleteMapping("/{userId}/subscribes")
    public void deleteSubscribe(@PathVariable @Positive long userId,
                                @RequestParam @Positive long followedUserId) {
        subscribeService.deleteSubscribe(userId, followedUserId);
    }

    @GetMapping("/{userId}/subscribes")
    public List<UserShortDto> getSubscribes(@PathVariable @Positive long userId) {
        return subscribeService.getSubscribes(userId);
    }

    @GetMapping("/{userId}/events/feed")
    public List<EventShortDto> getEventsFeed(@PathVariable @Positive long userId) {
        return subscribeService.getEventsFeed(userId);
    }
}
