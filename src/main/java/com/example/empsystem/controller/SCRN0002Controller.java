package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.empsystem.helper.Interface.EV0002Helper;
import com.example.empsystem.model.SCRN0002Model;

@RequestMapping("employee/entry")
@Controller
public class SCRN0002Controller {

	private final EV0002Helper ev0002Helper;

	public SCRN0002Controller(EV0002Helper ev0002Helper) {
		this.ev0002Helper = ev0002Helper;
	}

	/**
	 * アクション : AC0002-01 <br>
	 * サマリー : EV0002-01を実行する
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@PostMapping()
	public String index(Model model) {
		SCRN0002Model scrn0002Model = ev0002Helper.init();
		model.addAttribute("model", scrn0002Model);

		return "SC0002";
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
