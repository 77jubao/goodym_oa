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
import cn.goodym.java.modules.oa.entity.OaLeaves;
import cn.goodym.java.modules.oa.service.OaLeavesService;

/**
 * 请假记录Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaLeaves")
public class OaLeavesController extends BaseController {

	@Autowired
	private OaLeavesService oaLeavesService;
	
	@ModelAttribute
	public OaLeaves get(@RequestParam(required=false) String id) {
		OaLeaves entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaLeavesService.get(id);
		}
		if (entity == null){
			entity = new OaLeaves();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaLeaves:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaLeaves oaLeaves, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaLeaves> page = oaLeavesService.findPage(new Page<OaLeaves>(request, response), oaLeaves); 
		model.addAttribute("page", page);
		return "modules/oa/oaLeavesList";
	}

	@RequiresPermissions("oa:oaLeaves:view")
	@RequestMapping(value = "form")
	public String form(OaLeaves oaLeaves, Model model) {
		model.addAttribute("oaLeaves", oaLeaves);
		return "modules/oa/oaLeavesForm";
	}

	@RequiresPermissions("oa:oaLeaves:edit")
	@RequestMapping(value = "save")
	public String save(OaLeaves oaLeaves, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaLeaves)){
			return form(oaLeaves, model);
		}
		oaLeavesService.save(oaLeaves);
		addMessage(redirectAttributes, "保存请假记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaLeaves/?repage";
	}
	
	@RequiresPermissions("oa:oaLeaves:edit")
	@RequestMapping(value = "delete")
	public String delete(OaLeaves oaLeaves, RedirectAttributes redirectAttributes) {
		oaLeavesService.delete(oaLeaves);
		addMessage(redirectAttributes, "删除请假记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaLeaves/?repage";
	}

}