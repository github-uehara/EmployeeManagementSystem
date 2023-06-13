package com.example.empsystem.helper.Interface;

import org.springframework.validation.BindingResult;

import com.example.empsystem.model.SCRN0001Form;

/**
 * 社員管理システムメニュー画面イベント定義 インタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV0001Helper {

	/**
	 * 初期表示
	 * 
	 * @return
	 */
	public SCRN0001Form init();

	/**
	 * 社員照会・更新
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	public SCRN0001Form confirmUpdate(SCRN0001Form form, BindingResult result);

}
