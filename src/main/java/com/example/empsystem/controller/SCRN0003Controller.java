package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("employee/update")
@Controller
public class SCRN0003Controller {

	/**
	 * アクション : AC0002-01 <br>
	 * サマリー : EV0002-01を実行する
	 * 
	 * @param model
	 * @return アクション結果
	 */
	@PostMapping()
	public String index(Model model) {
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
