package me.louisdefromont.mealplanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;
	// Preperation time in minutes
	private int preparationTime;
	// Cooking time in minutes
	private int cookingTime;
	private int servingsCount;

	public double getCalories() {
		return ingredients.stream().mapToDouble(ingredient -> ingredient.getCalories()).sum();
	}

	public List<NutritionalValue> getNutritionalValues() {
		Map<Nutrient, Double> nutrients = new HashMap<>();
		Arrays.stream(Nutrient.values()).forEach(nutrient -> nutrients.put(nutrient, 0.0));
		for (Ingredient ingredient : getIngredients()) {
			for (NutritionalValue nutritionalValue : ingredient.getNutritionalValues()) {
				if (nutrients.containsKey(nutritionalValue.getNutrient())) {
					nutrients.put(nutritionalValue.getNutrient(), nutrients.get(nutritionalValue.getNutrient())
						+ nutritionalValue.getValue());
				}
			}
		}
		return nutrients.entrySet().stream().map(entry -> {
			NutritionalValue nutritionalValue = new NutritionalValue();
			nutritionalValue.setNutrient(entry.getKey());
			nutritionalValue.setValue(entry.getValue());
			return nutritionalValue;
		}).collect(Collectors.toList());
	}

	public double getPrice() {
		return ingredients.stream().mapToDouble(ingredient -> ingredient.getFoodItem().getPrice() * (ingredient.getQuantity() / 100)).sum();
	}
}
