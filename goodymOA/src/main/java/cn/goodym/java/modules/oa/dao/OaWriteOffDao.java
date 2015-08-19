/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.dao;

import cn.goodym.java.common.persistence.CrudDao;
import cn.goodym.java.common.persistence.annotation.MyBatisDao;
import cn.goodym.java.modules.oa.entity.OaWriteOff;

/**
 * 报销管理DAO接口
 * @author 77jubao
 * @version 2015-08-19
 */
@MyBatisDao
public interface OaWriteOffDao extends CrudDao<OaWriteOff> {
	
}