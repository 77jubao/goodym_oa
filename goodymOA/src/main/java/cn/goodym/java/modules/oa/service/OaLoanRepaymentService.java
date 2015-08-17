package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaLoanRepayment;
import cn.goodym.java.modules.oa.dao.OaLoanRepaymentDao;

/**
 * 借款还款管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaLoanRepaymentService extends CrudService<OaLoanRepaymentDao, OaLoanRepayment> {

	public OaLoanRepayment get(String id) {
		return super.get(id);
	}
	
	public List<OaLoanRepayment> findList(OaLoanRepayment oaLoanRepayment) {
		return super.findList(oaLoanRepayment);
	}
	
	public Page<OaLoanRepayment> findPage(Page<OaLoanRepayment> page, OaLoanRepayment oaLoanRepayment) {
		return super.findPage(page, oaLoanRepayment);
	}
	
	@Transactional(readOnly = false)
	public void save(OaLoanRepayment oaLoanRepayment) {
		super.save(oaLoanRepayment);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaLoanRepayment oaLoanRepayment) {
		super.delete(oaLoanRepayment);
	}
	
}