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
import cn.goodym.java.modules.oa.entity.OaBusinessTrip;
import cn.goodym.java.modules.oa.service.OaBusinessTripService;

/**
 * 出差管理Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaBusinessTrip")
public class OaBusinessTripController extends BaseController {

	@Autowired
	private OaBusinessTripService oaBusinessTripService;
	
	@ModelAttribute
	public OaBusinessTrip get(@RequestParam(required=false) String id) {
		OaBusinessTrip entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaBusinessTripService.get(id);
		}
		if (entity == null){
			entity = new OaBusinessTrip();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaBusinessTrip:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaBusinessTrip oaBusinessTrip, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaBusinessTrip> page = oaBusinessTripService.findPage(new Page<OaBusinessTrip>(request, response), oaBusinessTrip); 
		model.addAttribute("page", page);
		return "modules/oa/oaBusinessTripList";
	}

	@RequiresPermissions("oa:oaBusinessTrip:view")
	@RequestMapping(value = "form")
	public String form(OaBusinessTrip oaBusinessTrip, Model model) {
		model.addAttribute("oaBusinessTrip", oaBusinessTrip);
		return "modules/oa/oaBusinessTripForm";
	}

	@RequiresPermissions("oa:oaBusinessTrip:edit")
	@RequestMapping(value = "save")
	public String save(OaBusinessTrip oaBusinessTrip, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaBusinessTrip)){
			return form(oaBusinessTrip, model);
		}
		oaBusinessTripService.save(oaBusinessTrip);
		addMessage(redirectAttributes, "保存出差记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaBusinessTrip/?repage";
	}
	
	@RequiresPermissions("oa:oaBusinessTrip:edit")
	@RequestMapping(value = "delete")
	public String delete(OaBusinessTrip oaBusinessTrip, RedirectAttributes redirectAttributes) {
		oaBusinessTripService.delete(oaBusinessTrip);
		addMessage(redirectAttributes, "删除出差记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaBusinessTrip/?repage";
	}

}