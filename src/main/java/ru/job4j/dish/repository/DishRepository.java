package ru.job4j.dish.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.dish.domain.Dish;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query("from Dish")
    List<Dish> findAll();
}
