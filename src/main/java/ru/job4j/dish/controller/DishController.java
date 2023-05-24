package ru.job4j.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dish")
@AllArgsConstructor
public class DishController {

    private final DishService service;

    @GetMapping("/")
    public List<Dish> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var person = service.findById(id);
        return new ResponseEntity<Dish>(
                person.orElse(new Dish()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        return new ResponseEntity<Dish>(
                service.save(dish),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        service.save(dish);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Dish dish = new Dish();
        dish.setId(id);
        service.delete(dish);
        return ResponseEntity.ok().build();
    }
}
