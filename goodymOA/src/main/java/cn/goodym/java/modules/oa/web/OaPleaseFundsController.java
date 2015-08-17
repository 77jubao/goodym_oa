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
import cn.goodym.java.modules.oa.entity.OaPleaseFunds;
import cn.goodym.java.modules.oa.service.OaPleaseFundsService;

/**
 * 请款管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaPleaseFunds")
public class OaPleaseFundsController extends BaseController {

	@Autowired
	private OaPleaseFundsService oaPleaseFundsService;
	
	@ModelAttribute
	public OaPleaseFunds get(@RequestParam(required=false) String id) {
		OaPleaseFunds entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaPleaseFundsService.get(id);
		}
		if (entity == null){
			entity = new OaPleaseFunds();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaPleaseFunds:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaPleaseFunds oaPleaseFunds, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaPleaseFunds> page = oaPleaseFundsService.findPage(new Page<OaPleaseFunds>(request, response), oaPleaseFunds); 
		model.addAttribute("page", page);
		return "modules/oa/oaPleaseFundsList";
	}

	@RequiresPermissions("oa:oaPleaseFunds:view")
	@RequestMapping(value = "form")
	public String form(OaPleaseFunds oaPleaseFunds, Model model) {
		model.addAttribute("oaPleaseFunds", oaPleaseFunds);
		return "modules/oa/oaPleaseFundsForm";
	}

	@RequiresPermissions("oa:oaPleaseFunds:edit")
	@RequestMapping(value = "save")
	public String save(OaPleaseFunds oaPleaseFunds, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaPleaseFunds)){
			return form(oaPleaseFunds, model);
		}
		oaPleaseFundsService.save(oaPleaseFunds);
		addMessage(redirectAttributes, "保存请款记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaPleaseFunds/?repage";
	}
	
	@RequiresPermissions("oa:oaPleaseFunds:edit")
	@RequestMapping(value = "delete")
	public String delete(OaPleaseFunds oaPleaseFunds, RedirectAttributes redirectAttributes) {
		oaPleaseFundsService.delete(oaPleaseFunds);
		addMessage(redirectAttributes, "删除请款记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaPleaseFunds/?repage";
	}

}