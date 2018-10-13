package com.simba.gaode.model.keywords;

import java.util.List;

/**
 * POI信息
 * 
 * @author caozhejun
 *
 */
public class POI {

	/**
	 * 唯一ID
	 */
	private String id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 兴趣点类型 顺序为大类、中类、小类 例如：餐饮服务;中餐厅;特色/地方风味餐厅
	 */
	private String type;

	/**
	 * 兴趣点类型编码 例如：050118
	 */
	private String typecode;

	/**
	 * 行业类型
	 */
	private String biz_type;

	/**
	 * 地址 东四环中路189号百盛北门
	 */
	private String address;

	/**
	 * 经纬度 格式：X,Y
	 */
	private String location;

	/**
	 * 离中心点距离 单位：米 必须说明， 此结果仅在周边搜索的时候有值
	 */
	private String distance;

	/**
	 * 该POI的电话
	 */
	private String tel;

	/**
	 * 邮编 extensions=all的时候显示
	 */
	private String postcode;

	/**
	 * 该POI的网址 extensions=all的时候显示
	 */
	private String website;

	/**
	 * 该POI的电子邮箱 extensions=all的时候显示
	 */
	private String email;

	/**
	 * poi所在省份编码 extensions=all的时候显示
	 */
	private String pcode;

	/**
	 * poi所在省份名称 若是直辖市的时候，此处直接显示市名，例如北京市
	 */
	private String pname;

	/**
	 * 城市编码 extensions=all的时候显示
	 */
	private String citycode;

	/**
	 * 城市名 若是直辖市的时候，此处直接显示市名，例如北京市
	 */
	private String cityname;

	/**
	 * 区域编码 extensions=all的时候显示
	 */
	private String adcode;

	/**
	 * 区域名称 区县级别的返回，例如朝阳区
	 */
	private String adname;

	/**
	 * 入口经纬度 extensions=all的时候显示
	 */
	private String entr_location;

	/**
	 * 出口经纬度 extensions=all的时候显示
	 */
	private String exit_location;

	/**
	 * 地图编号 extensions=all的时候显示
	 */
	private String navi_poiid;

	/**
	 * 地理格ID extensions=all的时候显示
	 */
	private String gridcode;

	/**
	 * 别名 extensions=all的时候显示
	 */
	private String alias;

	/**
	 * 所在商圈 extensions=all的时候显示
	 */
	private String business_area;

	/**
	 * 停车场类型 仅在停车场类型POI的时候显示该字段 展示停车场类型，包括：地下、地面、路边 extensions=all的时候显示
	 */
	private String parking_type;

	/**
	 * 该POI的特色内容 主要出现在POI为美食类的POI之中出现，此时代表特色菜 例如“烤鱼,麻辣香锅,老干妈回锅肉”
	 * 
	 * 在其余POI类别的时候，会有小概率出现，此时代表此POI的特色内容 例如北京-第五季花艺 之中的“岁月静好,定情,如意花卡,圣诞之爱”
	 * 
	 * 仅在extensions=all
	 */
	private String tag;

	/**
	 * 是否有室内地图标志 1，表示有室内相关数据 0，代表没有室内相关数据 extensions=all的时候显示
	 */
	private String indoor_map;

	/**
	 * 室内地图相关数据 当indoor_map=0时，字段为空 extensions=all的时候显示
	 */
	private IndoorData indoor_data;

	/**
	 * 团购数据 此字段逐渐废弃
	 */
	private String groupbuy_num;

	/**
	 * 优惠信息数目 此字段逐渐废弃
	 */
	private String discount_num;

	/**
	 * 深度信息 extensions=all的时候显示
	 */
	private BizExt biz_ext;

	/**
	 * 照片相关信息 extensions=all的时候显示
	 */
	private List<Photo> photos;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getBiz_type() {
		return biz_type;
	}

	public void setBiz_type(String biz_type) {
		this.biz_type = biz_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getEntr_location() {
		return entr_location;
	}

	public void setEntr_location(String entr_location) {
		this.entr_location = entr_location;
	}

	public String getExit_location() {
		return exit_location;
	}

	public void setExit_location(String exit_location) {
		this.exit_location = exit_location;
	}

	public String getNavi_poiid() {
		return navi_poiid;
	}

	public void setNavi_poiid(String navi_poiid) {
		this.navi_poiid = navi_poiid;
	}

	public String getGridcode() {
		return gridcode;
	}

	public void setGridcode(String gridcode) {
		this.gridcode = gridcode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getBusiness_area() {
		return business_area;
	}

	public void setBusiness_area(String business_area) {
		this.business_area = business_area;
	}

	public String getParking_type() {
		return parking_type;
	}

	public void setParking_type(String parking_type) {
		this.parking_type = parking_type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getIndoor_map() {
		return indoor_map;
	}

	public void setIndoor_map(String indoor_map) {
		this.indoor_map = indoor_map;
	}

	public IndoorData getIndoor_data() {
		return indoor_data;
	}

	public void setIndoor_data(IndoorData indoor_data) {
		this.indoor_data = indoor_data;
	}

	public String getGroupbuy_num() {
		return groupbuy_num;
	}

	public void setGroupbuy_num(String groupbuy_num) {
		this.groupbuy_num = groupbuy_num;
	}

	public String getDiscount_num() {
		return discount_num;
	}

	public void setDiscount_num(String discount_num) {
		this.discount_num = discount_num;
	}

	public BizExt getBiz_ext() {
		return biz_ext;
	}

	public void setBiz_ext(BizExt biz_ext) {
		this.biz_ext = biz_ext;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("POI [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", typecode=");
		builder.append(typecode);
		builder.append(", biz_type=");
		builder.append(biz_type);
		builder.append(", address=");
		builder.append(address);
		builder.append(", location=");
		builder.append(location);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", postcode=");
		builder.append(postcode);
		builder.append(", website=");
		builder.append(website);
		builder.append(", email=");
		builder.append(email);
		builder.append(", pcode=");
		builder.append(pcode);
		builder.append(", pname=");
		builder.append(pname);
		builder.append(", citycode=");
		builder.append(citycode);
		builder.append(", cityname=");
		builder.append(cityname);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", adname=");
		builder.append(adname);
		builder.append(", entr_location=");
		builder.append(entr_location);
		builder.append(", exit_location=");
		builder.append(exit_location);
		builder.append(", navi_poiid=");
		builder.append(navi_poiid);
		builder.append(", gridcode=");
		builder.append(gridcode);
		builder.append(", alias=");
		builder.append(alias);
		builder.append(", business_area=");
		builder.append(business_area);
		builder.append(", parking_type=");
		builder.append(parking_type);
		builder.append(", tag=");
		builder.append(tag);
		builder.append(", indoor_map=");
		builder.append(indoor_map);
		builder.append(", indoor_data=");
		builder.append(indoor_data);
		builder.append(", groupbuy_num=");
		builder.append(groupbuy_num);
		builder.append(", discount_num=");
		builder.append(discount_num);
		builder.append(", biz_ext=");
		builder.append(biz_ext);
		builder.append(", photos=");
		builder.append(photos);
		builder.append("]");
		return builder.toString();
	}

}
