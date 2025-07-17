package ru.practicum.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.dto.event.*;
import ru.practicum.params.EventAdminSearchParam;
import ru.practicum.params.EventUserSearchParam;
import ru.practicum.params.PublicEventSearchParam;
import ru.practicum.service.EventService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    @Override
    public List<EventFullDto> getEventsByParams(EventAdminSearchParam param) {
        log.info("Get events by params: {}", param);
        // todo
        return List.of();
    }

    @Override
    public EventFullDto updateEventByAdmin(Long eventId, UpdateEventAdminRequest updateRequest) {
        log.info("Update event: {}", updateRequest);
        // todo
        return null;
    }

    @Override
    public EventFullDto getEventById(Long id) {
        log.info("Get event: {}", id);
        // todo
        return null;
    }

    @Override
    public List<EventShortDto> searchEvents(PublicEventSearchParam param) {
        // todo
        return List.of();
    }

    @Override
    public List<EventShortDto> getUsersEvents(EventUserSearchParam param) {
        log.info("Get users events: {}", param);
        // todo
        return List.of();
    }

    @Override
    public EventFullDto saveEvent(NewEventDto dto, Long userId) {
        log.info("Save event: {}", dto);
        // todo
        return null;
    }

    @Override
    public EventFullDto getEventByIdAndUserId(Long userId, Long eventId) {
        log.info("Get event: {}", eventId);
        // todo
        return null;
    }

    @Override
    public EventFullDto updateEventByUser(Long userId, Long eventId, UpdateEventUserRequest updateRequest) {
        log.info("Update event: {}", updateRequest);
        // todo
        return null;
    }
}
