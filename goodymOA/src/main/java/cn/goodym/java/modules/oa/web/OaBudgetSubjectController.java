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
import cn.goodym.java.modules.oa.entity.OaBudgetSubject;
import cn.goodym.java.modules.oa.service.OaBudgetSubjectService;

/**
 * 预算科目管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaBudgetSubject")
public class OaBudgetSubjectController extends BaseController {

	@Autowired
	private OaBudgetSubjectService oaBudgetSubjectService;
	
	@ModelAttribute
	public OaBudgetSubject get(@RequestParam(required=false) String id) {
		OaBudgetSubject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaBudgetSubjectService.get(id);
		}
		if (entity == null){
			entity = new OaBudgetSubject();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaBudgetSubject:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaBudgetSubject oaBudgetSubject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaBudgetSubject> page = oaBudgetSubjectService.findPage(new Page<OaBudgetSubject>(request, response), oaBudgetSubject); 
		model.addAttribute("page", page);
		return "modules/oa/oaBudgetSubjectList";
	}

	@RequiresPermissions("oa:oaBudgetSubject:view")
	@RequestMapping(value = "form")
	public String form(OaBudgetSubject oaBudgetSubject, Model model) {
		model.addAttribute("oaBudgetSubject", oaBudgetSubject);
		return "modules/oa/oaBudgetSubjectForm";
	}

	@RequiresPermissions("oa:oaBudgetSubject:edit")
	@RequestMapping(value = "save")
	public String save(OaBudgetSubject oaBudgetSubject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaBudgetSubject)){
			return form(oaBudgetSubject, model);
		}
		oaBudgetSubjectService.save(oaBudgetSubject);
		addMessage(redirectAttributes, "保存预算科目记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaBudgetSubject/?repage";
	}
	
	@RequiresPermissions("oa:oaBudgetSubject:edit")
	@RequestMapping(value = "delete")
	public String delete(OaBudgetSubject oaBudgetSubject, RedirectAttributes redirectAttributes) {
		oaBudgetSubjectService.delete(oaBudgetSubject);
		addMessage(redirectAttributes, "删除预算科目记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaBudgetSubject/?repage";
	}

}