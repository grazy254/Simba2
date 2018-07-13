package com.simba.gaode.model.autograsp;

/**
 * 道路信息
 * 
 * @author caozhejun
 *
 */
public class Road {

	/**
	 * 交叉点坐标 查询点与匹配道路的正切且最短距离匹配点
	 */
	private String crosspoint;

	/**
	 * 道路名称
	 */
	private String roadname;

	/**
	 * 道路经纬度坐标
	 */
	private String ployline;

	/**
	 * 道路等级 详细等级见下述道路等级分类
	 */
	private String roadlevel;

	/**
	 * 道路最高限速
	 */
	private String maxspeed;

	/**
	 * 临近路口
	 */
	private String intersection;

	/**
	 * 距离临近路口距离
	 */
	private String intersectiondistance;

	public String getCrosspoint() {
		return crosspoint;
	}

	public void setCrosspoint(String crosspoint) {
		this.crosspoint = crosspoint;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getPloyline() {
		return ployline;
	}

	public void setPloyline(String ployline) {
		this.ployline = ployline;
	}

	public String getRoadlevel() {
		return roadlevel;
	}

	public void setRoadlevel(String roadlevel) {
		this.roadlevel = roadlevel;
	}

	public String getMaxspeed() {
		return maxspeed;
	}

	public void setMaxspeed(String maxspeed) {
		this.maxspeed = maxspeed;
	}

	public String getIntersection() {
		return intersection;
	}

	public void setIntersection(String intersection) {
		this.intersection = intersection;
	}

	public String getIntersectiondistance() {
		return intersectiondistance;
	}

	public void setIntersectiondistance(String intersectiondistance) {
		this.intersectiondistance = intersectiondistance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Road [crosspoint=");
		builder.append(crosspoint);
		builder.append(", roadname=");
		builder.append(roadname);
		builder.append(", ployline=");
		builder.append(ployline);
		builder.append(", roadlevel=");
		builder.append(roadlevel);
		builder.append(", maxspeed=");
		builder.append(maxspeed);
		builder.append(", intersection=");
		builder.append(intersection);
		builder.append(", intersectiondistance=");
		builder.append(intersectiondistance);
		builder.append("]");
		return builder.toString();
	}

}
