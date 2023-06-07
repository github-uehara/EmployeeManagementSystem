package com.example.empsystem.model.DO;

import java.util.Map;

/**
 * 役職マスタ情報を管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class PositionDO {

	public String positionCd;
	public String grandCd;
	public String rankCd;
	public String positionNm;

	public PositionDO(Map<String, Object> result) {
		this.positionCd = (String) result.get("position_cd");
		this.grandCd = (String) result.get("grand_cd");
		this.rankCd = (String) result.get("rank_cd");
		this.positionNm = (String) result.get("position_nm");
	}

	public String getPositionCd() {
		return positionCd;
	}

	public void setPositionCd(String positionCd) {
		this.positionCd = positionCd;
	}

	public String getGrandCd() {
		return grandCd;
	}

	public void setGrandCd(String grandCd) {
		this.grandCd = grandCd;
	}

	public String getRankCd() {
		return rankCd;
	}

	public void setRankCd(String rankCd) {
		this.rankCd = rankCd;
	}

	public String getPositionNm() {
		return positionNm;
	}

	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}

}
