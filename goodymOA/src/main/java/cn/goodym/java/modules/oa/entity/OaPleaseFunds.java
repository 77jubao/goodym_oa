/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import cn.goodym.java.modules.sys.entity.Office;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.goodym.java.modules.sys.entity.User;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 请款管理Entity
 * @author 77jubao
 * @version 2015-08-17
 */
public class OaPleaseFunds extends DataEntity<OaPleaseFunds> {
	
	private static final long serialVersionUID = 1L;
	private String pleaseNumber;		// 请款编号
	private Office office;		// 归属部门
	private String budgetSubjectId;		// 预算科目
	private String feeSubjectId;		// 请款类型
	private Date pleaseDate;		// 请款日期
	private User pleaseName;		// 请款人
	private String playType;		// 付款方式
	private String playReason;		// 付款事由
	private String playMoney;		// 支付金额
	private String companyName;		// 收款单位名称
	private String playStatus;		// 请款状态
	
	public OaPleaseFunds() {
		super();
	}

	public OaPleaseFunds(String id){
		super(id);
	}

	@Length(min=0, max=32, message="请款编号长度必须介于 0 和 32 之间")
	public String getPleaseNumber() {
		return pleaseNumber;
	}

	public void setPleaseNumber(String pleaseNumber) {
		this.pleaseNumber = pleaseNumber;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="预算科目长度必须介于 0 和 255 之间")
	public String getBudgetSubjectId() {
		return budgetSubjectId;
	}

	public void setBudgetSubjectId(String budgetSubjectId) {
		this.budgetSubjectId = budgetSubjectId;
	}
	
	@Length(min=0, max=255, message="请款类型长度必须介于 0 和 255 之间")
	public String getFeeSubjectId() {
		return feeSubjectId;
	}

	public void setFeeSubjectId(String feeSubjectId) {
		this.feeSubjectId = feeSubjectId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPleaseDate() {
		return pleaseDate;
	}

	public void setPleaseDate(Date pleaseDate) {
		this.pleaseDate = pleaseDate;
	}
	
	public User getPleaseName() {
		return pleaseName;
	}

	public void setPleaseName(User pleaseName) {
		this.pleaseName = pleaseName;
	}
	
	@Length(min=0, max=255, message="付款方式长度必须介于 0 和 255 之间")
	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}
	
	@Length(min=0, max=255, message="付款事由长度必须介于 0 和 255 之间")
	public String getPlayReason() {
		return playReason;
	}

	public void setPlayReason(String playReason) {
		this.playReason = playReason;
	}
	
	public String getPlayMoney() {
		return playMoney;
	}

	public void setPlayMoney(String playMoney) {
		this.playMoney = playMoney;
	}
	
	@Length(min=0, max=255, message="收款单位名称长度必须介于 0 和 255 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=0, max=255, message="请款状态长度必须介于 0 和 255 之间")
	public String getPlayStatus() {
		return playStatus;
	}

	public void setPlayStatus(String playStatus) {
		this.playStatus = playStatus;
	}
	
}