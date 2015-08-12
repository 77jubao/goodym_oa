/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaRoom;
import cn.goodym.java.modules.oa.dao.OaRoomDao;

/**
 * 会议室管理Service
 * @author 77jubao
 * @version 2015-08-12
 */
@Service
@Transactional(readOnly = true)
public class OaRoomService extends CrudService<OaRoomDao, OaRoom> {

	public OaRoom get(String id) {
		return super.get(id);
	}
	
	public List<OaRoom> findList(OaRoom oaRoom) {
		return super.findList(oaRoom);
	}
	
	public Page<OaRoom> findPage(Page<OaRoom> page, OaRoom oaRoom) {
		return super.findPage(page, oaRoom);
	}
	
	@Transactional(readOnly = false)
	public void save(OaRoom oaRoom) {
		super.save(oaRoom);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaRoom oaRoom) {
		super.delete(oaRoom);
	}
	
}