package com.example.empsystem.logic.Interface;

import java.util.List;

import com.example.empsystem.model.DO.AffiliationDO;

/**
 * 部署情報取得(全件)イベントを定義するインタフェース
 * 
 * @author DC-PCN1139
 *
 */
public interface EV8002Logic {

	/**
	 * 所属管理情報取得
	 * 
	 * @return
	 */
	public List<AffiliationDO> findAll();
}
