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
import cn.goodym.java.modules.oa.entity.OaAttendance;
import cn.goodym.java.modules.oa.service.OaAttendanceService;

/**
 * 出勤记录Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaAttendance")
public class OaAttendanceController extends BaseController {

	@Autowired
	private OaAttendanceService oaAttendanceService;
	
	@ModelAttribute
	public OaAttendance get(@RequestParam(required=false) String id) {
		OaAttendance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaAttendanceService.get(id);
		}
		if (entity == null){
			entity = new OaAttendance();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaAttendance:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaAttendance oaAttendance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaAttendance> page = oaAttendanceService.findPage(new Page<OaAttendance>(request, response), oaAttendance); 
		model.addAttribute("page", page);
		return "modules/oa/oaAttendanceList";
	}

	@RequiresPermissions("oa:oaAttendance:view")
	@RequestMapping(value = "form")
	public String form(OaAttendance oaAttendance, Model model) {
		model.addAttribute("oaAttendance", oaAttendance);
		return "modules/oa/oaAttendanceForm";
	}

	@RequiresPermissions("oa:oaAttendance:edit")
	@RequestMapping(value = "save")
	public String save(OaAttendance oaAttendance, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaAttendance)){
			return form(oaAttendance, model);
		}
		oaAttendanceService.save(oaAttendance);
		addMessage(redirectAttributes, "保存出勤记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaAttendance/?repage";
	}
	
	@RequiresPermissions("oa:oaAttendance:edit")
	@RequestMapping(value = "delete")
	public String delete(OaAttendance oaAttendance, RedirectAttributes redirectAttributes) {
		oaAttendanceService.delete(oaAttendance);
		addMessage(redirectAttributes, "删除出勤记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaAttendance/?repage";
	}

}