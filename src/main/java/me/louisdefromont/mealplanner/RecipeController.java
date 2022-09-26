package me.louisdefromont.mealplanner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/recipes")
public class RecipeController {
	@Autowired
	private RecipeRepository recipeRepository;

	@PostMapping("/add")
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@GetMapping("/find")
	public Optional<Recipe> find(String name) {
		return recipeRepository.findByName(name);
	}
}
