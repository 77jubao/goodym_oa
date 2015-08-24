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
import cn.goodym.java.modules.oa.entity.OaEquipmentCategory;
import cn.goodym.java.modules.oa.service.OaEquipmentCategoryService;

/**
 * 设备类型Controller
 * @author 77jubao
 * @version 2015-08-24
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaEquipmentCategory")
public class OaEquipmentCategoryController extends BaseController {

	@Autowired
	private OaEquipmentCategoryService oaEquipmentCategoryService;
	
	@ModelAttribute
	public OaEquipmentCategory get(@RequestParam(required=false) String id) {
		OaEquipmentCategory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaEquipmentCategoryService.get(id);
		}
		if (entity == null){
			entity = new OaEquipmentCategory();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaEquipmentCategory:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaEquipmentCategory oaEquipmentCategory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaEquipmentCategory> page = oaEquipmentCategoryService.findPage(new Page<OaEquipmentCategory>(request, response), oaEquipmentCategory); 
		model.addAttribute("page", page);
		return "modules/oa/oaEquipmentCategoryList";
	}

	@RequiresPermissions("oa:oaEquipmentCategory:view")
	@RequestMapping(value = "form")
	public String form(OaEquipmentCategory oaEquipmentCategory, Model model) {
		model.addAttribute("oaEquipmentCategory", oaEquipmentCategory);
		return "modules/oa/oaEquipmentCategoryForm";
	}

	@RequiresPermissions("oa:oaEquipmentCategory:edit")
	@RequestMapping(value = "save")
	public String save(OaEquipmentCategory oaEquipmentCategory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaEquipmentCategory)){
			return form(oaEquipmentCategory, model);
		}
		oaEquipmentCategoryService.save(oaEquipmentCategory);
		addMessage(redirectAttributes, "保存设备类型记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaEquipmentCategory/?repage";
	}
	
	@RequiresPermissions("oa:oaEquipmentCategory:edit")
	@RequestMapping(value = "delete")
	public String delete(OaEquipmentCategory oaEquipmentCategory, RedirectAttributes redirectAttributes) {
		oaEquipmentCategoryService.delete(oaEquipmentCategory);
		addMessage(redirectAttributes, "删除设备类型记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaEquipmentCategory/?repage";
	}

}