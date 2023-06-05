package com.example.empsystem.model;

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
public class SessionScopeModel {

	private String empId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
}

