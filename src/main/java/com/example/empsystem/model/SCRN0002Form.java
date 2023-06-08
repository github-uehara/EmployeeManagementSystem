package com.example.empsystem.model;

import java.util.List;

/**
 * SCRN0002Formを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class SCRN0002Form {

	private EmployeeInfo employeeInfo;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positionList;
	private List<String> errorList;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0002Form() {
		this.employeeInfo = new EmployeeInfo();
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

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

}
