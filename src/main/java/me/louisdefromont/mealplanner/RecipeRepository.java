package me.louisdefromont.mealplanner;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	public Optional<Recipe> findByName(String name);
}
