package com.example.empsystem.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.empsystem.helper.Interface.EV0002Helper;
import com.example.empsystem.logic.Interface.EV8002Logic;
import com.example.empsystem.logic.Interface.EV8003Logic;
import com.example.empsystem.model.AffiliationList;
import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.PositionList;
import com.example.empsystem.model.SCRN0002Form;
import com.example.empsystem.model.SessionScopeModel;
import com.example.empsystem.model.DO.AffiliationDO;
import com.example.empsystem.model.DO.PositionDO;

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
	private final EV8003Logic ev8003;

	/**
	 * コンストラクタ
	 * 
	 * @param session
	 */
	public EV0002HelperImpl(SessionScopeModel session, EV8002Logic ev8002, EV8003Logic ev8003) {
		this.session = session;
		this.ev8002 = ev8002;
		this.ev8003 = ev8003;
	}

	/**
	 * 初期表示
	 * 
	 * @return
	 */
	@Override
	public SCRN0002Form init() {
		SCRN0002Form scrn0002Form = new SCRN0002Form();

		// セッションに部署情報が設定されているか確認する
		if (session.getAffiliationList() == null) {
			List<AffiliationDO> results = ev8002.findAll();

			List<AffiliationList> affiliationList = ev8002.converAffiliationList(results);
			session.setAffiliationList(affiliationList);
		}
		scrn0002Form.setAffiliationList(session.getAffiliationList());

		// セッションに役職情報が設定されているか確認する
		if (session.getPositonList() == null) {
			List<PositionDO> results = ev8003.findAll();

			List<PositionList> positionList = ev8003.converPositionList(results);
			session.setPositonList(positionList);
		}
		scrn0002Form.setPositionList(session.getPositonList());

		return scrn0002Form;
	}

	/**
	 * 新規登録ボタン押下
	 * 
	 * @param empInfo
	 * @return
	 */
	@Override
	public ArrayList<String> entry(EmployeeInfo empInfo) {
		return null;
	}

}
