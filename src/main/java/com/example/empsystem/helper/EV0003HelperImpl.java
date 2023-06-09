package com.example.empsystem.helper;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.empsystem.common.MessageList;
import com.example.empsystem.helper.Interface.EV0003Helper;
import com.example.empsystem.logic.Interface.EV8001Logic;
import com.example.empsystem.logic.Interface.EV8002Logic;
import com.example.empsystem.logic.Interface.EV8003Logic;
import com.example.empsystem.model.AffiliationList;
import com.example.empsystem.model.EmployeeInfo;
import com.example.empsystem.model.PositionList;
import com.example.empsystem.model.SCRN0003Form;
import com.example.empsystem.model.SessionScopeModel;
import com.example.empsystem.model.DO.AffiliationDO;
import com.example.empsystem.model.DO.PositionDO;

/**
 * EV0002Helper実装クラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
@SessionAttributes(types = SessionScopeModel.class)
public class EV0003HelperImpl implements EV0003Helper {

	private final SessionScopeModel session;
	private final EV8001Logic ev8001;
	private final EV8002Logic ev8002;
	private final EV8003Logic ev8003;

	private MessageList msgList = new MessageList();

	/**
	 * コンストラクタ
	 * 
	 * @param session
	 */
	public EV0003HelperImpl(SessionScopeModel session, EV8001Logic ev8001, EV8002Logic ev8002, EV8003Logic ev8003) {
		this.session = session;
		this.ev8001 = ev8001;
		this.ev8002 = ev8002;
		this.ev8003 = ev8003;
	}

	/**
	 * 初期表示
	 * 
	 * @return
	 */
	@Override
	public SCRN0003Form init() {
		SCRN0003Form scrn0003Form = new SCRN0003Form();

		// 社員照会
		EmployeeInfo empInfo = ev8001.findByPrimaryKey(session.getEmployeeId());
		if (empInfo.getEmployeeId().isEmpty()) {
			scrn0003Form.getErrorList().add(msgList.EV00030001);
		}
		
		scrn0003Form.setEmployeeInfo(empInfo);

		// 部署・役職情報設定
		confirmSession(session);
		scrn0003Form.setAffiliationList(session.getAffiliationList());
		scrn0003Form.setPositionList(session.getPositonList());

		return scrn0003Form;
	}

	/**
	 * セッション確認
	 * 
	 * @param session
	 */
	private void confirmSession(SessionScopeModel session) {
		// セッションに部署情報が設定されているか確認する
		if (session.getAffiliationList() == null) {
			List<AffiliationDO> results = ev8002.findAll();

			List<AffiliationList> affiliationList = ev8002.converAffiliationList(results);
			session.setAffiliationList(affiliationList);
		}

		// セッションに役職情報が設定されているか確認する
		if (session.getPositonList() == null) {
			List<PositionDO> results = ev8003.findAll();

			List<PositionList> positionList = ev8003.converPositionList(results);
			session.setPositonList(positionList);
		}
	}

}
