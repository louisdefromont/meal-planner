package me.louisdefromont.mealplanner;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {
	boolean existsByName(String name);
	Optional<FoodItem> findByName(String name);
}
