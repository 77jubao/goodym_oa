/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaBusinessTrip;
import cn.goodym.java.modules.oa.dao.OaBusinessTripDao;

/**
 * 出差管理Service
 * @author 77jubao
 * @version 2015-08-14
 */
@Service
@Transactional(readOnly = true)
public class OaBusinessTripService extends CrudService<OaBusinessTripDao, OaBusinessTrip> {

	public OaBusinessTrip get(String id) {
		return super.get(id);
	}
	
	public List<OaBusinessTrip> findList(OaBusinessTrip oaBusinessTrip) {
		return super.findList(oaBusinessTrip);
	}
	
	public Page<OaBusinessTrip> findPage(Page<OaBusinessTrip> page, OaBusinessTrip oaBusinessTrip) {
		return super.findPage(page, oaBusinessTrip);
	}
	
	@Transactional(readOnly = false)
	public void save(OaBusinessTrip oaBusinessTrip) {
		super.save(oaBusinessTrip);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaBusinessTrip oaBusinessTrip) {
		super.delete(oaBusinessTrip);
	}
	
}