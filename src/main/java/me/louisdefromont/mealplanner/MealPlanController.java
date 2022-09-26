package me.louisdefromont.mealplanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mealPlanner")
public class MealPlanController {
	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/generate")
	public DailyMealPlan generate(int iterations) {
		List<Recipe> allRecipes = IterableUtils.toList(recipeRepository.findAll());
		DailyMealPlan bestPlan = null;
		double bestPrice = 1000.0;
		double bestScore = 1000.0;
		for (int i = 0; i < iterations; i++) {
			DailyMealPlan plan = new DailyMealPlan();
			// plan.getMeals().add(new Meal(recipeRepository.findById(new Long(11)).get() , 1));
			plan.generate(allRecipes);
			if (plan.getScore() < 1000.0) {
				if (plan.getPrice() < 7.00) {
					if (plan.getScore() < bestScore) {
						bestPlan = plan;
						bestScore = plan.getScore();
					}
				}
			}
		}
		printDetails(bestPlan);
		return bestPlan;
	}

	private void printDetails(DailyMealPlan plan) {
		System.out.println("Score:" + plan.getScore());
		System.out.println("Calories:" + plan.getCalories());
		System.out.println("Price:" + plan.getPrice());
		Map<Nutrient, Double> nutrients = new HashMap<Nutrient, Double>();
		Arrays.stream(Nutrient.values()).forEach(nutrient -> nutrients.put(nutrient, 0.0));
		nutrients.remove(Nutrient.WATER);
		for (Meal meal : plan.getMeals()) {
			for (NutritionalValue nutritionalValue : meal.getNutrientionalValues()) {
				if (nutrients.containsKey(nutritionalValue.getNutrient())) {
					nutrients.put(nutritionalValue.getNutrient(), nutrients.get(nutritionalValue.getNutrient())
						+ nutritionalValue.getValue());
				}
			}
		}
		for (Nutrient nutrient : nutrients.keySet()) {
			System.out.println(nutrient + ":" + nutrients.get(nutrient) + " / " + nutrient.getDailyValue());
		}
		System.out.println("\n\n\n");
	}
}
