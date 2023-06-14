package com.example.empsystem.model;

import com.example.empsystem.model.DO.AffiliationDO;

import lombok.Getter;
import lombok.Setter;

/**
 * 部署情報リスト管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class AffiliationList {

	private String affiliationCd;
	private String affiliationNm;

	/**
	 * コンストラクタ
	 * 
	 * @param result
	 */
	public AffiliationList(AffiliationDO result) {
		this.affiliationCd = result.affiliationCd;
		this.affiliationNm = result.affiliationNm;
	}

}
