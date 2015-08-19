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
import cn.goodym.java.modules.oa.entity.OaCredentials;
import cn.goodym.java.modules.oa.service.OaCredentialsService;

/**
 * 证件管理Controller
 * @author 77jubao
 * @version 2015-08-19
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaCredentials")
public class OaCredentialsController extends BaseController {

	@Autowired
	private OaCredentialsService oaCredentialsService;
	
	@ModelAttribute
	public OaCredentials get(@RequestParam(required=false) String id) {
		OaCredentials entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaCredentialsService.get(id);
		}
		if (entity == null){
			entity = new OaCredentials();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaCredentials:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaCredentials oaCredentials, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaCredentials> page = oaCredentialsService.findPage(new Page<OaCredentials>(request, response), oaCredentials); 
		model.addAttribute("page", page);
		return "modules/oa/oaCredentialsList";
	}

	@RequiresPermissions("oa:oaCredentials:view")
	@RequestMapping(value = "form")
	public String form(OaCredentials oaCredentials, Model model) {
		model.addAttribute("oaCredentials", oaCredentials);
		return "modules/oa/oaCredentialsForm";
	}

	@RequiresPermissions("oa:oaCredentials:edit")
	@RequestMapping(value = "save")
	public String save(OaCredentials oaCredentials, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaCredentials)){
			return form(oaCredentials, model);
		}
		oaCredentialsService.save(oaCredentials);
		addMessage(redirectAttributes, "保存证件记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCredentials/?repage";
	}
	
	@RequiresPermissions("oa:oaCredentials:edit")
	@RequestMapping(value = "delete")
	public String delete(OaCredentials oaCredentials, RedirectAttributes redirectAttributes) {
		oaCredentialsService.delete(oaCredentials);
		addMessage(redirectAttributes, "删除证件记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCredentials/?repage";
	}

}