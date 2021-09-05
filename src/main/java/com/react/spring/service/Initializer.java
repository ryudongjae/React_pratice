package com.react.spring.service;

import com.react.spring.domain.Event;
import com.react.spring.domain.Group;
import com.react.spring.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final GroupRepository groupRepository;

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Study1", "Study2", "Study3",
                "Study4").forEach(name -> groupRepository.save(new Group(name)));

        Group djug = groupRepository.findByName("Study1");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.now())
                .build();
        djug.setEvents(Collections.singleton(e));
        groupRepository.save(djug);

        groupRepository.findAll().forEach(System.out::println);
    }
}
