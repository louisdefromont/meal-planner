package me.louisdefromont.mealplanner;

import lombok.Getter;

@Getter
public enum Nutrient {
	VITAMIN_A("Vitamin A", MassUnit.MICROGRAM, 800.0),
	VITAMIN_B6("Vitamin B6", MassUnit.MILLIGRAM, 1.3),
	VITAMIN_B12("Vitamin B12", MassUnit.MICROGRAM, 2.4),
	VITAMIN_C("Vitamin C", MassUnit.MILLIGRAM, 90),
	VITAMIN_D("Vitamin D", MassUnit.MICROGRAM, 15),
	VITAMIN_D2("Vitamin D2", MassUnit.MICROGRAM, 50),
	VITAMIN_D3("Vitamin D3", MassUnit.MICROGRAM, 15),
	VITAMIN_D4("Vitamin D4", MassUnit.MICROGRAM, 15),
	VITAMIN_E("Vitamin E", MassUnit.MILLIGRAM, 15),
	VITAMIN_K("Vitamin K", MassUnit.MICROGRAM, 65),
	THIAMIN("Thiamin", MassUnit.MILLIGRAM, 1.2),
	RIBOFLAVIN("Riboflavin", MassUnit.MILLIGRAM, 1.3),
	NIACIN("NIACIN", MassUnit.MILLIGRAM, 16),
	PANTOTHENIC_ACids("PANTOTHENIC_ACids", MassUnit.MILLIGRAM, 5),
	FOLATE("FOLATE", MassUnit.MICROGRAM, 400),
	BIOTIN("BIOTIN", MassUnit.MICROGRAM, 50),
	CHOLINE("CHOLINE", MassUnit.MILLIGRAM, 550),
	MAGNESIUM("MAGNESIUM", MassUnit.MILLIGRAM, 410),
	CALCIUM("CALCIUM", MassUnit.MILLIGRAM, 1000),
	PHOSPHORUS("PHOSPHORUS", MassUnit.MILLIGRAM, 1000),
	SULFUR("SULFUR", MassUnit.MILLIGRAM, 400),
	SODIUM("SODIUM", MassUnit.MILLIGRAM, 1500),
	POTASSIUM("POTASSIUM", MassUnit.MILLIGRAM, 3500),
	IRON("IRON", MassUnit.MILLIGRAM, 20),
	SELENIUM("SELENIUM", MassUnit.MICROGRAM, 55),
	ZINC("ZINC", MassUnit.MILLIGRAM, 11),
	MANGANESE("MANGANESE", MassUnit.MILLIGRAM, 2.3),
	COPPER("COPPER", MassUnit.MILLIGRAM, 1.3),
	IODINE("IODINE", MassUnit.MICROGRAM, 150),
	MOLYBDENUM("MOLYBDENUM", MassUnit.MICROGRAM, 45),
	PROTEIN("PROTEIN", MassUnit.GRAM, 160),
	LIPIDS("Lipids", MassUnit.GRAM, 65),
	FAT("FAT", MassUnit.GRAM, 65),
	FATTY_ACidsS("FATTY_ACidsS", MassUnit.GRAM, 2),
	CARBOHYDRATE("CARBOHYDRATE", MassUnit.GRAM, 300),
	SUGARS("SUGARS", MassUnit.GRAM, 90),
	FIBERS_DIETARY("FIBERS_DIETARY", MassUnit.GRAM, 35),
	WATER("WATER", MassUnit.GRAM, 3700);

	private String name;
	private MassUnit massUnit;
	private double dailyValue;

	private Nutrient(String name, MassUnit massUnit, double dailyValue) {
		this.name = name;
		this.massUnit = massUnit;
		this.dailyValue = dailyValue;
	}
}
