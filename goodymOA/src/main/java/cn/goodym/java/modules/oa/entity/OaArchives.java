/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import cn.goodym.java.modules.sys.entity.Office;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 档案管理Entity
 * @author 77jubao
 * @version 2015-08-12
 */
public class OaArchives extends DataEntity<OaArchives> {
	
	private static final long serialVersionUID = 1L;
	private String archivesNo;		// 档案号
	private String trueName;		// 真实姓名
	private String sex;		// 性别
	private Date entryDate;		// 入职日期
	private String status;		// 状态
	private Office company;		// 归属公司
	private Office office;		// 归属部门
	private String position;		// 职务
	private String idCard;		// 身份证
	private Date birthDate;		// 出生日期
	
	public OaArchives() {
		super();
	}

	public OaArchives(String id){
		super(id);
	}

	@Length(min=0, max=255, message="档案号长度必须介于 0 和 255 之间")
	public String getArchivesNo() {
		return archivesNo;
	}

	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	
	@Length(min=0, max=255, message="真实姓名长度必须介于 0 和 255 之间")
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Length(min=0, max=11, message="性别长度必须介于 0 和 11 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	@Length(min=0, max=11, message="状态长度必须介于 0 和 11 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=0, max=255, message="职务长度必须介于 0 和 255 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Length(min=0, max=255, message="身份证长度必须介于 0 和 255 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}