package com.react.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private String title;
    private String description;

    @OneToMany
    private Set<User> attendees;
}
