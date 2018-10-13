package com.simba.gaode.model.correct;

/**
 * 轨迹数据
 * 
 * @author caozhejun
 *
 */
public class CorrectData {

	/**
	 * 经度
	 * 
	 * 小数点后最多6位
	 */
	private double x;

	/**
	 * 维度
	 * 
	 * 小数点后最多6位
	 */
	private double y;

	/**
	 * 角度
	 * 
	 * 与正北方向的夹角,小数、整数均可
	 * 
	 * 若无法确认的时候，请填入0
	 */
	private double ag;

	/**
	 * 时间
	 * 
	 * 1970年到当前的秒数
	 * 
	 * 第一个tm为unix时间戳；从第二个tm开始，tm取值为相对于前一个tm的时间增量
	 */
	private long tm;

	/**
	 * 速度
	 * 
	 * 单位：km/h ,小数、整数均可 若无法确认的时候，请填入0
	 */
	private int sp;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAg() {
		return ag;
	}

	public void setAg(double ag) {
		this.ag = ag;
	}

	public long getTm() {
		return tm;
	}

	public void setTm(long tm) {
		this.tm = tm;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrectData [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", ag=");
		builder.append(ag);
		builder.append(", tm=");
		builder.append(tm);
		builder.append(", sp=");
		builder.append(sp);
		builder.append("]");
		return builder.toString();
	}

}
