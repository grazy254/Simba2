package com.simba.gaode.model.enums;

/**
 * 货车路径规划驾车选择策略
 * 
 * @author caozhejun
 *
 */
public enum TruckStrategy {

	ONE("1", "返回的结果考虑路况，尽量躲避拥堵而规划路径，与高德地图的“躲避拥堵”策略一致"),

	TWO("2", "返回的结果不走高速，与高德地图“不走高速”策略一致"),

	THREE("3", "返回的结果尽可能规划收费较低甚至免费的路径，与高德地图“避免收费”策略一致"),

	FOUR("4", "返回的结果考虑路况，尽量躲避拥堵而规划路径，并且不走高速，与高德地图的“躲避拥堵&不走高速”策略一致"),

	FIVE("5", "返回的结果尽量不走高速，并且尽量规划收费较低甚至免费的路径结果，与高德地图的“避免收费&不走高速”策略一致"),

	SIX("6", "返回路径规划结果会尽量的躲避拥堵，并且规划收费较低甚至免费的路径结果，与高德地图的“躲避拥堵&避免收费”策略一致"),

	SEVEN("7", "返回的结果尽量躲避拥堵，规划收费较低甚至免费的路径结果，并且尽量不走高速路，与高德地图的“避免拥堵&避免收费&不走高速”策略一致"),

	EIGHT("8", "返回的结果会优先选择高速路，与高德地图的“高速优先”策略一致"),

	NINE("9", "返回的结果会优先考虑高速路，并且会考虑路况躲避拥堵，与高德地图的“躲避拥堵&高速优先”策略一致");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private TruckStrategy(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
