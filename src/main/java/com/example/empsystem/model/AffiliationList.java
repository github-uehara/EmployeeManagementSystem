package com.example.empsystem.model;

import com.example.empsystem.model.DO.AffiliationDO;

/**
 * 部署情報リストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
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

	public String getAffiliationCd() {
		return affiliationCd;
	}

	public void setAffiliationCd(String affiliationCd) {
		this.affiliationCd = affiliationCd;
	}

	public String getAffiliationNm() {
		return affiliationNm;
	}

	public void setAffiliationNm(String affiliationNm) {
		this.affiliationNm = affiliationNm;
	}

}
