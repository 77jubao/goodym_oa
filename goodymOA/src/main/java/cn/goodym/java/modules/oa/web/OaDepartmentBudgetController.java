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
import cn.goodym.java.modules.oa.entity.OaDepartmentBudget;
import cn.goodym.java.modules.oa.service.OaDepartmentBudgetService;

/**
 * 部门预算管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaDepartmentBudget")
public class OaDepartmentBudgetController extends BaseController {

	@Autowired
	private OaDepartmentBudgetService oaDepartmentBudgetService;
	
	@ModelAttribute
	public OaDepartmentBudget get(@RequestParam(required=false) String id) {
		OaDepartmentBudget entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaDepartmentBudgetService.get(id);
		}
		if (entity == null){
			entity = new OaDepartmentBudget();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaDepartmentBudget:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaDepartmentBudget oaDepartmentBudget, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaDepartmentBudget> page = oaDepartmentBudgetService.findPage(new Page<OaDepartmentBudget>(request, response), oaDepartmentBudget); 
		model.addAttribute("page", page);
		return "modules/oa/oaDepartmentBudgetList";
	}

	@RequiresPermissions("oa:oaDepartmentBudget:view")
	@RequestMapping(value = "form")
	public String form(OaDepartmentBudget oaDepartmentBudget, Model model) {
		model.addAttribute("oaDepartmentBudget", oaDepartmentBudget);
		return "modules/oa/oaDepartmentBudgetForm";
	}

	@RequiresPermissions("oa:oaDepartmentBudget:edit")
	@RequestMapping(value = "save")
	public String save(OaDepartmentBudget oaDepartmentBudget, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaDepartmentBudget)){
			return form(oaDepartmentBudget, model);
		}
		oaDepartmentBudgetService.save(oaDepartmentBudget);
		addMessage(redirectAttributes, "保存部门预算成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaDepartmentBudget/?repage";
	}
	
	@RequiresPermissions("oa:oaDepartmentBudget:edit")
	@RequestMapping(value = "delete")
	public String delete(OaDepartmentBudget oaDepartmentBudget, RedirectAttributes redirectAttributes) {
		oaDepartmentBudgetService.delete(oaDepartmentBudget);
		addMessage(redirectAttributes, "删除部门预算成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaDepartmentBudget/?repage";
	}

}