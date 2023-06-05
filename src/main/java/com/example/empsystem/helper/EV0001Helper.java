package com.example.empsystem.helper;

import com.example.empsystem.model.SCRN0001Model;

/**
 * 社員管理システムメニュー画面イベントを定義するインタフェース
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
	public SCRN0001Model init();

	/**
	 * 社員ID入力チェック
	 * 
	 * @param htmlModel
	 * @return
	 */
	public SCRN0001Model confirmEmployeeId(SCRN0001Model htmlModel);
}
