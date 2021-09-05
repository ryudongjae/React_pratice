package com.react.spring.controller;

import com.react.spring.domain.Group;
import com.react.spring.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class GroupController {

    private final GroupRepository groupRepository;

    @GetMapping("/groups")
    public Collection<Group> groups(){
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?>getGroup(@PathVariable Long id){
        Optional<Group>group = groupRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    public ResponseEntity<Group>createGroup(@Valid@RequestBody Group group) throws URISyntaxException {
        log.info("request to create group: {}",group);
        Group value = groupRepository.save(group);
        return ResponseEntity.created(new URI("/api/group/"+ value.getId()))
                .body(value);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<Group> updateGroup(@Valid@RequestBody Group group){
        log.info("request to update group: {}",group);
        Group value = groupRepository.save(group);
        return ResponseEntity.ok().body(value);
    }
    @DeleteMapping("/group/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id){
        log.info("request to delete group: {}",id);
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
