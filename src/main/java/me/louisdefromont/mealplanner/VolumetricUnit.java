package me.louisdefromont.mealplanner;

import lombok.Getter;

@Getter
public enum VolumetricUnit {
	CUBIC_CENTIMETER("Cubic centimeter", "cm3", 1.0),
	LITER("Liter", "l", 1000),
	MILLILITER("Milliliter", "ml", 0.001),
	CUP("Cup", "cup", 236.5882365),
	GALLON("Gallon", "gallon", 3785.411784),
	QUART("Quart", "quart", 946.352946),
	PINT("Pint", "pint", 473.176473),
	TABLESPOON("Tablespoon", "tbsp", 14.7867648),
	TEASPOON("Teaspoon", "tsp", 4.92892159);

	private String name;
	private String symbol;
	private double factor;

	private VolumetricUnit(String name, String symbol, double factor) {
		this.name = name;
		this.symbol = symbol;
		this.factor = factor;
	}

	public static VolumetricUnit fromSymbol(String symbol) {
		for (VolumetricUnit unit : VolumetricUnit.values()) {
			if (unit.getSymbol().equals(symbol)) {
				return unit;
			}
		}
		return null;
	}
}
