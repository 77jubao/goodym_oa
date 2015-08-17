/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.entity;

import org.hibernate.validator.constraints.Length;

import cn.goodym.java.common.persistence.DataEntity;

/**
 * 费用科目管理Entity
 * @author 77jubao
 * @version 2015-08-17
 */
public class OaFeeSubject extends DataEntity<OaFeeSubject> {
	
	private static final long serialVersionUID = 1L;
	private String subjectCode;		// 费用科目编码
	private String subjectName;		// 费用科目名称
	
	public OaFeeSubject() {
		super();
	}

	public OaFeeSubject(String id){
		super(id);
	}

	@Length(min=0, max=30, message="费用科目编码长度必须介于 0 和 30 之间")
	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	@Length(min=0, max=30, message="费用科目名称长度必须介于 0 和 30 之间")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}