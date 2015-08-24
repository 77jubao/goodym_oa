/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 设备类型Entity
 * @author 77jubao
 * @version 2015-08-24
 */
public class OaEquipmentCategory extends DataEntity<OaEquipmentCategory> {
	
	private static final long serialVersionUID = 1L;
	private String categoryName;		// 类型名称
	
	public OaEquipmentCategory() {
		super();
	}

	public OaEquipmentCategory(String id){
		super(id);
	}

	@Length(min=0, max=30, message="类型名称长度必须介于 0 和 30 之间")
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}