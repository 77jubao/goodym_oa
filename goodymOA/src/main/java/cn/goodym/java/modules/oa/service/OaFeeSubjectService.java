package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaFeeSubject;
import cn.goodym.java.modules.oa.dao.OaFeeSubjectDao;

/**
 * 费用科目管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaFeeSubjectService extends CrudService<OaFeeSubjectDao, OaFeeSubject> {

	public OaFeeSubject get(String id) {
		return super.get(id);
	}
	
	public List<OaFeeSubject> findList(OaFeeSubject oaFeeSubject) {
		return super.findList(oaFeeSubject);
	}
	
	public Page<OaFeeSubject> findPage(Page<OaFeeSubject> page, OaFeeSubject oaFeeSubject) {
		return super.findPage(page, oaFeeSubject);
	}
	
	@Transactional(readOnly = false)
	public void save(OaFeeSubject oaFeeSubject) {
		super.save(oaFeeSubject);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaFeeSubject oaFeeSubject) {
		super.delete(oaFeeSubject);
	}
	
}