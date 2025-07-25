package ru.practicum.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.practicum.entity.ParticipationRequest;
import ru.practicum.entity.RequestStatus;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {

    @Query("SELECT r.event.id, COUNT(r.id) " +
            "FROM ParticipationRequest r " +
            "WHERE r.event.id IN :eventIds AND r.status = :status " +
            "GROUP BY r.event.id")
    List<Object[]> countRequestsByStatus(@Param("eventIds") List<Long> eventIds,
                                         @Param("status") RequestStatus status);

    long countByEventIdAndStatus(Long eventId, RequestStatus status);

    @EntityGraph(attributePaths = {"requester", "event"})
    List<ParticipationRequest> findAllByRequesterId(Long userId);

    default Map<Long, Long> countRequestsByEventIdsAndStatus(List<Long> ids, RequestStatus status) {
        List<Object[]> result = countRequestsByStatus(ids, status);
        return result.stream()
                .collect(Collectors.toMap(
                        arr -> (Long) arr[0],
                        arr -> (Long) arr[1]
                ));
    }

    @EntityGraph(attributePaths = {"requester", "event"})
    List<ParticipationRequest> findAllByEventId(Long eventId);
}
