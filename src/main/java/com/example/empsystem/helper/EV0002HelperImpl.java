package com.example.empsystem.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.empsystem.helper.Interface.EV0002Helper;
import com.example.empsystem.logic.Interface.EV8002Logic;
import com.example.empsystem.model.AffiliationList;
import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.SCRN0002Model;
import com.example.empsystem.model.SessionScopeModel;
import com.example.empsystem.model.DO.AffiliationDO;

/**
 * EV0002Helperを実装するクラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
@SessionAttributes(types = SessionScopeModel.class)
public class EV0002HelperImpl implements EV0002Helper {

	private final SessionScopeModel session;
	private final EV8002Logic ev8002;

	/**
	 * コンストラクタ
	 * 
	 * @param session
	 */
	public EV0002HelperImpl(SessionScopeModel session, EV8002Logic ev8002) {
		this.session = session;
		this.ev8002 = ev8002;
	}

	@Override
	public SCRN0002Model init() {
		SCRN0002Model model = new SCRN0002Model();

		// セッションに役職情報が設定されているか確認する
		if (session.getAffiliationList() == null) {
			List<AffiliationDO> results = ev8002.findAll();

			List<AffiliationList> affiliationList = converAffiliationList(results);
			
			session.setAffiliationList(affiliationList);
		}
		model.setAffiliationList(session.getAffiliationList());

		return model;
	}

	@Override
	public ArrayList<String> entry(EmployeeInfo empInfo) {
		return null;
	}

	/**
	 * 部署マスタ情報をセッション用のモデルに変換する
	 * 
	 * @param results
	 * @return
	 */
	public List<AffiliationList> converAffiliationList(List<AffiliationDO> results) {
		List<AffiliationList> lists = new ArrayList<AffiliationList>();

		for (AffiliationDO result : results) {
			lists.add(new AffiliationList(result));
		}

		return lists;
	}

}
