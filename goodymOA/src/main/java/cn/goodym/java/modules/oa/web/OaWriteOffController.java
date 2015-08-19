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
import cn.goodym.java.modules.oa.entity.OaWriteOff;
import cn.goodym.java.modules.oa.service.OaWriteOffService;

/**
 * 报销管理Controller
 * @author 77jubao
 * @version 2015-08-19
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaWriteOff")
public class OaWriteOffController extends BaseController {

	@Autowired
	private OaWriteOffService oaWriteOffService;
	
	@ModelAttribute
	public OaWriteOff get(@RequestParam(required=false) String id) {
		OaWriteOff entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaWriteOffService.get(id);
		}
		if (entity == null){
			entity = new OaWriteOff();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaWriteOff:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaWriteOff oaWriteOff, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaWriteOff> page = oaWriteOffService.findPage(new Page<OaWriteOff>(request, response), oaWriteOff); 
		model.addAttribute("page", page);
		return "modules/oa/oaWriteOffList";
	}

	@RequiresPermissions("oa:oaWriteOff:view")
	@RequestMapping(value = "form")
	public String form(OaWriteOff oaWriteOff, Model model) {
		model.addAttribute("oaWriteOff", oaWriteOff);
		return "modules/oa/oaWriteOffForm";
	}

	@RequiresPermissions("oa:oaWriteOff:edit")
	@RequestMapping(value = "save")
	public String save(OaWriteOff oaWriteOff, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaWriteOff)){
			return form(oaWriteOff, model);
		}
		oaWriteOffService.save(oaWriteOff);
		addMessage(redirectAttributes, "保存报销记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaWriteOff/?repage";
	}
	
	@RequiresPermissions("oa:oaWriteOff:edit")
	@RequestMapping(value = "delete")
	public String delete(OaWriteOff oaWriteOff, RedirectAttributes redirectAttributes) {
		oaWriteOffService.delete(oaWriteOff);
		addMessage(redirectAttributes, "删除报销记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaWriteOff/?repage";
	}

}