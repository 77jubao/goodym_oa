package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaCredentials;
import cn.goodym.java.modules.oa.dao.OaCredentialsDao;

/**
 * 证件管理Service
 * @author 77jubao
 * @version 2015-08-19
 */
@Service
@Transactional(readOnly = true)
public class OaCredentialsService extends CrudService<OaCredentialsDao, OaCredentials> {

	public OaCredentials get(String id) {
		return super.get(id);
	}
	
	public List<OaCredentials> findList(OaCredentials oaCredentials) {
		return super.findList(oaCredentials);
	}
	
	public Page<OaCredentials> findPage(Page<OaCredentials> page, OaCredentials oaCredentials) {
		return super.findPage(page, oaCredentials);
	}
	
	@Transactional(readOnly = false)
	public void save(OaCredentials oaCredentials) {
		super.save(oaCredentials);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaCredentials oaCredentials) {
		super.delete(oaCredentials);
	}
	
}