/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import cn.goodym.java.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 证件管理Entity
 * @author 77jubao
 * @version 2015-08-19
 */
public class OaCredentials extends DataEntity<OaCredentials> {
	
	private static final long serialVersionUID = 1L;
	private String archivesNo;		// 档案号
	private User trueName;		// 人员姓名
	private String credentialsName;		// 证件名称
	private String credentialsNo;		// 证件号码
	private String issuingInstitution;		// 发证机构
	private Date issueDate;		// 发证日期
	private Date startDate;		// 有效起始日期
	private Date endDate;		// 有效结束日期
	private String credType;		// 证件类型
	
	public OaCredentials() {
		super();
	}

	public OaCredentials(String id){
		super(id);
	}

	@Length(min=0, max=255, message="档案号长度必须介于 0 和 255 之间")
	public String getArchivesNo() {
		return archivesNo;
	}

	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	
	public User getTrueName() {
		return trueName;
	}

	public void setTrueName(User trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=255, message="证件名称长度必须介于 0 和 255 之间")
	public String getCredentialsName() {
		return credentialsName;
	}

	public void setCredentialsName(String credentialsName) {
		this.credentialsName = credentialsName;
	}
	
	@Length(min=0, max=255, message="证件号码长度必须介于 0 和 255 之间")
	public String getCredentialsNo() {
		return credentialsNo;
	}

	public void setCredentialsNo(String credentialsNo) {
		this.credentialsNo = credentialsNo;
	}
	
	@Length(min=0, max=255, message="发证机构长度必须介于 0 和 255 之间")
	public String getIssuingInstitution() {
		return issuingInstitution;
	}

	public void setIssuingInstitution(String issuingInstitution) {
		this.issuingInstitution = issuingInstitution;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Length(min=0, max=255, message="证件类型长度必须介于 0 和 255 之间")
	public String getCredType() {
		return credType;
	}

	public void setCredType(String credType) {
		this.credType = credType;
	}
	
}