/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 培训记录Entity
 * @author 77jubao
 * @version 2015-08-13
 */
public class OaTrain extends DataEntity<OaTrain> {
	
	private static final long serialVersionUID = 1L;
	private String archivesNo;		// 档案号
	private String trueName;		// 真实姓名
	private String money;		// 培训费用
	private Date startDate;		// 开始日期
	private Date endDate;		// 结束日期
	private String trainingInstitutions;		// 培训机构
	private String courseLocations;		// 培训地点
	private String trainingContent;		// 培训内容
	private String certificate;		// 所获证书
	
	public OaTrain() {
		super();
	}

	public OaTrain(String id){
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
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
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
	
	@Length(min=0, max=255, message="培训机构长度必须介于 0 和 255 之间")
	public String getTrainingInstitutions() {
		return trainingInstitutions;
	}

	public void setTrainingInstitutions(String trainingInstitutions) {
		this.trainingInstitutions = trainingInstitutions;
	}
	
	@Length(min=0, max=255, message="培训地点长度必须介于 0 和 255 之间")
	public String getCourseLocations() {
		return courseLocations;
	}

	public void setCourseLocations(String courseLocations) {
		this.courseLocations = courseLocations;
	}
	
	@Length(min=0, max=255, message="培训内容长度必须介于 0 和 255 之间")
	public String getTrainingContent() {
		return trainingContent;
	}

	public void setTrainingContent(String trainingContent) {
		this.trainingContent = trainingContent;
	}
	
	@Length(min=0, max=255, message="所获证书长度必须介于 0 和 255 之间")
	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	
}