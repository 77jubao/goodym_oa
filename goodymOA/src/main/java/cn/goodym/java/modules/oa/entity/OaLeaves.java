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
 * 请假记录Entity
 * @author 77jubao
 * @version 2015-08-14
 */
public class OaLeaves extends DataEntity<OaLeaves> {
	
	private static final long serialVersionUID = 1L;
	private String trueName;		// 姓名
	private Office office;		// 所属部门
	private String leaveType;		// 请假类型
	private Date leaveDate;		// 请假日期
	private String startTime;		// 开始时间
	private String endTime;		// 结束时间
	private String hourTotal;		// 小时数
	private String leaveStatus;		// 是否有效
	private String leaveCause;		// 失效原因
	
	public OaLeaves() {
		super();
	}

	public OaLeaves(String id){
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
	
	@Length(min=0, max=255, message="请假类型长度必须介于 0 和 255 之间")
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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
	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	@Length(min=0, max=255, message="失效原因长度必须介于 0 和 255 之间")
	public String getLeaveCause() {
		return leaveCause;
	}

	public void setLeaveCause(String leaveCause) {
		this.leaveCause = leaveCause;
	}
	
}