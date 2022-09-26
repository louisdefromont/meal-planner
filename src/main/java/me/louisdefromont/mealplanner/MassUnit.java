package me.louisdefromont.mealplanner;

import lombok.Getter;

@Getter
public enum MassUnit {
	GRAM("Gram", "g", 1.0),
	MICROGRAM("Microgram", "ug", Math.pow(10, -6)),
	MILLIGRAM("Milligram", "mg", Math.pow(10, -3)),
	OUNCE("Ounce", "oz", 28.349523125),
	POUND("Pound", "lb", 453.59237),
	KILLOGRAM("Killogram", "kg", 1000);

	private String name;
	private String symbol;
	private double factor;

	private MassUnit(String name, String symbol, double factor) {
		this.name = name;
		this.symbol = symbol;
		this.factor = factor;
	}

	public static MassUnit fromSymbol(String symbol) {
		for (MassUnit unit : MassUnit.values()) {
			if (unit.getSymbol().equals(symbol)) {
				return unit;
			}
		}
		return null;
	}
}
