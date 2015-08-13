/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 合同记录Entity
 * @author 77jubao
 * @version 2015-08-13
 */
public class OaContract extends DataEntity<OaContract> {
	
	private static final long serialVersionUID = 1L;
	private String contractNo;		// 合同编号
	private String trueName;		// 姓名
	private String isTryOut;		// 是否有试用期
	private Date tryOutDate;		// 试用截止时间
	private String isRegular;		// 是否固定合同
	private Date regularDate;		// 到期日期
	private String isPositive;		// 是否转正
	private Date positiveDate;		// 转正日期
	private String isRemove;		// 是否解除
	private Date removeDate;		// 解除日期
	
	public OaContract() {
		super();
	}

	public OaContract(String id){
		super(id);
	}

	@Length(min=0, max=255, message="合同编号长度必须介于 0 和 255 之间")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=255, message="是否有试用期长度必须介于 0 和 255 之间")
	public String getIsTryOut() {
		return isTryOut;
	}

	public void setIsTryOut(String isTryOut) {
		this.isTryOut = isTryOut;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTryOutDate() {
		return tryOutDate;
	}

	public void setTryOutDate(Date tryOutDate) {
		this.tryOutDate = tryOutDate;
	}
	
	@Length(min=0, max=255, message="是否固定合同长度必须介于 0 和 255 之间")
	public String getIsRegular() {
		return isRegular;
	}

	public void setIsRegular(String isRegular) {
		this.isRegular = isRegular;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegularDate() {
		return regularDate;
	}

	public void setRegularDate(Date regularDate) {
		this.regularDate = regularDate;
	}
	
	@Length(min=0, max=255, message="是否转正长度必须介于 0 和 255 之间")
	public String getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(String isPositive) {
		this.isPositive = isPositive;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPositiveDate() {
		return positiveDate;
	}

	public void setPositiveDate(Date positiveDate) {
		this.positiveDate = positiveDate;
	}
	
	@Length(min=0, max=255, message="是否解除长度必须介于 0 和 255 之间")
	public String getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(String isRemove) {
		this.isRemove = isRemove;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}
	
}