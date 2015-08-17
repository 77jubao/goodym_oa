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
import cn.goodym.java.modules.oa.entity.OaProjectBudget;
import cn.goodym.java.modules.oa.service.OaProjectBudgetService;

/**
 * 项目预算管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaProjectBudget")
public class OaProjectBudgetController extends BaseController {

	@Autowired
	private OaProjectBudgetService oaProjectBudgetService;
	
	@ModelAttribute
	public OaProjectBudget get(@RequestParam(required=false) String id) {
		OaProjectBudget entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaProjectBudgetService.get(id);
		}
		if (entity == null){
			entity = new OaProjectBudget();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaProjectBudget:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaProjectBudget oaProjectBudget, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaProjectBudget> page = oaProjectBudgetService.findPage(new Page<OaProjectBudget>(request, response), oaProjectBudget); 
		model.addAttribute("page", page);
		return "modules/oa/oaProjectBudgetList";
	}

	@RequiresPermissions("oa:oaProjectBudget:view")
	@RequestMapping(value = "form")
	public String form(OaProjectBudget oaProjectBudget, Model model) {
		model.addAttribute("oaProjectBudget", oaProjectBudget);
		return "modules/oa/oaProjectBudgetForm";
	}

	@RequiresPermissions("oa:oaProjectBudget:edit")
	@RequestMapping(value = "save")
	public String save(OaProjectBudget oaProjectBudget, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaProjectBudget)){
			return form(oaProjectBudget, model);
		}
		oaProjectBudgetService.save(oaProjectBudget);
		addMessage(redirectAttributes, "保存项目预算记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaProjectBudget/?repage";
	}
	
	@RequiresPermissions("oa:oaProjectBudget:edit")
	@RequestMapping(value = "delete")
	public String delete(OaProjectBudget oaProjectBudget, RedirectAttributes redirectAttributes) {
		oaProjectBudgetService.delete(oaProjectBudget);
		addMessage(redirectAttributes, "删除项目预算记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaProjectBudget/?repage";
	}

}