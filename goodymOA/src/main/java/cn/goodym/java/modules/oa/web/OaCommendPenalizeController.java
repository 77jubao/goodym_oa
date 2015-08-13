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
import cn.goodym.java.modules.oa.entity.OaCommendPenalize;
import cn.goodym.java.modules.oa.service.OaCommendPenalizeService;

/**
 * 奖惩记录Controller
 * @author 77jubao
 * @version 2015-08-13
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaCommendPenalize")
public class OaCommendPenalizeController extends BaseController {

	@Autowired
	private OaCommendPenalizeService oaCommendPenalizeService;
	
	@ModelAttribute
	public OaCommendPenalize get(@RequestParam(required=false) String id) {
		OaCommendPenalize entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaCommendPenalizeService.get(id);
		}
		if (entity == null){
			entity = new OaCommendPenalize();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaCommendPenalize:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaCommendPenalize oaCommendPenalize, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaCommendPenalize> page = oaCommendPenalizeService.findPage(new Page<OaCommendPenalize>(request, response), oaCommendPenalize); 
		model.addAttribute("page", page);
		return "modules/oa/oaCommendPenalizeList";
	}

	@RequiresPermissions("oa:oaCommendPenalize:view")
	@RequestMapping(value = "form")
	public String form(OaCommendPenalize oaCommendPenalize, Model model) {
		model.addAttribute("oaCommendPenalize", oaCommendPenalize);
		return "modules/oa/oaCommendPenalizeForm";
	}

	@RequiresPermissions("oa:oaCommendPenalize:edit")
	@RequestMapping(value = "save")
	public String save(OaCommendPenalize oaCommendPenalize, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaCommendPenalize)){
			return form(oaCommendPenalize, model);
		}
		oaCommendPenalizeService.save(oaCommendPenalize);
		addMessage(redirectAttributes, "保存奖惩记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCommendPenalize/?repage";
	}
	
	@RequiresPermissions("oa:oaCommendPenalize:edit")
	@RequestMapping(value = "delete")
	public String delete(OaCommendPenalize oaCommendPenalize, RedirectAttributes redirectAttributes) {
		oaCommendPenalizeService.delete(oaCommendPenalize);
		addMessage(redirectAttributes, "删除奖惩记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaCommendPenalize/?repage";
	}

}