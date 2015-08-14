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
 * 倒休管理Entity
 * @author 77jubao
 * @version 2015-08-14
 */
public class OaPourOff extends DataEntity<OaPourOff> {
	
	private static final long serialVersionUID = 1L;
	private String trueName;		// 姓名
	private Office office;		// 所属部门
	private String pourType;		// 倒休类型
	private Date pourDate;		// 发生日期
	private String hourTotal;		// 小时数
	private String pourStatus;		// 是否有效
	private String reason;		// 失效原因
	
	public OaPourOff() {
		super();
	}

	public OaPourOff(String id){
		super(id);
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
	
	@Length(min=0, max=255, message="倒休类型长度必须介于 0 和 255 之间")
	public String getPourType() {
		return pourType;
	}

	public void setPourType(String pourType) {
		this.pourType = pourType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPourDate() {
		return pourDate;
	}

	public void setPourDate(Date pourDate) {
		this.pourDate = pourDate;
	}
	
	@Length(min=0, max=255, message="小时数长度必须介于 0 和 255 之间")
	public String getHourTotal() {
		return hourTotal;
	}

	public void setHourTotal(String hourTotal) {
		this.hourTotal = hourTotal;
	}
	
	@Length(min=0, max=255, message="是否有效长度必须介于 0 和 255 之间")
	public String getPourStatus() {
		return pourStatus;
	}

	public void setPourStatus(String pourStatus) {
		this.pourStatus = pourStatus;
	}
	
	@Length(min=0, max=255, message="失效原因长度必须介于 0 和 255 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}