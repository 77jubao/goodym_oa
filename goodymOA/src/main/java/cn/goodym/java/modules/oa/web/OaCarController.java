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
import cn.goodym.java.modules.oa.entity.OaCar;
import cn.goodym.java.modules.oa.service.OaCarService;

/**
 * 车辆管理Controller
 * @author 77jubao
 * @version 2015-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaCar")
public class OaCarController extends BaseController {

	@Autowired
	private OaCarService oaCarService;
	
	@ModelAttribute
	public OaCar get(@RequestParam(required=false) String id) {
		OaCar entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaCarService.get(id);
		}
		if (entity == null){
			entity = new OaCar();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaCar:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaCar oaCar, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaCar> page = oaCarService.findPage(new Page<OaCar>(request, response), oaCar); 
		model.addAttribute("page", page);
		return "modules/oa/oaCarList";
	}

	@RequiresPermissions("oa:oaCar:view")
	@RequestMapping(value = "form")
	public String form(OaCar oaCar, Model model) {
		model.addAttribute("oaCar", oaCar);
		return "modules/oa/oaCarForm";
	}

	@RequiresPermissions("oa:oaCar:edit")
	@RequestMapping(value = "save")
	public String save(OaCar oaCar, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaCar)){
			return form(oaCar, model);
		}
		oaCarService.save(oaCar);
		addMessage(redirectAttributes, "保存车辆管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCar/?repage";
	}
	
	@RequiresPermissions("oa:oaCar:edit")
	@RequestMapping(value = "delete")
	public String delete(OaCar oaCar, RedirectAttributes redirectAttributes) {
		oaCarService.delete(oaCar);
		addMessage(redirectAttributes, "删除车辆管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCar/?repage";
	}

}