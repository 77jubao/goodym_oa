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
 * 出差管理Entity
 * @author 77jubao
 * @version 2015-08-14
 */
public class OaBusinessTrip extends DataEntity<OaBusinessTrip> {
	
	private static final long serialVersionUID = 1L;
	private String trueName;		// 姓名
	private Office office;		// 所属部门
	private String businessType;		// 出差类型
	private Date businessDate;		// 出差日期
	private String startTime;		// 起始时间
	private String endTime;		// 结束时间
	private String hourTotal;		// 小时数
	private String changeType;		// 转换类型
	private String changeHour;		// 转换小时数
	private Date expiredDate;		// 过期时间
	private String businessStatus;		// 是否有效
	private String reason;		// 失效原因
	
	public OaBusinessTrip() {
		super();
	}

	public OaBusinessTrip(String id){
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
	
	@Length(min=0, max=255, message="出差类型长度必须介于 0 和 255 之间")
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBusinessDate() {
		return businessDate;
	}

	public void setBusinessDate(Date businessDate) {
		this.businessDate = businessDate;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Length(min=0, max=255, message="小时数长度必须介于 0 和 255 之间")
	public String getHourTotal() {
		return hourTotal;
	}

	public void setHourTotal(String hourTotal) {
		this.hourTotal = hourTotal;
	}
	
	@Length(min=0, max=255, message="转换类型长度必须介于 0 和 255 之间")
	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	
	@Length(min=0, max=255, message="转换小时数长度必须介于 0 和 255 之间")
	public String getChangeHour() {
		return changeHour;
	}

	public void setChangeHour(String changeHour) {
		this.changeHour = changeHour;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	
	@Length(min=0, max=255, message="是否有效长度必须介于 0 和 255 之间")
	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}
	
	@Length(min=0, max=255, message="失效原因长度必须介于 0 和 255 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}