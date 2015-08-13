/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaTrain;
import cn.goodym.java.modules.oa.dao.OaTrainDao;

/**
 * 培训记录Service
 * @author 77jubao
 * @version 2015-08-13
 */
@Service
@Transactional(readOnly = true)
public class OaTrainService extends CrudService<OaTrainDao, OaTrain> {

	public OaTrain get(String id) {
		return super.get(id);
	}
	
	public List<OaTrain> findList(OaTrain oaTrain) {
		return super.findList(oaTrain);
	}
	
	public Page<OaTrain> findPage(Page<OaTrain> page, OaTrain oaTrain) {
		return super.findPage(page, oaTrain);
	}
	
	@Transactional(readOnly = false)
	public void save(OaTrain oaTrain) {
		super.save(oaTrain);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaTrain oaTrain) {
		super.delete(oaTrain);
	}
	
}