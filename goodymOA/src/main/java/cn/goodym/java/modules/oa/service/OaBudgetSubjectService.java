package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaBudgetSubject;
import cn.goodym.java.modules.oa.dao.OaBudgetSubjectDao;

/**
 * 预算科目管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaBudgetSubjectService extends CrudService<OaBudgetSubjectDao, OaBudgetSubject> {

	public OaBudgetSubject get(String id) {
		return super.get(id);
	}
	
	public List<OaBudgetSubject> findList(OaBudgetSubject oaBudgetSubject) {
		return super.findList(oaBudgetSubject);
	}
	
	public Page<OaBudgetSubject> findPage(Page<OaBudgetSubject> page, OaBudgetSubject oaBudgetSubject) {
		return super.findPage(page, oaBudgetSubject);
	}
	
	@Transactional(readOnly = false)
	public void save(OaBudgetSubject oaBudgetSubject) {
		super.save(oaBudgetSubject);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaBudgetSubject oaBudgetSubject) {
		super.delete(oaBudgetSubject);
	}
	
}