package com.example.empsystem.model;

import com.example.empsystem.model.DO.PositionDO;

/**
 * 役職情報リストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class PositionList {

	private String positionCd;
	private String positionNm;

	/**
	 * コンストラクタ
	 * 
	 * @param positionDo
	 */
	public PositionList(PositionDO positionDo) {
		this.positionCd = positionDo.getPositionCd();
		this.positionNm = positionDo.getPositionNm();
	}

	public String getPositionCd() {
		return positionCd;
	}

	public void setPositionCd(String positionCd) {
		this.positionCd = positionCd;
	}

	public String getPositionNm() {
		return positionNm;
	}

	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}

}
