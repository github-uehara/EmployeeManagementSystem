package com.example.empsystem.helper.Interface;

import com.example.empsystem.model.SCRN0001Form;

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
	public SCRN0001Form init();

	/**
	 * 社員ID入力チェック
	 * 
	 * @param htmlModel
	 * @return
	 */
	public SCRN0001Form confirmEmployeeId(SCRN0001Form htmlModel);
}
