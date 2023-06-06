package com.example.empsystem.model;

import java.util.List;

/**
 * SCRN0002Modelを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class SCRN0002Model {

	private EmployeeInfo employeeInfo;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positionList;
	private List<String> errorMsg;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0002Model() {
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public List<AffiliationList> getAffiliationList() {
		return affiliationList;
	}

	public void setAffiliationList(List<AffiliationList> affiliationList) {
		this.affiliationList = affiliationList;
	}

	public List<PositionList> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<PositionList> positionList) {
		this.positionList = positionList;
	}

	public List<String> getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(List<String> errorMsg) {
		this.errorMsg = errorMsg;
	}

}
