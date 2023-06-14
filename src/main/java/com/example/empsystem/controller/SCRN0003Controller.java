package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.empsystem.helper.Interface.EV0003Helper;
import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0003Form;

@RequestMapping("employee/update")
@Controller
public class SCRN0003Controller {

	private final int NOT_EXIST_ERROR_SIZE = 0;

	private final EV0003Helper ev0003Helper;

	public SCRN0003Controller(EV0003Helper ev0003Helper) {
		this.ev0003Helper = ev0003Helper;
	}

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping()
	public String index(Model model) {
		SCRN0003Form scrn0003Form = ev0003Helper.init();

		model.addAttribute("form", scrn0003Form);
		model.addAttribute("selectedAffiriationCd", scrn0003Form.getEmployeeInfo().getAffiliationCd());
		model.addAttribute("selectedPositionCd", scrn0003Form.getEmployeeInfo().getPositionCd());

		return "SCRN0003";
	}

	/**
	 * 更新ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("execute")
	public String execute(@Validated @ModelAttribute EmployeeInfo empInfo, BindingResult result, Model model) {
		SCRN0003Form scrn0003Form = ev0003Helper.execute(empInfo, result);

		if (scrn0003Form.getResult().size() == NOT_EXIST_ERROR_SIZE) {
			return "SCRN0004";
		}

		model.addAttribute("form", scrn0003Form);
		model.addAttribute("selectedAffiriationCd", scrn0003Form.getEmployeeInfo().getAffiliationCd());
		model.addAttribute("selectedPositionCd", scrn0003Form.getEmployeeInfo().getPositionCd());

		return "SCRN0003";
	}

	/**
	 * 削除ボタン押下
	 * 
	 * @param empInfo
	 * @param model
	 * @return
	 */
	@PostMapping("delete")
	public String delete(@ModelAttribute EmployeeInfo empInfo, Model model) {
		SCRN0003Form scrn0003Form = ev0003Helper.delete(empInfo);

		if (scrn0003Form.getResult().size() == NOT_EXIST_ERROR_SIZE) {
			return "SCRN0004";
		}

		model.addAttribute("form", scrn0003Form);
		model.addAttribute("selectedAffiriationCd", scrn0003Form.getEmployeeInfo().getAffiliationCd());
		model.addAttribute("selectedPositionCd", scrn0003Form.getEmployeeInfo().getPositionCd());

		return "SCRN0003";
	}

	/**
	 * 戻る
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("back")
	public String back(Model model) {
		return "redirect:/employee";
	}
}
