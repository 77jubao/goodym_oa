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
 * 借款还款管理Entity
 * @author 77jubao
 * @version 2015-08-17
 */
public class OaLoanRepayment extends DataEntity<OaLoanRepayment> {
	
	private static final long serialVersionUID = 1L;
	private String loanNo;		// 借款单编号
	private User loanName;		// 借款人
	private Date loanDate;		// 借款日期
	private Office office;		// 所属部门
	private String loanReason;		// 借款事由
	private Double money;		// 借款金额
	private Double hasAlsoMoney;		// 已还金额
	private Double reimbursementOffset;		// 报销冲抵
	private Double remainingAmount;		// 剩余金额
	private String loanStatus;		// 借款状态
	
	public OaLoanRepayment() {
		super();
	}

	public OaLoanRepayment(String id){
		super(id);
	}

	@Length(min=0, max=64, message="借款单编号长度必须介于 0 和 64 之间")
	public String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	
	public User getLoanName() {
		return loanName;
	}

	public void setLoanName(User loanName) {
		this.loanName = loanName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="借款事由长度必须介于 0 和 255 之间")
	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}
	
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	public Double getHasAlsoMoney() {
		return hasAlsoMoney;
	}

	public void setHasAlsoMoney(Double hasAlsoMoney) {
		this.hasAlsoMoney = hasAlsoMoney;
	}
	
	public Double getReimbursementOffset() {
		return reimbursementOffset;
	}

	public void setReimbursementOffset(Double reimbursementOffset) {
		this.reimbursementOffset = reimbursementOffset;
	}
	
	public Double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	
	@Length(min=0, max=255, message="借款状态长度必须介于 0 和 255 之间")
	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	
}