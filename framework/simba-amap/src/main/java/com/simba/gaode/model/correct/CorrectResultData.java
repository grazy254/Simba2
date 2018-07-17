package com.simba.gaode.model.correct;

import java.util.List;

public class CorrectResultData {

	private String distance;

	private List<CorrectPoint> points;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public List<CorrectPoint> getPoints() {
		return points;
	}

	public void setPoints(List<CorrectPoint> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrectResultData [distance=");
		builder.append(distance);
		builder.append(", points=");
		builder.append(points);
		builder.append("]");
		return builder.toString();
	}

}
