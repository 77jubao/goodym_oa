/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 项目预算管理Entity
 * @author 77jubao
 * @version 2015-08-17
 */
public class OaProjectBudget extends DataEntity<OaProjectBudget> {
	
	private static final long serialVersionUID = 1L;
	private String projectId;		// 所属项目
	private String budgetSubjectId;		// 预算科目
	private String money;		// 预算金额
	private Date years;		// 年份
	
	public OaProjectBudget() {
		super();
	}

	public OaProjectBudget(String id){
		super(id);
	}

	@Length(min=0, max=11, message="所属项目长度必须介于 0 和 11 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Length(min=0, max=255, message="预算科目长度必须介于 0 和 255 之间")
	public String getBudgetSubjectId() {
		return budgetSubjectId;
	}

	public void setBudgetSubjectId(String budgetSubjectId) {
		this.budgetSubjectId = budgetSubjectId;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYears() {
		return years;
	}

	public void setYears(Date years) {
		this.years = years;
	}
	
}