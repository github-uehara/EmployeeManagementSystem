package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.empsystem.helper.Interface.EV0002Helper;
import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0002Form;

@RequestMapping("employee/entry")
@Controller
public class SCRN0002Controller {

	private final EV0002Helper ev0002Helper;

	public SCRN0002Controller(EV0002Helper ev0002Helper) {
		this.ev0002Helper = ev0002Helper;
	}

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping()
	public String index(Model model) {
		SCRN0002Form form = ev0002Helper.init();
		model.addAttribute("form", form);

		return "SCRN0002";
	}

	/**
	 * アクション : AC0002-02 <br>
	 * サマリー : 新規登録
	 * 
	 * @param employeeInfo
	 * @param model
	 * @return
	 */
	@PostMapping("execute")
	public String execute(@Validated @ModelAttribute EmployeeInfo empInfo, BindingResult result, Model model) {
		SCRN0002Form scrn0002Form = ev0002Helper.entry(empInfo, result);

		model.addAttribute("form", scrn0002Form);
		model.addAttribute("selectedAffiriationCd", scrn0002Form.getEmployeeInfo().getAffiliationCd());
		model.addAttribute("selectedPositionCd", scrn0002Form.getEmployeeInfo().getPositionCd());

		return "SCRN0002";
	}

	/**
	 * アクション : AC0002-03 <br>
	 * サマリー : 戻る
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@GetMapping("back")
	public String back(Model model) {
		return "redirect:/employee";
	}
}
