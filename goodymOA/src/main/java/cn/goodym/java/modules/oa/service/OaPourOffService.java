/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaPourOff;
import cn.goodym.java.modules.oa.dao.OaPourOffDao;

/**
 * 倒休管理Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaPourOffService extends CrudService<OaPourOffDao, OaPourOff> {

	public OaPourOff get(String id) {
		return super.get(id);
	}
	
	public List<OaPourOff> findList(OaPourOff oaPourOff) {
		return super.findList(oaPourOff);
	}
	
	public Page<OaPourOff> findPage(Page<OaPourOff> page, OaPourOff oaPourOff) {
		return super.findPage(page, oaPourOff);
	}
	
	@Transactional(readOnly = false)
	public void save(OaPourOff oaPourOff) {
		super.save(oaPourOff);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaPourOff oaPourOff) {
		super.delete(oaPourOff);
	}
	
}