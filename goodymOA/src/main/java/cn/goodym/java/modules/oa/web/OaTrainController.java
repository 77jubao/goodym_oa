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
import cn.goodym.java.modules.oa.entity.OaTrain;
import cn.goodym.java.modules.oa.service.OaTrainService;

/**
 * 培训记录Controller
 * @author 77jubao
 * @version 2015-08-13
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaTrain")
public class OaTrainController extends BaseController {

	@Autowired
	private OaTrainService oaTrainService;
	
	@ModelAttribute
	public OaTrain get(@RequestParam(required=false) String id) {
		OaTrain entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaTrainService.get(id);
		}
		if (entity == null){
			entity = new OaTrain();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaTrain:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaTrain oaTrain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaTrain> page = oaTrainService.findPage(new Page<OaTrain>(request, response), oaTrain); 
		model.addAttribute("page", page);
		return "modules/oa/oaTrainList";
	}

	@RequiresPermissions("oa:oaTrain:view")
	@RequestMapping(value = "form")
	public String form(OaTrain oaTrain, Model model) {
		model.addAttribute("oaTrain", oaTrain);
		return "modules/oa/oaTrainForm";
	}

	@RequiresPermissions("oa:oaTrain:edit")
	@RequestMapping(value = "save")
	public String save(OaTrain oaTrain, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaTrain)){
			return form(oaTrain, model);
		}
		oaTrainService.save(oaTrain);
		addMessage(redirectAttributes, "保存培训记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaTrain/?repage";
	}
	
	@RequiresPermissions("oa:oaTrain:edit")
	@RequestMapping(value = "delete")
	public String delete(OaTrain oaTrain, RedirectAttributes redirectAttributes) {
		oaTrainService.delete(oaTrain);
		addMessage(redirectAttributes, "删除培训记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaTrain/?repage";
	}

}