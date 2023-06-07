package com.example.empsystem.model;

import java.util.List;

/**
 * SCRN0001Modelを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class SCRN0001Form {

	private String employeeId;
	private List<String> errorMsg;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0001Form() {
		this.employeeId = new String();
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public List<String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(List<String> errorMsg) {
		this.errorMsg = errorMsg;
	}
}
