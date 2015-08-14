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
 * 外出记录Entity
 * @author 77jubao
 * @version 2015-08-14
 */
public class OaOut extends DataEntity<OaOut> {
	
	private static final long serialVersionUID = 1L;
	private String trueName;		// 姓名
	private Office office;		// 所属部门
	private String outType;		// 外出类型
	private Date outDate;		// 外出日期
	private String startTime;		// 起始时间
	private String endTime;		// 结束时间
	private String hourTotal;		// 小时数
	private String outStatus;		// 是否有效
	private String reason;		// 失效原因
	
	public OaOut() {
		super();
	}

	public OaOut(String id){
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
	
	@Length(min=0, max=255, message="外出类型长度必须介于 0 和 255 之间")
	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
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
	
	@Length(min=0, max=255, message="是否有效长度必须介于 0 和 255 之间")
	public String getOutStatus() {
		return outStatus;
	}

	public void setOutStatus(String outStatus) {
		this.outStatus = outStatus;
	}
	
	@Length(min=0, max=255, message="失效原因长度必须介于 0 和 255 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}