/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaLeaves;
import cn.goodym.java.modules.oa.dao.OaLeavesDao;

/**
 * 请假记录Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaLeavesService extends CrudService<OaLeavesDao, OaLeaves> {

	public OaLeaves get(String id) {
		return super.get(id);
	}
	
	public List<OaLeaves> findList(OaLeaves oaLeaves) {
		return super.findList(oaLeaves);
	}
	
	public Page<OaLeaves> findPage(Page<OaLeaves> page, OaLeaves oaLeaves) {
		return super.findPage(page, oaLeaves);
	}
	
	@Transactional(readOnly = false)
	public void save(OaLeaves oaLeaves) {
		super.save(oaLeaves);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaLeaves oaLeaves) {
		super.delete(oaLeaves);
	}
	
}