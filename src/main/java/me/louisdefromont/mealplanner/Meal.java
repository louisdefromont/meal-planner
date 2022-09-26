package me.louisdefromont.mealplanner;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Meal {
	private Recipe recipe;
	private double quantity;

	public void increaseQuanity(double quantity) {
		this.quantity += quantity;
	}

	public List<Ingredient> getIngredients() {
		return recipe.getIngredients().stream().map(ingredient -> {
			Ingredient newIngredient = new Ingredient();
			newIngredient.setFoodItem(ingredient.getFoodItem());
			newIngredient.setQuantity((ingredient.getQuantity() / recipe.getServingsCount()) * quantity);
			return newIngredient;
		}).collect(Collectors.toList());
	}

	public double getCalories() {
		return (recipe.getCalories() / recipe.getServingsCount()) * quantity;
	}

	public List<NutritionalValue> getNutrientionalValues() {
		return recipe.getNutritionalValues().stream().map(nutritionalValue -> {
			NutritionalValue newNutritionalValue = new NutritionalValue();
			newNutritionalValue.setNutrient(nutritionalValue.getNutrient());
			newNutritionalValue.setValue((nutritionalValue.getValue() / recipe.getServingsCount()) * quantity);
			return newNutritionalValue;
		}).collect(Collectors.toList());
	}

	public double getPrice() {
		return (recipe.getPrice() / recipe.getServingsCount()) * quantity;
	}

	public Meal deepCopy() {
		Meal meal = new Meal(recipe, quantity);
		return meal;
	}
}
