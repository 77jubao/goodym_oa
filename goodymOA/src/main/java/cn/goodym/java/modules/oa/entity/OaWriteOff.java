/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import cn.goodym.java.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.goodym.java.modules.sys.entity.Office;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 报销管理Entity
 * @author 77jubao
 * @version 2015-08-19
 */
public class OaWriteOff extends DataEntity<OaWriteOff> {
	
	private static final long serialVersionUID = 1L;
	private String writeOffNo;		// 报销单号
	private String writeOffType;		// 报销类型
	private User name;		// 报销人
	private Date writeOffDate;		// 报销日期
	private String writeOffReason;		// 报销事由
	private Office office;		// 归属部门
	private String writeOffMoney;		// 报销金额
	private String writeOffStatus;		// 报销状态
	private String loanNo;		// 借款单编号
	private String loanMoney;		// 借款单金额
	private String subjectName;		// 预算科目
	
	public OaWriteOff() {
		super();
	}

	public OaWriteOff(String id){
		super(id);
	}

	@Length(min=0, max=255, message="报销单号长度必须介于 0 和 255 之间")
	public String getWriteOffNo() {
		return writeOffNo;
	}

	public void setWriteOffNo(String writeOffNo) {
		this.writeOffNo = writeOffNo;
	}
	
	@Length(min=0, max=255, message="报销类型长度必须介于 0 和 255 之间")
	public String getWriteOffType() {
		return writeOffType;
	}

	public void setWriteOffType(String writeOffType) {
		this.writeOffType = writeOffType;
	}
	
	public User getName() {
		return name;
	}

	public void setName(User name) {
		this.name = name;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWriteOffDate() {
		return writeOffDate;
	}

	public void setWriteOffDate(Date writeOffDate) {
		this.writeOffDate = writeOffDate;
	}
	
	@Length(min=0, max=255, message="报销事由长度必须介于 0 和 255 之间")
	public String getWriteOffReason() {
		return writeOffReason;
	}

	public void setWriteOffReason(String writeOffReason) {
		this.writeOffReason = writeOffReason;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	public String getWriteOffMoney() {
		return writeOffMoney;
	}

	public void setWriteOffMoney(String writeOffMoney) {
		this.writeOffMoney = writeOffMoney;
	}
	
	@Length(min=0, max=255, message="报销状态长度必须介于 0 和 255 之间")
	public String getWriteOffStatus() {
		return writeOffStatus;
	}

	public void setWriteOffStatus(String writeOffStatus) {
		this.writeOffStatus = writeOffStatus;
	}
	
	@Length(min=0, max=255, message="借款单编号长度必须介于 0 和 255 之间")
	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	
	public String getLoanMoney() {
		return loanMoney;
	}

	public void setLoanMoney(String loanMoney) {
		this.loanMoney = loanMoney;
	}
	
	@Length(min=0, max=255, message="预算科目长度必须介于 0 和 255 之间")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}