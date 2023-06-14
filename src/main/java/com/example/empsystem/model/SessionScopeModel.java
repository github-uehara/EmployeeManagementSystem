package com.example.empsystem.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

/**
 * コントローラ間でセッションを共有するためのクラス
 * 
 * @author DC-PCN1139
 *
 */
@Component
@SessionScope
@Getter
@Setter
public class SessionScopeModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String _MOD_EMPLOYEE_ID;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positonList;

}
