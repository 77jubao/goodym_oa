/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaCommendPenalize;
import cn.goodym.java.modules.oa.dao.OaCommendPenalizeDao;

/**
 * 奖惩记录Service
 * @author 77jubao
 * @version 2015-08-13
 */
@Service
@Transactional(readOnly = true)
public class OaCommendPenalizeService extends CrudService<OaCommendPenalizeDao, OaCommendPenalize> {

	public OaCommendPenalize get(String id) {
		return super.get(id);
	}
	
	public List<OaCommendPenalize> findList(OaCommendPenalize oaCommendPenalize) {
		return super.findList(oaCommendPenalize);
	}
	
	public Page<OaCommendPenalize> findPage(Page<OaCommendPenalize> page, OaCommendPenalize oaCommendPenalize) {
		return super.findPage(page, oaCommendPenalize);
	}
	
	@Transactional(readOnly = false)
	public void save(OaCommendPenalize oaCommendPenalize) {
		super.save(oaCommendPenalize);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaCommendPenalize oaCommendPenalize) {
		super.delete(oaCommendPenalize);
	}
	
}