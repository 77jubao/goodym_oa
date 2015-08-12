/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaArchives;
import cn.goodym.java.modules.oa.dao.OaArchivesDao;

/**
 * 档案管理Service
 * @author 77jubao
 * @version 2015-08-12
 */
@Service
@Transactional(readOnly = true)
public class OaArchivesService extends CrudService<OaArchivesDao, OaArchives> {

	public OaArchives get(String id) {
		return super.get(id);
	}
	
	public List<OaArchives> findList(OaArchives oaArchives) {
		return super.findList(oaArchives);
	}
	
	public Page<OaArchives> findPage(Page<OaArchives> page, OaArchives oaArchives) {
		return super.findPage(page, oaArchives);
	}
	
	@Transactional(readOnly = false)
	public void save(OaArchives oaArchives) {
		super.save(oaArchives);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaArchives oaArchives) {
		super.delete(oaArchives);
	}
	
}