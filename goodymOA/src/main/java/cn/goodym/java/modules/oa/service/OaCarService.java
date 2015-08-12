/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaCar;
import cn.goodym.java.modules.oa.dao.OaCarDao;

/**
 * 车辆管理Service
 * @author 77jubao
 * @version 2015-08-12
 */
@Service
@Transactional(readOnly = true)
public class OaCarService extends CrudService<OaCarDao, OaCar> {

	public OaCar get(String id) {
		return super.get(id);
	}
	
	public List<OaCar> findList(OaCar oaCar) {
		return super.findList(oaCar);
	}
	
	public Page<OaCar> findPage(Page<OaCar> page, OaCar oaCar) {
		return super.findPage(page, oaCar);
	}
	
	@Transactional(readOnly = false)
	public void save(OaCar oaCar) {
		super.save(oaCar);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaCar oaCar) {
		super.delete(oaCar);
	}
	
}