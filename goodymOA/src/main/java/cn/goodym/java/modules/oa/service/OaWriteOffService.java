package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaWriteOff;
import cn.goodym.java.modules.oa.dao.OaWriteOffDao;

/**
 * 报销管理Service
 * @author 77jubao
 * @version 2015-08-19
 */
@Service
@Transactional(readOnly = true)
public class OaWriteOffService extends CrudService<OaWriteOffDao, OaWriteOff> {

	public OaWriteOff get(String id) {
		return super.get(id);
	}
	
	public List<OaWriteOff> findList(OaWriteOff oaWriteOff) {
		return super.findList(oaWriteOff);
	}
	
	public Page<OaWriteOff> findPage(Page<OaWriteOff> page, OaWriteOff oaWriteOff) {
		return super.findPage(page, oaWriteOff);
	}
	
	@Transactional(readOnly = false)
	public void save(OaWriteOff oaWriteOff) {
		super.save(oaWriteOff);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaWriteOff oaWriteOff) {
		super.delete(oaWriteOff);
	}
	
}