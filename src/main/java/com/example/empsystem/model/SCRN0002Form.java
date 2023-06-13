package com.example.empsystem.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * SCRN0002Form管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class SCRN0002Form {

	private EmployeeInfo employeeInfo;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positionList;
	private List<String> result;

	/**
	 * コンストラクタ
	 */
	public SCRN0002Form() {
		this.employeeInfo = new EmployeeInfo();
		this.result = new ArrayList<String>();
	}

}
