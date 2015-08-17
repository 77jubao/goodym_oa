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
import cn.goodym.java.modules.oa.entity.OaFeeSubject;
import cn.goodym.java.modules.oa.service.OaFeeSubjectService;

/**
 * 费用科目管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaFeeSubject")
public class OaFeeSubjectController extends BaseController {

	@Autowired
	private OaFeeSubjectService oaFeeSubjectService;
	
	@ModelAttribute
	public OaFeeSubject get(@RequestParam(required=false) String id) {
		OaFeeSubject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaFeeSubjectService.get(id);
		}
		if (entity == null){
			entity = new OaFeeSubject();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaFeeSubject:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaFeeSubject oaFeeSubject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaFeeSubject> page = oaFeeSubjectService.findPage(new Page<OaFeeSubject>(request, response), oaFeeSubject); 
		model.addAttribute("page", page);
		return "modules/oa/oaFeeSubjectList";
	}

	@RequiresPermissions("oa:oaFeeSubject:view")
	@RequestMapping(value = "form")
	public String form(OaFeeSubject oaFeeSubject, Model model) {
		model.addAttribute("oaFeeSubject", oaFeeSubject);
		return "modules/oa/oaFeeSubjectForm";
	}

	@RequiresPermissions("oa:oaFeeSubject:edit")
	@RequestMapping(value = "save")
	public String save(OaFeeSubject oaFeeSubject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaFeeSubject)){
			return form(oaFeeSubject, model);
		}
		oaFeeSubjectService.save(oaFeeSubject);
		addMessage(redirectAttributes, "保存费用科目记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaFeeSubject/?repage";
	}
	
	@RequiresPermissions("oa:oaFeeSubject:edit")
	@RequestMapping(value = "delete")
	public String delete(OaFeeSubject oaFeeSubject, RedirectAttributes redirectAttributes) {
		oaFeeSubjectService.delete(oaFeeSubject);
		addMessage(redirectAttributes, "删除费用科目记录成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaFeeSubject/?repage";
	}

}