package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaProjectBudget;
import cn.goodym.java.modules.oa.dao.OaProjectBudgetDao;

/**
 * 项目预算管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaProjectBudgetService extends CrudService<OaProjectBudgetDao, OaProjectBudget> {

	public OaProjectBudget get(String id) {
		return super.get(id);
	}
	
	public List<OaProjectBudget> findList(OaProjectBudget oaProjectBudget) {
		return super.findList(oaProjectBudget);
	}
	
	public Page<OaProjectBudget> findPage(Page<OaProjectBudget> page, OaProjectBudget oaProjectBudget) {
		return super.findPage(page, oaProjectBudget);
	}
	
	@Transactional(readOnly = false)
	public void save(OaProjectBudget oaProjectBudget) {
		super.save(oaProjectBudget);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaProjectBudget oaProjectBudget) {
		super.delete(oaProjectBudget);
	}
	
}