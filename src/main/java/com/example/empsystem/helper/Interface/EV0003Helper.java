package com.example.empsystem.helper.Interface;

import org.springframework.validation.BindingResult;

import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0003Form;

/**
 * 社員照会・更新画面イベント定義 インタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV0003Helper {

	/**
	 * 初期表示
	 * 
	 * @return
	 */
	public SCRN0003Form init();

	/**
	 * 更新ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @return
	 */
	public SCRN0003Form execute(EmployeeInfo empInfo, BindingResult result);
	
	/**
	 * 削除ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @return
	 */
	public SCRN0003Form delete(EmployeeInfo empInfo, BindingResult result);
}
