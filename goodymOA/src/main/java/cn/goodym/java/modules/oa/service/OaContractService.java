/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaContract;
import cn.goodym.java.modules.oa.dao.OaContractDao;

/**
 * 合同记录Service
 * @author 77jubao
 * @version 2015-08-13
 */
@Service
@Transactional(readOnly = true)
public class OaContractService extends CrudService<OaContractDao, OaContract> {

	public OaContract get(String id) {
		return super.get(id);
	}
	
	public List<OaContract> findList(OaContract oaContract) {
		return super.findList(oaContract);
	}
	
	public Page<OaContract> findPage(Page<OaContract> page, OaContract oaContract) {
		return super.findPage(page, oaContract);
	}
	
	@Transactional(readOnly = false)
	public void save(OaContract oaContract) {
		super.save(oaContract);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaContract oaContract) {
		super.delete(oaContract);
	}
	
}