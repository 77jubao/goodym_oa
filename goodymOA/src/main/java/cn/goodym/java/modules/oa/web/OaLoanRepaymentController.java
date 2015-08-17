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
import cn.goodym.java.modules.oa.entity.OaLoanRepayment;
import cn.goodym.java.modules.oa.service.OaLoanRepaymentService;

/**
 * 借款还款管理Controller
 * @author 77jubao
 * @version 2015-08-17
 */
@Controller
@RequestMapping(value = "${adminPath}/oa/oaLoanRepayment")
public class OaLoanRepaymentController extends BaseController {

	@Autowired
	private OaLoanRepaymentService oaLoanRepaymentService;
	
	@ModelAttribute
	public OaLoanRepayment get(@RequestParam(required=false) String id) {
		OaLoanRepayment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = oaLoanRepaymentService.get(id);
		}
		if (entity == null){
			entity = new OaLoanRepayment();
		}
		return entity;
	}
	
	@RequiresPermissions("oa:oaLoanRepayment:view")
	@RequestMapping(value = {"list", ""})
	public String list(OaLoanRepayment oaLoanRepayment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OaLoanRepayment> page = oaLoanRepaymentService.findPage(new Page<OaLoanRepayment>(request, response), oaLoanRepayment); 
		model.addAttribute("page", page);
		return "modules/oa/oaLoanRepaymentList";
	}

	@RequiresPermissions("oa:oaLoanRepayment:view")
	@RequestMapping(value = "form")
	public String form(OaLoanRepayment oaLoanRepayment, Model model) {
		model.addAttribute("oaLoanRepayment", oaLoanRepayment);
		return "modules/oa/oaLoanRepaymentForm";
	}

	@RequiresPermissions("oa:oaLoanRepayment:edit")
	@RequestMapping(value = "save")
	public String save(OaLoanRepayment oaLoanRepayment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, oaLoanRepayment)){
			return form(oaLoanRepayment, model);
		}
		oaLoanRepaymentService.save(oaLoanRepayment);
		addMessage(redirectAttributes, "保存借款还款管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaLoanRepayment/?repage";
	}
	
	@RequiresPermissions("oa:oaLoanRepayment:edit")
	@RequestMapping(value = "delete")
	public String delete(OaLoanRepayment oaLoanRepayment, RedirectAttributes redirectAttributes) {
		oaLoanRepaymentService.delete(oaLoanRepayment);
		addMessage(redirectAttributes, "删除借款还款管理成功");
		return "redirect:"+Global.getAdminPath()+"/oa/oaLoanRepayment/?repage";
	}

}