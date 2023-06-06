package com.example.empsystem.model;

import com.example.empsystem.model.DO.AffiliationDO;

/**
 * 部署情報リストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class AffiliationList {

	private String AffiliationCd;
	private String AffiliationNm;

	public AffiliationList(AffiliationDO result) {
		this.AffiliationCd = result.AffiliationCd;
		this.AffiliationNm = result.AffiliationNm;
	}

	public String getAffiliationCd() {
		return AffiliationCd;
	}

	public void setAffiliationCd(String affiliationCd) {
		AffiliationCd = affiliationCd;
	}

	public String getAffiliationNm() {
		return AffiliationNm;
	}

	public void setAffiliationNm(String affiliationNm) {
		AffiliationNm = affiliationNm;
	}

}
