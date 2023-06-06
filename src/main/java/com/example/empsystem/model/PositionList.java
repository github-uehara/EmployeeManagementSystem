package com.example.empsystem.model;

/**
 * 役職情報リストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class PositionList {

	private String PositionCd;
	private String PositionNm;

	public String getPositionCd() {
		return PositionCd;
	}

	public void setPositionCd(String positionCd) {
		PositionCd = positionCd;
	}

	public String getPositionNm() {
		return PositionNm;
	}

	public void setPositionNm(String positionNm) {
		PositionNm = positionNm;
	}

}
