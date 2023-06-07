package com.example.empsystem.logic.Interface;

import java.util.List;

import com.example.empsystem.model.PositionList;
import com.example.empsystem.model.DO.PositionDO;

/**
 * 役職マスタ情報取得・設定イベントを定義するインタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV8003Logic {

	/**
	 * 役職マスタ情報全件取得
	 * 
	 * @return
	 */
	public List<PositionDO> findAll();

	/**
	 * 役職マスタ情報をセッション用のモデルに変換する
	 * 
	 * @param results
	 * @return
	 */
	public List<PositionList> converPositionList(List<PositionDO> results);
}
