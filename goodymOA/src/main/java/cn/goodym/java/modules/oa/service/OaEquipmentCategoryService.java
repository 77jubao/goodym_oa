package cn.goodym.java.modules.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.service.CrudService;
import cn.goodym.java.modules.oa.entity.OaEquipmentCategory;
import cn.goodym.java.modules.oa.dao.OaEquipmentCategoryDao;

/**
 * 设备类型Service
 * @author 77jubao
 * @version 2015-08-24
 */
@Service
@Transactional(readOnly = true)
public class OaEquipmentCategoryService extends CrudService<OaEquipmentCategoryDao, OaEquipmentCategory> {

	public OaEquipmentCategory get(String id) {
		return super.get(id);
	}
	
	public List<OaEquipmentCategory> findList(OaEquipmentCategory oaEquipmentCategory) {
		return super.findList(oaEquipmentCategory);
	}
	
	public Page<OaEquipmentCategory> findPage(Page<OaEquipmentCategory> page, OaEquipmentCategory oaEquipmentCategory) {
		return super.findPage(page, oaEquipmentCategory);
	}
	
	@Transactional(readOnly = false)
	public void save(OaEquipmentCategory oaEquipmentCategory) {
		super.save(oaEquipmentCategory);
	}
	
	@Transactional(readOnly = false)
	public void delete(OaEquipmentCategory oaEquipmentCategory) {
		super.delete(oaEquipmentCategory);
	}
	
}