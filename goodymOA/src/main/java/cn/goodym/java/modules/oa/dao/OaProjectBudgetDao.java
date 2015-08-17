/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.dao;

import cn.goodym.java.common.persistence.CrudDao;
import cn.goodym.java.common.persistence.annotation.MyBatisDao;
import cn.goodym.java.modules.oa.entity.OaProjectBudget;

/**
 * 项目预算管理DAO接口
 * @author 77jubao
 * @version 2015-08-17
 */
@MyBatisDao
public interface OaProjectBudgetDao extends CrudDao<OaProjectBudget> {
	
}