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
import cn.goodym.java.modules.oa.entity.OaEquipment;
import cn.goodym.java.modules.oa.service.OaEquipmentService;

/**
 * 设备信息Controller
 * @author 77jubao
 * @version 2015-08-24
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaEquipment")
public class OaEquipmentController extends BaseController {

	@Autowired
	private OaEquipmentService oaEquipmentService;
	
	@ModelAttribute
	public OaEquipment get(@RequestParam(required=false) String id) {
		OaEquipment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaEquipmentService.get(id);
		}
		if (entity == null){
			entity = new OaEquipment();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaEquipment:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaEquipment oaEquipment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaEquipment> page = oaEquipmentService.findPage(new Page<OaEquipment>(request, response), oaEquipment); 
		model.addAttribute("page", page);
		return "modules/oa/oaEquipmentList";
	}

	@RequiresPermissions("oa:oaEquipment:view")
	@RequestMapping(value = "form")
	public String form(OaEquipment oaEquipment, Model model) {
		model.addAttribute("oaEquipment", oaEquipment);
		return "modules/oa/oaEquipmentForm";
	}

	@RequiresPermissions("oa:oaEquipment:edit")
	@RequestMapping(value = "save")
	public String save(OaEquipment oaEquipment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaEquipment)){
			return form(oaEquipment, model);
		}
		oaEquipmentService.save(oaEquipment);
		addMessage(redirectAttributes, "保存设备信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaEquipment/?repage";
	}
	
	@RequiresPermissions("oa:oaEquipment:edit")
	@RequestMapping(value = "delete")
	public String delete(OaEquipment oaEquipment, RedirectAttributes redirectAttributes) {
		oaEquipmentService.delete(oaEquipment);
		addMessage(redirectAttributes, "删除设备信息记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaEquipment/?repage";
	}

}