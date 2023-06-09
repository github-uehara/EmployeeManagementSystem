package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.empsystem.helper.Interface.EV0001Helper;
import com.example.empsystem.model.SCRN0001Form;

/**
 * 社員管理システムメニュー画面 コントローラ
 * 
 * @author DC-PCN1139
 *
 */
@RequestMapping("employee")
@Controller
public class SCRN0001Controller {

	final int NOT_EXIST_ERROR_SIZE = 0;

	// DI
	private final EV0001Helper ev0001Helper;

	/**
	 * コンストラクタ
	 * 
	 * @param ev0001Helper
	 */
	public SCRN0001Controller(EV0001Helper ev0001Helper) {
		this.ev0001Helper = ev0001Helper;
	}

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping({ "", "menu" })
	public String index(Model model) {
		SCRN0001Form form = ev0001Helper.init();
		model.addAttribute("form", form);

		return "SCRN0001";
	}

	/**
	 * 社員照会・更新
	 * 
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("confirmUpdate")
	public String confirmUpdate(@Validated @ModelAttribute SCRN0001Form form, BindingResult result, Model model) {
		form = ev0001Helper.confirmUpdate(form, result);
		model.addAttribute("form", form);

		if (result.hasErrors()) {
			return "SCRN0001";
		}

		return "redirect:/employee/update";
	}
}
