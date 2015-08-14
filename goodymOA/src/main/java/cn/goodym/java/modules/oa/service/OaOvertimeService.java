/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaOvertime;
import cn.goodym.java.modules.oa.dao.OaOvertimeDao;

/**
 * 加班记录Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaOvertimeService extends CrudService<OaOvertimeDao, OaOvertime> {

	public OaOvertime get(String id) {
		return super.get(id);
	}
	
	public List<OaOvertime> findList(OaOvertime oaOvertime) {
		return super.findList(oaOvertime);
	}
	
	public Page<OaOvertime> findPage(Page<OaOvertime> page, OaOvertime oaOvertime) {
		return super.findPage(page, oaOvertime);
	}
	
	@Transactional(readOnly = false)
	public void save(OaOvertime oaOvertime) {
		super.save(oaOvertime);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaOvertime oaOvertime) {
		super.delete(oaOvertime);
	}
	
}