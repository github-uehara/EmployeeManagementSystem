package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.empsystem.helper.EV0001Helper;
import com.example.empsystem.model.SCRN0001Model;

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

	private final EV0001Helper ev0001Helper;

	/**
	 * コンストラクタ
	 * 
	 * @param ev0001Helper
	 */
	public SCRN0001Controller(EV0001Helper ev0001Helper) {
		this.ev0001Helper = ev0001Helper;
	}

	/*
	 * 初期表示
	 */
	@GetMapping({ "", "menu" })
	public String index(Model model) {
		SCRN0001Model scrn0001Model = ev0001Helper.init();
		model.addAttribute("model", scrn0001Model);

		return "SC0001";
	}

	/*
	 * 社員照会・更新
	 */
	@PostMapping("confirmUpdate")
	public String confirmUpdate(@ModelAttribute("model") SCRN0001Model htmlModel, Model model) {
		SCRN0001Model scrn0001Model = ev0001Helper.confirmEmployeeId(htmlModel);

		model.addAttribute("model", scrn0001Model);

		// バリエーションチェックエラーがあれば再表示
		if (scrn0001Model.getErrorMsg() != null) {
			return "SC0001";
		}

		return "SC0003";
	}
}
