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
import cn.goodym.java.modules.oa.entity.OaRoom;
import cn.goodym.java.modules.oa.service.OaRoomService;

/**
 * 会议室管理Controller
 * @author 77jubao
 * @version 2015-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaRoom")
public class OaRoomController extends BaseController {

	@Autowired
	private OaRoomService oaRoomService;
	
	@ModelAttribute
	public OaRoom get(@RequestParam(required=false) String id) {
		OaRoom entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaRoomService.get(id);
		}
		if (entity == null){
			entity = new OaRoom();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaRoom:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaRoom oaRoom, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaRoom> page = oaRoomService.findPage(new Page<OaRoom>(request, response), oaRoom); 
		model.addAttribute("page", page);
		return "modules/oa/oaRoomList";
	}

	@RequiresPermissions("oa:oaRoom:view")
	@RequestMapping(value = "form")
	public String form(OaRoom oaRoom, Model model) {
		model.addAttribute("oaRoom", oaRoom);
		return "modules/oa/oaRoomForm";
	}

	@RequiresPermissions("oa:oaRoom:edit")
	@RequestMapping(value = "save")
	public String save(OaRoom oaRoom, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaRoom)){
			return form(oaRoom, model);
		}
		oaRoomService.save(oaRoom);
		addMessage(redirectAttributes, "保存会议室管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaRoom/?repage";
	}
	
	@RequiresPermissions("oa:oaRoom:edit")
	@RequestMapping(value = "delete")
	public String delete(OaRoom oaRoom, RedirectAttributes redirectAttributes) {
		oaRoomService.delete(oaRoom);
		addMessage(redirectAttributes, "删除会议室管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaRoom/?repage";
	}

}