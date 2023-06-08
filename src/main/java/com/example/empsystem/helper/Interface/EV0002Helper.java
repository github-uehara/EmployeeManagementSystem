package com.example.empsystem.helper.Interface;

import com.example.empsystem.model.SCRN0002Form;
import com.example.empsystem.model.SCRN0002InsertForm;

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
	 * @param insertForm
	 * @return
	 */
	public SCRN0002Form entry(SCRN0002InsertForm insertForm);
}
