package com.example.empsystem.logic.Interface;

import com.example.empsystem.model.EmployeeInfo;

/**
 * 社員情報取得(PK)定義インタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV8001Logic {

	/**
	 * 社員情報取得(PK)
	 * 
	 * @param employeeId
	 * @return
	 */
	public EmployeeInfo findByPrimaryKey(String employeeId);

	/**
	 * 社員情報登録
	 * 
	 * @param empInfo
	 */
	public void register(EmployeeInfo empInfo);
}
