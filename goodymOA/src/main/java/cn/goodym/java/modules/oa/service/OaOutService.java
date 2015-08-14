/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaOut;
import cn.goodym.java.modules.oa.dao.OaOutDao;

/**
 * 外出记录Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaOutService extends CrudService<OaOutDao, OaOut> {

	public OaOut get(String id) {
		return super.get(id);
	}
	
	public List<OaOut> findList(OaOut oaOut) {
		return super.findList(oaOut);
	}
	
	public Page<OaOut> findPage(Page<OaOut> page, OaOut oaOut) {
		return super.findPage(page, oaOut);
	}
	
	@Transactional(readOnly = false)
	public void save(OaOut oaOut) {
		super.save(oaOut);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaOut oaOut) {
		super.delete(oaOut);
	}
	
}