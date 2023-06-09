package com.example.empsystem.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * SCRN0003Form管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class SCRN0003Form {

	private EmployeeInfo employeeInfo;
	private List<AffiliationList> affiliationList;
	private List<PositionList> positionList;
	private List<String> errorList;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0003Form() {
		this.employeeInfo = new EmployeeInfo();
		this.errorList = new ArrayList<String>();
	}

}
