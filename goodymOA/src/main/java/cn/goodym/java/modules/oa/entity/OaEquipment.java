/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import cn.goodym.java.modules.sys.entity.Office;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 设备信息Entity
 * @author 77jubao
 * @version 2015-08-24
 */
public class OaEquipment extends DataEntity<OaEquipment> {
	
	private static final long serialVersionUID = 1L;
	private String categoryId;		// 设备类型
	private String equipmentNo;		// 设备编号
	private String specificationsModel;		// 规格型号
	private String measureUnit;		// 计量单位
	private String addWays;		// 增加方式
	private String custodian;		// 保管人员
	private String resettlement;		// 安置地点
	private String useStatus;		// 使用状态
	private Office office;		// 所属部门
	private String manufacturer;		// 生产厂家
	private String factoryPhone;		// 厂家联系方式
	private String factoryAddres;		// 厂家地址
	
	public OaEquipment() {
		super();
	}

	public OaEquipment(String id){
		super(id);
	}

	@Length(min=0, max=30, message="设备类型长度必须介于 0 和 30 之间")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Length(min=0, max=30, message="设备编号长度必须介于 0 和 30 之间")
	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	
	@Length(min=0, max=255, message="规格型号长度必须介于 0 和 255 之间")
	public String getSpecificationsModel() {
		return specificationsModel;
	}

	public void setSpecificationsModel(String specificationsModel) {
		this.specificationsModel = specificationsModel;
	}
	
	@Length(min=0, max=255, message="计量单位长度必须介于 0 和 255 之间")
	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	@Length(min=0, max=255, message="增加方式长度必须介于 0 和 255 之间")
	public String getAddWays() {
		return addWays;
	}

	public void setAddWays(String addWays) {
		this.addWays = addWays;
	}
	
	@Length(min=0, max=255, message="保管人员长度必须介于 0 和 255 之间")
	public String getCustodian() {
		return custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	
	@Length(min=0, max=255, message="安置地点长度必须介于 0 和 255 之间")
	public String getResettlement() {
		return resettlement;
	}

	public void setResettlement(String resettlement) {
		this.resettlement = resettlement;
	}
	
	@Length(min=0, max=255, message="使用状态长度必须介于 0 和 255 之间")
	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="生产厂家长度必须介于 0 和 255 之间")
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Length(min=0, max=255, message="厂家联系方式长度必须介于 0 和 255 之间")
	public String getFactoryPhone() {
		return factoryPhone;
	}

	public void setFactoryPhone(String factoryPhone) {
		this.factoryPhone = factoryPhone;
	}
	
	@Length(min=0, max=255, message="厂家地址长度必须介于 0 和 255 之间")
	public String getFactoryAddres() {
		return factoryAddres;
	}

	public void setFactoryAddres(String factoryAddres) {
		this.factoryAddres = factoryAddres;
	}
	
}