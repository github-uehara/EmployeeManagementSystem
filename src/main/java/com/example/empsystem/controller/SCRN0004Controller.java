package com.example.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("employee/complete")
@Controller
public class SCRN0004Controller {

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping()
	public String index(Model model) {
		return "SCRN0004";
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
