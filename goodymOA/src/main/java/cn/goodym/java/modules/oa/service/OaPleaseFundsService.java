package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaPleaseFunds;
import cn.goodym.java.modules.oa.dao.OaPleaseFundsDao;

/**
 * 请款管理Service
 * @author 77jubao
 * @version 2015-08-17
 */
@Service
@Transactional(readOnly = true)
public class OaPleaseFundsService extends CrudService<OaPleaseFundsDao, OaPleaseFunds> {

	public OaPleaseFunds get(String id) {
		return super.get(id);
	}
	
	public List<OaPleaseFunds> findList(OaPleaseFunds oaPleaseFunds) {
		return super.findList(oaPleaseFunds);
	}
	
	public Page<OaPleaseFunds> findPage(Page<OaPleaseFunds> page, OaPleaseFunds oaPleaseFunds) {
		return super.findPage(page, oaPleaseFunds);
	}
	
	@Transactional(readOnly = false)
	public void save(OaPleaseFunds oaPleaseFunds) {
		super.save(oaPleaseFunds);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaPleaseFunds oaPleaseFunds) {
		super.delete(oaPleaseFunds);
	}
	
}