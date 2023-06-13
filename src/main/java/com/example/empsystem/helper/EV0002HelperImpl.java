package com.example.empsystem.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.empsystem.common.MessageList;
import com.example.empsystem.helper.Interface.EV0002Helper;
import com.example.empsystem.logic.Interface.EV8001Logic;
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
 * EV0002Helper実装クラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
@SessionAttributes(types = SessionScopeModel.class)
public class EV0002HelperImpl implements EV0002Helper {

	private final int NOT_EXIST_ERROR_SIZE = 0;

	private final MessageSource messageSource;
	private final SessionScopeModel session;
	private final EV8001Logic ev8001;
	private final EV8002Logic ev8002;
	private final EV8003Logic ev8003;
	private final MessageList messageList;

	/**
	 * コンストラクタ
	 */
	public EV0002HelperImpl(MessageSource messageSource, SessionScopeModel session, EV8001Logic ev8001,
			EV8002Logic ev8002, EV8003Logic ev8003, MessageList messageList) {
		this.messageSource = messageSource;
		this.session = session;
		this.ev8001 = ev8001;
		this.ev8002 = ev8002;
		this.ev8003 = ev8003;
		this.messageList = messageList;
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
		confirmSession(session);
		scrn0002Form.setAffiliationList(session.getAffiliationList());
		scrn0002Form.setPositionList(session.getPositonList());

		return scrn0002Form;
	}

	/**
	 * 新規登録ボタン押下
	 * 
	 * @param empInfo
	 * @param result
	 * @return
	 */
	@Override
	public SCRN0002Form entry(EmployeeInfo empInfo, BindingResult result) {
		SCRN0002Form scrn0002Form = new SCRN0002Form();

		// バリデーションチェックエラーがあれば、日本語のエラーメッセージを設定する
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				scrn0002Form.getResult().add(messageSource.getMessage(error, Locale.JAPANESE));
			}
		}
		scrn0002Form.setEmployeeInfo(empInfo);

		// セッションに部署情報が設定されているか確認する
		confirmSession(session);
		scrn0002Form.setAffiliationList(session.getAffiliationList());
		scrn0002Form.setPositionList(session.getPositonList());

		// 単項目チェックにエラーがあれば再表示
		if (scrn0002Form.getResult().size() != NOT_EXIST_ERROR_SIZE) {
			return scrn0002Form;
		}

		// 社員ID重複確認
		EmployeeInfo confirmEmpId = ev8001.findByPrimaryKey(scrn0002Form.getEmployeeInfo().getEmployeeId());
		if (!confirmEmpId.getEmployeeId().isEmpty()) {
			scrn0002Form.getResult().add(messageList.EV00020001);
		}

		// セッション情報改ざん確認
		ArrayList<String> sessionAffiliationList = new ArrayList<>();
		for (AffiliationList affiliation : session.getAffiliationList()) {
			sessionAffiliationList.add(affiliation.getAffiliationCd());
		}
		if (!sessionAffiliationList.contains(scrn0002Form.getEmployeeInfo().getAffiliationCd())) {
			scrn0002Form.getResult().add(messageList.DBMST00001("AffiliationList", "AffiliationCd"));
		}

		ArrayList<String> sessionPositionList = new ArrayList<>();
		for (PositionList potision : session.getPositonList()) {
			sessionPositionList.add(potision.getPositionCd());
		}
		if (!sessionPositionList.contains(scrn0002Form.getEmployeeInfo().getPositionCd())) {
			scrn0002Form.getResult().add(messageList.DBMST00001("PositionList", "PositionCd"));
		}

		// 相関チェックにエラーがあれば再表示
		if (scrn0002Form.getResult().size() != NOT_EXIST_ERROR_SIZE) {
			return scrn0002Form;
		}

		// 社員登録
		ev8001.register(scrn0002Form.getEmployeeInfo());

		return scrn0002Form;
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
