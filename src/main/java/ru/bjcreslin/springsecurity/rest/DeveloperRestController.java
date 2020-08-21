package ru.bjcreslin.springsecurity.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bjcreslin.springsecurity.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestController {
    private final List<Developer> developers = Stream.of(
            new Developer(1L, "Ivan", "Ivanoff"),
            new Developer(2L, "Peter", "Petrov"),
            new Developer(3L, "Egor", "Egorov")
    ).collect(Collectors.toList());


    @GetMapping
    @PreAuthorize("hasAuthority('developers:read')")
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable("id") Long id) {
        return developers.stream().
                filter(developer -> developer.getId().equals(id)).
                findFirst().
                orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        this.developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void delete(@PathVariable("id") Long id) {
        this.developers.remove(
                developers.stream().
                        filter(developer -> developer.getId().equals(id)).
                        findFirst().
                        orElse(null));
    }

}
