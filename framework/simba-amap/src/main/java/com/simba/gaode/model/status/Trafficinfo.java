package com.simba.gaode.model.status;

import java.util.List;

/**
 * 交通态势信息
 * 
 * @author caozhejun
 *
 */
public class Trafficinfo {

	/**
	 * 路况综述
	 */
	private String description;

	/**
	 * 路况评价
	 */
	private Evaluation evaluation;

	/**
	 * 此为road列表 其中包含道路信息
	 */
	private List<Road> roads;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trafficinfo [description=");
		builder.append(description);
		builder.append(", evaluation=");
		builder.append(evaluation);
		builder.append(", roads=");
		builder.append(roads);
		builder.append("]");
		return builder.toString();
	}

}
