/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 车辆管理Entity
 * @author 77jubao
 * @version 2015-08-12
 */
public class OaCar extends DataEntity<OaCar> {
	
	private static final long serialVersionUID = 1L;
	private String carNumber;		// 车牌号码
	private String brandType;		// 品牌型号
	private String carType;		// 车辆类型
	private String carColour;		// 车身颜色
	private String holdNumber;		// 容纳人数
	
	public OaCar() {
		super();
	}

	public OaCar(String id){
		super(id);
	}

	@Length(min=0, max=30, message="车牌号码长度必须介于 0 和 30 之间")
	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	@Length(min=0, max=255, message="品牌型号长度必须介于 0 和 255 之间")
	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}
	
	@Length(min=0, max=11, message="车辆类型长度必须介于 0 和 11 之间")
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	@Length(min=0, max=255, message="车身颜色长度必须介于 0 和 255 之间")
	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}
	
	@Length(min=0, max=11, message="容纳人数长度必须介于 0 和 11 之间")
	public String getHoldNumber() {
		return holdNumber;
	}

	public void setHoldNumber(String holdNumber) {
		this.holdNumber = holdNumber;
	}
	
}