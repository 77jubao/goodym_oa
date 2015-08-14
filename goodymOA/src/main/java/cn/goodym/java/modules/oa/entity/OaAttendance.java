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
 * 出勤记录Entity
 * @author 77jubao
 * @version 2015-08-14
 */
public class OaAttendance extends DataEntity<OaAttendance> {
	
	private static final long serialVersionUID = 1L;
	private String trueName;		// 签到人
	private Office office;		// 归属部门
	private Date signDate;		// 签到日期
	private String attendanceTime;		// 考勤时间
	private String signType;		// 签到类型
	private String signStatus;		// 签到状态
	
	public OaAttendance() {
		super();
	}

	public OaAttendance(String id){
		super(id);
	}

	@Length(min=0, max=255, message="签到人长度必须介于 0 和 255 之间")
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	
	public String getAttendanceTime() {
		return attendanceTime;
	}

	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}
	
	@Length(min=0, max=255, message="签到类型长度必须介于 0 和 255 之间")
	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	@Length(min=0, max=255, message="签到状态长度必须介于 0 和 255 之间")
	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}
	
}