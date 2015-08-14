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
import cn.goodym.java.modules.oa.entity.OaOvertime;
import cn.goodym.java.modules.oa.service.OaOvertimeService;

/**
 * 加班记录Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaOvertime")
public class OaOvertimeController extends BaseController {

	@Autowired
	private OaOvertimeService oaOvertimeService;
	
	@ModelAttribute
	public OaOvertime get(@RequestParam(required=false) String id) {
		OaOvertime entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaOvertimeService.get(id);
		}
		if (entity == null){
			entity = new OaOvertime();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaOvertime:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaOvertime oaOvertime, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaOvertime> page = oaOvertimeService.findPage(new Page<OaOvertime>(request, response), oaOvertime); 
		model.addAttribute("page", page);
		return "modules/oa/oaOvertimeList";
	}

	@RequiresPermissions("oa:oaOvertime:view")
	@RequestMapping(value = "form")
	public String form(OaOvertime oaOvertime, Model model) {
		model.addAttribute("oaOvertime", oaOvertime);
		return "modules/oa/oaOvertimeForm";
	}

	@RequiresPermissions("oa:oaOvertime:edit")
	@RequestMapping(value = "save")
	public String save(OaOvertime oaOvertime, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaOvertime)){
			return form(oaOvertime, model);
		}
		oaOvertimeService.save(oaOvertime);
		addMessage(redirectAttributes, "保存加班记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaOvertime/?repage";
	}
	
	@RequiresPermissions("oa:oaOvertime:edit")
	@RequestMapping(value = "delete")
	public String delete(OaOvertime oaOvertime, RedirectAttributes redirectAttributes) {
		oaOvertimeService.delete(oaOvertime);
		addMessage(redirectAttributes, "删除加班记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaOvertime/?repage";
	}

}