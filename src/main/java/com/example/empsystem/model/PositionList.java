package com.example.empsystem.model;

import com.example.empsystem.model.DO.PositionDO;

import lombok.Getter;
import lombok.Setter;

/**
 * 役職情報リスト管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
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

}
