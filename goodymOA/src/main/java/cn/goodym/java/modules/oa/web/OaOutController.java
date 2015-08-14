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
import cn.goodym.java.modules.oa.entity.OaOut;
import cn.goodym.java.modules.oa.service.OaOutService;

/**
 * 外出记录Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaOut")
public class OaOutController extends BaseController {

	@Autowired
	private OaOutService oaOutService;
	
	@ModelAttribute
	public OaOut get(@RequestParam(required=false) String id) {
		OaOut entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaOutService.get(id);
		}
		if (entity == null){
			entity = new OaOut();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaOut:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaOut oaOut, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaOut> page = oaOutService.findPage(new Page<OaOut>(request, response), oaOut); 
		model.addAttribute("page", page);
		return "modules/oa/oaOutList";
	}

	@RequiresPermissions("oa:oaOut:view")
	@RequestMapping(value = "form")
	public String form(OaOut oaOut, Model model) {
		model.addAttribute("oaOut", oaOut);
		return "modules/oa/oaOutForm";
	}

	@RequiresPermissions("oa:oaOut:edit")
	@RequestMapping(value = "save")
	public String save(OaOut oaOut, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaOut)){
			return form(oaOut, model);
		}
		oaOutService.save(oaOut);
		addMessage(redirectAttributes, "保存外出记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaOut/?repage";
	}
	
	@RequiresPermissions("oa:oaOut:edit")
	@RequestMapping(value = "delete")
	public String delete(OaOut oaOut, RedirectAttributes redirectAttributes) {
		oaOutService.delete(oaOut);
		addMessage(redirectAttributes, "删除外出记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaOut/?repage";
	}

}