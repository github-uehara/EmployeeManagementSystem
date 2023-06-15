package com.example.empsystem.helper;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

	private final MessageSource messageSource;
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
	public EV0003HelperImpl(MessageSource messageSource, SessionScopeModel session, EV8001Logic ev8001,
			EV8002Logic ev8002, EV8003Logic ev8003) {
		this.messageSource = messageSource;
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
		EmployeeInfo empInfo = ev8001.findByPrimaryKey(session.get_MOD_EMPLOYEE_ID());
		if (empInfo.getEmployeeId().isEmpty()) {
			scrn0003Form.getResult().add(msgList.EV00030001);
		}

		scrn0003Form.setEmployeeInfo(empInfo);

		// 部署・役職情報設定
		confirmSession(session);
		scrn0003Form.setAffiliationList(session.getAffiliationList());
		scrn0003Form.setPositionList(session.getPositonList());

		return scrn0003Form;
	}

	/**
	 * 更新ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @return
	 */
	public SCRN0003Form execute(EmployeeInfo empInfo, BindingResult result) {
		SCRN0003Form scrn0003Form = new SCRN0003Form();
		
		// バリデーションチェックエラーがあれば、日本語のエラーメッセージを設定する
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				scrn0003Form.getResult().add(messageSource.getMessage(error, Locale.JAPANESE));
			}
		} else {
			EmployeeInfo existEmpInfo = ev8001.findByPrimaryKey(empInfo.getEmployeeId());
			if (!(existEmpInfo.getEmployeeId().isEmpty())) {
				ev8001.update(empInfo);
			} else {
				scrn0003Form.getResult().add(msgList.EV00030002);
			}
		}
		
		// 社員情報設定
		scrn0003Form.setEmployeeInfo(empInfo);
		confirmSession(session);
		scrn0003Form.setAffiliationList(session.getAffiliationList());
		scrn0003Form.setPositionList(session.getPositonList());

		return scrn0003Form;
	}

	/**
	 * 削除ボタン押下
	 * 
	 * @param empInfo
	 * @return
	 */
	public SCRN0003Form delete(EmployeeInfo empInfo) {
		SCRN0003Form scrn0003Form = new SCRN0003Form();

		// 社員情報設定
		scrn0003Form.setEmployeeInfo(empInfo);
		confirmSession(session);
		scrn0003Form.setAffiliationList(session.getAffiliationList());
		scrn0003Form.setPositionList(session.getPositonList());

		// 社員削除
		EmployeeInfo existEmpInfo = ev8001.findByPrimaryKey(empInfo.getEmployeeId());
		if (!(existEmpInfo.getEmployeeId().isEmpty())) {
			ev8001.delete(empInfo.getEmployeeId());
		} else {
			scrn0003Form.getResult().add(msgList.EV00030003);
		}

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
