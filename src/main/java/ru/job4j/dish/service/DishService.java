package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.dish.domain.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository repository;

    public List<Dish> findAll() {
        return repository.findAll();
    }

    public Optional<Dish> findById(int id) {
        return repository.findById(id);
    }

    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    public boolean delete(Dish dish) {
        boolean result = false;
        if (findById(dish.getId()).isPresent()) {
            repository.delete(dish);
            result = true;
        }
        return result;
    }

    public boolean update(Dish dish) {
        boolean result = false;
        if (findById(dish.getId()).isPresent()) {
            repository.save(dish);
            result = true;
        }
        return result;
    }
}
