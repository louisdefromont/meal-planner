package me.louisdefromont.mealplanner;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private FoodItem foodItem;
	private double quantity;

	public double getCalories() {
		return (quantity / 100.0) * foodItem.getCalories();
	}

	public List<NutritionalValue> getNutritionalValues() {
		return foodItem.getNutritionalValues().stream().map(nutritionalValue -> {
			NutritionalValue newNutritionalValue = new NutritionalValue();
			newNutritionalValue.setNutrient(nutritionalValue.getNutrient());
			newNutritionalValue.setValue(nutritionalValue.getValue() * (quantity / 100.0));
			return newNutritionalValue;
		}).collect(Collectors.toList());
	}
}
