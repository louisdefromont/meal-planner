package me.louisdefromont.mealplanner;

import java.util.List;

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
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double servingSize;
	private double calories;
	private double price;
	private double density;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = NutritionalValue.class)
	private List<NutritionalValue> nutritionalValues;
}
