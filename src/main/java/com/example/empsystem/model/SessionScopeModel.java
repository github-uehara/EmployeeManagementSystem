package com.example.empsystem.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * コントローラ間でセッションを共有するためのクラス
 * 
 * @author DC-PCN1139
 *
 */
@Component
@SessionScope
public class SessionScopeModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String _MOD_EMPLOYEE_ID;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positonList;

	public String getEmployeeId() {
		return _MOD_EMPLOYEE_ID;
	}

	public void setEmployeeId(String employeeId) {
		this._MOD_EMPLOYEE_ID = employeeId;
	}

	public List<AffiliationList> getAffiliationList() {
		return affiliationList;
	}

	public void setAffiliationList(List<AffiliationList> affiliationList) {
		this.affiliationList = affiliationList;
	}

	public List<PositionList> getPositonList() {
		return positonList;
	}

	public void setPositonList(List<PositionList> positonList) {
		this.positonList = positonList;
	}

}
