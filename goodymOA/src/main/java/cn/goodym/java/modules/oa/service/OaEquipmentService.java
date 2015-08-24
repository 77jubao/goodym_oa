package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaEquipment;
import cn.goodym.java.modules.oa.dao.OaEquipmentDao;

/**
 * 设备信息Service
 * @author 77jubao
 * @version 2015-08-24
 */
@Service
@Transactional(readOnly = true)
public class OaEquipmentService extends CrudService<OaEquipmentDao, OaEquipment> {

	public OaEquipment get(String id) {
		return super.get(id);
	}
	
	public List<OaEquipment> findList(OaEquipment oaEquipment) {
		return super.findList(oaEquipment);
	}
	
	public Page<OaEquipment> findPage(Page<OaEquipment> page, OaEquipment oaEquipment) {
		return super.findPage(page, oaEquipment);
	}
	
	@Transactional(readOnly = false)
	public void save(OaEquipment oaEquipment) {
		super.save(oaEquipment);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaEquipment oaEquipment) {
		super.delete(oaEquipment);
	}
	
}