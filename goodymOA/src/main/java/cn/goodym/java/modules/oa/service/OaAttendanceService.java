/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaAttendance;
import cn.goodym.java.modules.oa.dao.OaAttendanceDao;

/**
 * 出勤记录Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaAttendanceService extends CrudService<OaAttendanceDao, OaAttendance> {

	public OaAttendance get(String id) {
		return super.get(id);
	}
	
	public List<OaAttendance> findList(OaAttendance oaAttendance) {
		return super.findList(oaAttendance);
	}
	
	public Page<OaAttendance> findPage(Page<OaAttendance> page, OaAttendance oaAttendance) {
		return super.findPage(page, oaAttendance);
	}
	
	@Transactional(readOnly = false)
	public void save(OaAttendance oaAttendance) {
		super.save(oaAttendance);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaAttendance oaAttendance) {
		super.delete(oaAttendance);
	}
	
}