package me.louisdefromont.mealplanner;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;

@Getter
public class DailyMealPlan {

	private List<Meal> meals;

	public DailyMealPlan() {
		meals = new ArrayList<Meal>();
	}

	public void generate(List<Recipe> allRecipes) {
		while (getCalories() < 2000) {
			Recipe recipe = allRecipes.get((int) (Math.random() * allRecipes.size()));
			Optional<Meal> meal = getMeal(recipe);
			if (meal.isPresent()) {
				meal.get().increaseQuanity(1);
			} else {
				meals.add(new Meal(recipe, 1));
			}
		}
	}

	public Optional<Meal> getMeal(Recipe recipe) {
		return meals.stream().filter(meal -> meal.getRecipe().equals(recipe)).findFirst();
	}

	public double getCalories() {
		return meals.stream().mapToDouble(meal -> meal.getCalories()).sum();
	}

	public double getScore() {
		Map<Nutrient, Double> nutrients = new HashMap<Nutrient, Double>();
		Arrays.stream(Nutrient.values()).forEach(nutrient -> nutrients.put(nutrient, 0.0));
		nutrients.remove(Nutrient.WATER);
		meals.stream().forEach(meal -> {
			meal.getNutrientionalValues().stream().forEach(nutritionalValue -> {
				if (nutrients.containsKey(nutritionalValue.getNutrient())) {
					nutrients.put(nutritionalValue.getNutrient(), nutrients.get(nutritionalValue.getNutrient())
							+ nutritionalValue.getValue());
				}
			});
		});
		double score = 0.0;
		for (Nutrient nutrient : nutrients.keySet()) {
			score += Math.abs((nutrients.get(nutrient) - nutrient.getDailyValue()) / nutrient.getDailyValue());
		}
		return score;
	}

	public double getPrice() {
		return meals.stream().mapToDouble(meal -> meal.getPrice()).sum();
	}
}