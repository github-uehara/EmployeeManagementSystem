package com.example.empsystem.logic.Interface;

import java.util.List;

import com.example.empsystem.model.AffiliationList;
import com.example.empsystem.model.DO.AffiliationDO;

/**
 * 部署マスタ情報取得・設定イベントを定義するインタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV8002Logic {

	/**
	 * 部署マスタ情報全件取得
	 * 
	 * @return
	 */
	public List<AffiliationDO> findAll();

	/**
	 * 部署マスタ情報をセッション用のモデルに変換する
	 * 
	 * @param results
	 * @return
	 */
	public List<AffiliationList> converAffiliationList(List<AffiliationDO> results);
}
