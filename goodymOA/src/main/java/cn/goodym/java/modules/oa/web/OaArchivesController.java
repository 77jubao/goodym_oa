/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package cn.goodym.java.modules.oa.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.goodym.java.common.config.Global;
import cn.goodym.java.common.persistence.Page;
import cn.goodym.java.common.web.BaseController;
import cn.goodym.java.common.utils.StringUtils;
import cn.goodym.java.modules.oa.entity.OaArchives;
import cn.goodym.java.modules.oa.service.OaArchivesService;

/**
 * 档案管理Controller
 * @author 77jubao
 * @version 2015-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaArchives")
public class OaArchivesController extends BaseController {

	@Autowired
	private OaArchivesService oaArchivesService;
	
	@ModelAttribute
	public OaArchives get(@RequestParam(required=false) String id) {
		OaArchives entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaArchivesService.get(id);
		}
		if (entity == null){
			entity = new OaArchives();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaArchives:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaArchives oaArchives, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaArchives> page = oaArchivesService.findPage(new Page<OaArchives>(request, response), oaArchives); 
		model.addAttribute("page", page);
		return "modules/oa/oaArchivesList";
	}

	@RequiresPermissions("oa:oaArchives:view")
	@RequestMapping(value = "form")
	public String form(OaArchives oaArchives, Model model) {
		model.addAttribute("oaArchives", oaArchives);
		return "modules/oa/oaArchivesForm";
	}

	@RequiresPermissions("oa:oaArchives:edit")
	@RequestMapping(value = "save")
	public String save(OaArchives oaArchives, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaArchives)){
			return form(oaArchives, model);
		}
		oaArchivesService.save(oaArchives);
		addMessage(redirectAttributes, "保存档案成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaArchives/?repage";
	}
	
	@RequiresPermissions("oa:oaArchives:edit")
	@RequestMapping(value = "delete")
	public String delete(OaArchives oaArchives, RedirectAttributes redirectAttributes) {
		oaArchivesService.delete(oaArchives);
		addMessage(redirectAttributes, "删除档案成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaArchives/?repage";
	}

}