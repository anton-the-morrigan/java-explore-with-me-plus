package ru.practicum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "subscribes")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_user_id")
    private User follower;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_to_user_id")
    private User followedTo;

    public Subscribe(User follower, User followedTo) {
        this.follower = follower;
        this.followedTo = followedTo;
    }
}
