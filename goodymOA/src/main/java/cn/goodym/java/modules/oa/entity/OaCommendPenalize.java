/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import cn.goodym.java.modules.sys.entity.Office;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 奖惩记录Entity
 * @author 77jubao
 * @version 2015-08-13
 */
public class OaCommendPenalize extends DataEntity<OaCommendPenalize> {
	
	private static final long serialVersionUID = 1L;
	private String archivesNo;		// 人员档案号
	private String trueName;		// 姓名
	private Office office;		// 归属部门
	private String jcType;		// 奖惩属性
	private String money;		// 奖惩金额
	private Date cmonth;		// 月份
	
	public OaCommendPenalize() {
		super();
	}

	public OaCommendPenalize(String id){
		super(id);
	}

	@Length(min=0, max=255, message="人员档案号长度必须介于 0 和 255 之间")
	public String getArchivesNo() {
		return archivesNo;
	}

	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="奖惩属性长度必须介于 0 和 255 之间")
	public String getJcType() {
		return jcType;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCmonth() {
		return cmonth;
	}

	public void setCmonth(Date cmonth) {
		this.cmonth = cmonth;
	}
	
}