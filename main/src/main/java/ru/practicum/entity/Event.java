package ru.practicum.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String annotation;

    private String description;

    @Enumerated(EnumType.STRING)
    private EventState state;

    private LocalDateTime eventDate;

    @CreationTimestamp
    private LocalDateTime createdOn;

    private LocalDateTime publishedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiator_id", nullable = false)
    private User initiator;

    private Boolean paid;

    private Boolean requestModeration;

    private Integer participantLimit;

    @Embedded
    private Location location;
}


