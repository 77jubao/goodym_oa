package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaDepartmentBudget;
import cn.goodym.java.modules.oa.dao.OaDepartmentBudgetDao;

/**
 * 部门预算管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaDepartmentBudgetService extends CrudService<OaDepartmentBudgetDao, OaDepartmentBudget> {

	public OaDepartmentBudget get(String id) {
		return super.get(id);
	}
	
	public List<OaDepartmentBudget> findList(OaDepartmentBudget oaDepartmentBudget) {
		return super.findList(oaDepartmentBudget);
	}
	
	public Page<OaDepartmentBudget> findPage(Page<OaDepartmentBudget> page, OaDepartmentBudget oaDepartmentBudget) {
		return super.findPage(page, oaDepartmentBudget);
	}
	
	@Transactional(readOnly = false)
	public void save(OaDepartmentBudget oaDepartmentBudget) {
		super.save(oaDepartmentBudget);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaDepartmentBudget oaDepartmentBudget) {
		super.delete(oaDepartmentBudget);
	}
	
}