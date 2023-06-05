package com.example.empsystem.model;

import java.util.ArrayList;

/**
 * SCRN0001Modelを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class SCRN0001Model {

	/**
	 * employeeId : 社員ID errorMsg : エラーメッセージリスト
	 */
	private String employeeId;
	private ArrayList<String> errorMsg;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0001Model() {
	}

	/**
	 * コンストラクタ（引数あり）
	 * 
	 * @param employeeId 社員ID
	 */
	public SCRN0001Model(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public ArrayList<String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(ArrayList<String> errorMsg) {
		this.errorMsg = errorMsg;
	}
}
