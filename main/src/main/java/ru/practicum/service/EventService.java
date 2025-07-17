package ru.practicum.service;

import org.springframework.stereotype.Service;
import ru.practicum.dto.event.EventFullDto;
import ru.practicum.dto.event.EventShortDto;
import ru.practicum.dto.event.UpdateEventAdminRequest;
import ru.practicum.params.EventAdminSearchParam;
import ru.practicum.params.PublicEventSearchParam;

import java.util.List;

@Service
public interface EventService {

    List<EventFullDto> getEventsByParams(EventAdminSearchParam param);

    EventFullDto updateEventByAdmin(Long eventId, UpdateEventAdminRequest updateRequest);

    List<EventShortDto> getEvents(PublicEventSearchParam param);

    EventFullDto getEventById(Long id);
}
