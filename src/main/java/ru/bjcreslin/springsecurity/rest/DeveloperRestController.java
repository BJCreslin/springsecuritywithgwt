package ru.bjcreslin.springsecurity.rest;

import org.springframework.web.bind.annotation.*;
import ru.bjcreslin.springsecurity.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestController {
    private List<Developer> developers = Stream.of(
            new Developer(1L, "Ivan", "Ivanoff"),
            new Developer(2L, "Peter", "Petrov"),
            new Developer(3L, "Egor", "Egorov")
    ).collect(Collectors.toList());


    @GetMapping
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id) {
        return developers.stream().
                filter(developer -> developer.getId().equals(id)).
                findFirst().
                orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        this.developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.developers.remove(
                developers.stream().
                        filter(developer -> developer.getId().equals(id)).
                        findFirst().
                        orElse(null));
    }

}
