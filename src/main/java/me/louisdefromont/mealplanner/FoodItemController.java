package me.louisdefromont.mealplanner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodItems")
public class FoodItemController {
	@Autowired
	private FoodItemRepository foodItemRepository;

	@PostMapping("/add")
	public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
		if (foodItem.getCalories() == 0) {
			double carbs = 0;
			double protein = 0;
			double fat = 0;
			for (NutritionalValue nutritionalValue : foodItem.getNutritionalValues()) {
				if (nutritionalValue.getNutrient() == Nutrient.CARBOHYDRATE) {
					carbs = nutritionalValue.getValue();
				} else if (nutritionalValue.getNutrient() == Nutrient.PROTEIN) {
					protein = nutritionalValue.getValue();
				} else if (nutritionalValue.getNutrient() == Nutrient.FAT) {
					fat = nutritionalValue.getValue();
				}
			}
			foodItem.setCalories(Math.round((carbs * 4) + (protein * 4) + (fat * 9)));
		}
		return foodItemRepository.save(foodItem);
	}

	@GetMapping("/exists")
	public boolean exists(String name) {
		return foodItemRepository.existsByName(name);
	}

	@GetMapping("/find")
	public Optional<FoodItem> find(String name) {
		return foodItemRepository.findByName(name);
	}

	@PutMapping("/update")
	public FoodItem updateFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemRepository.save(foodItem);
	}

}
