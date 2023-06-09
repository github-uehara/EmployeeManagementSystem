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

	private final EV0003Helper ev0003Helper;

	public SCRN0003Controller(EV0003Helper ev0003Helper) {
		this.ev0003Helper = ev0003Helper;
	}

	/**
	 * アクション : AC0003-01 <br>
	 * サマリー : EV0003-01を実行する
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@GetMapping()
	public String index(Model model) {
		SCRN0003Form scrn0003Form = ev0003Helper.init();

		model.addAttribute("form", scrn0003Form);
		model.addAttribute("selectedAffiriationCd", scrn0003Form.getEmployeeInfo().getAffiliationCd());
		model.addAttribute("selectedPositionCd", scrn0003Form.getEmployeeInfo().getPositionCd());

		return "SC0003";
	}

	/**
	 * アクション : AC0003-02 <br>
	 * サマリー : EV0003-02を実行する
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@PostMapping("execute")
	public String execute(@Validated @ModelAttribute EmployeeInfo empInfo, BindingResult result, Model model) {
		SCRN0003Form scrn0003Form;
		return "SC0003";
	}

	/**
	 * アクション : AC0003-03 <br>
	 * サマリー : EV0003-03を実行する
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@PostMapping("delete")
	public String delete(Model model) {
		SCRN0003Form scrn0003Form;
		return "SC0003";
	}

	/**
	 * アクション:AC0003-04 <br>
	 * サマリー:戻る
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@GetMapping("back")
	public String back(Model model) {
		return "redirect:/employee";
	}
}
