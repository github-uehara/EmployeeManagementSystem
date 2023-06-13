package com.example.empsystem.helper.Interface;

import org.springframework.validation.BindingResult;

import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0002Form;

/**
 * 社員登録画面イベント定義 インタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV0002Helper {

	/**
	 * 初期表示
	 * 
	 * @return
	 */
	public SCRN0002Form init();

	/**
	 * 新規登録ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @return
	 */
	public SCRN0002Form entry(EmployeeInfo empInfo, BindingResult result);
}
