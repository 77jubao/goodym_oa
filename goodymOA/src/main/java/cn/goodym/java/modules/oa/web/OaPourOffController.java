
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
import cn.goodym.java.modules.oa.entity.OaPourOff;
import cn.goodym.java.modules.oa.service.OaPourOffService;

/**
 * 倒休管理Controller
 * @author 77jubao
 * @version 2015-08-14
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaPourOff")
public class OaPourOffController extends BaseController {

	@Autowired
	private OaPourOffService oaPourOffService;
	
	@ModelAttribute
	public OaPourOff get(@RequestParam(required=false) String id) {
		OaPourOff entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaPourOffService.get(id);
		}
		if (entity == null){
			entity = new OaPourOff();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaPourOff:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaPourOff oaPourOff, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaPourOff> page = oaPourOffService.findPage(new Page<OaPourOff>(request, response), oaPourOff); 
		model.addAttribute("page", page);
		return "modules/oa/oaPourOffList";
	}

	@RequiresPermissions("oa:oaPourOff:view")
	@RequestMapping(value = "form")
	public String form(OaPourOff oaPourOff, Model model) {
		model.addAttribute("oaPourOff", oaPourOff);
		return "modules/oa/oaPourOffForm";
	}

	@RequiresPermissions("oa:oaPourOff:edit")
	@RequestMapping(value = "save")
	public String save(OaPourOff oaPourOff, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaPourOff)){
			return form(oaPourOff, model);
		}
		oaPourOffService.save(oaPourOff);
		addMessage(redirectAttributes, "保存倒休记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaPourOff/?repage";
	}
	
	@RequiresPermissions("oa:oaPourOff:edit")
	@RequestMapping(value = "delete")
	public String delete(OaPourOff oaPourOff, RedirectAttributes redirectAttributes) {
		oaPourOffService.delete(oaPourOff);
		addMessage(redirectAttributes, "删除倒休记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaPourOff/?repage";
	}

}