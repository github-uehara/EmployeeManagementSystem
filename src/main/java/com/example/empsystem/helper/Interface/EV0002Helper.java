package com.example.empsystem.helper.Interface;

import java.util.ArrayList;

import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0002Model;

/**
 * 社員登録画面イベントを定義するインタフェース
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
	public SCRN0002Model init();

	/**
	 * 新規登録ボタン押下
	 * 
	 * @param empInfo
	 * @return
	 */
	public ArrayList<String> entry(EmployeeInfo empInfo);
}
