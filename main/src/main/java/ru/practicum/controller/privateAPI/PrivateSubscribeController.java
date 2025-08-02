package ru.practicum.controller.privateAPI;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createSubscribe(@PathVariable @Positive long userId,
                                @RequestParam @Positive long followedToUserId) {
        subscribeService.createSubscribe(userId, followedToUserId);
    }

    @DeleteMapping("/{userId}/subscribes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscribe(@PathVariable @Positive long userId,
                                @RequestParam @Positive long followedToUserId) {
        subscribeService.deleteSubscribe(userId, followedToUserId);
    }

    @GetMapping("/{userId}/subscribes")
    public List<UserShortDto> getSubscribes(@PathVariable @Positive long userId,
                                            @RequestParam(defaultValue = "0") Integer from,
                                            @RequestParam(defaultValue = "10") Integer size) {
        return subscribeService.getSubscribes(userId, from, size);
    }

    @GetMapping("/{userId}/events/feed")
    public List<EventShortDto> getEventsFeed(@PathVariable @Positive long userId) {
        return subscribeService.getEventsFeed(userId);
    }
}
