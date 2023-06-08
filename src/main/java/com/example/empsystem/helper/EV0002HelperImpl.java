package com.example.empsystem.helper;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
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
import com.example.empsystem.model.SCRN0002InsertForm;
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

	final String MSG_FORMAT_PARAM1 = "%d文字";
	final String MSG_FORMAT_PARAM2 = "%d文字以下";
	final String MSG_PARAM1 = "yyyy/MM/dd";
	final String MSG_PARAM2 = "10000.00";
	final int FIXED_EMP_ID_LENGTH = 8;
	final int FIXED_MAX_EMPNM = 32;
	final int NOT_EXIST_ERROR_SIZE = 0;

	final int MALE = 1;
	final int FEMALE = 2;
	final int OTHER = 3;

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
	public EV0002HelperImpl(SessionScopeModel session, EV8001Logic ev8001, EV8002Logic ev8002, EV8003Logic ev8003) {
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
	 * @param insertForm
	 * @return
	 */
	@Override
	public SCRN0002Form entry(SCRN0002InsertForm insertForm) {
		SCRN0002Form scrn0002Form = new SCRN0002Form();

		// 単項目チェック
		validationCheck(scrn0002Form, insertForm);

		// セッションに部署情報が設定されているか確認する
		confirmSession(session);
		scrn0002Form.setAffiliationList(session.getAffiliationList());
		scrn0002Form.setPositionList(session.getPositonList());

		// 単項目チェックにエラーがあれば再表示
		if (scrn0002Form.getErrorList().size() != NOT_EXIST_ERROR_SIZE) {
			return scrn0002Form;
		}

		// 社員ID重複確認
		EmployeeInfo empInfo = ev8001.findByPrimaryKey(scrn0002Form.getEmployeeInfo().getEmployeeId());
		if (!empInfo.getEmployeeId().isEmpty()) {
			scrn0002Form.getErrorList().add(msgList.EV00020001);
		}

		// セッション情報改ざん確認
		ArrayList<String> sessionAffiliationList = new ArrayList<>();
		for (AffiliationList affiliation : session.getAffiliationList()) {
			sessionAffiliationList.add(affiliation.getAffiliationCd());
		}
		if (!sessionAffiliationList.contains(scrn0002Form.getEmployeeInfo().getAffiliationCd())) {
			scrn0002Form.getErrorList().add(msgList.DBMST00001("AffiliationList", "AffiliationCd"));
		}

		ArrayList<String> sessionPositionList = new ArrayList<>();
		for (PositionList potision : session.getPositonList()) {
			sessionPositionList.add(potision.getPositionCd());
		}
		if (!sessionPositionList.contains(scrn0002Form.getEmployeeInfo().getPositionCd())) {
			scrn0002Form.getErrorList().add(msgList.DBMST00001("PositionList", "PositionCd"));
		}

		// 相関チェックにエラーがあれば再表示
		if (scrn0002Form.getErrorList().size() != NOT_EXIST_ERROR_SIZE) {
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

	/**
	 * 単項目チェック
	 * 
	 * @param scrn0002Form
	 * @param insertForm
	 * @return
	 */
	private SCRN0002Form validationCheck(SCRN0002Form scrn0002Form, SCRN0002InsertForm insertForm) {
		ArrayList<String> errorList = new ArrayList<>();
		EmployeeInfo empInfo = scrn0002Form.getEmployeeInfo();

		if (insertForm.getEmployeeId().isEmpty()) {
			// 社員ID:必須
			errorList.add(msgList.COMMSG0001("employeeId"));
		} else if (insertForm.getEmployeeId().length() != FIXED_EMP_ID_LENGTH) {
			// 社員ID:桁数
			errorList.add(msgList.COMMSG0002("employeeId", String.format(MSG_FORMAT_PARAM1, FIXED_EMP_ID_LENGTH)));
		} else {
			empInfo.setEmployeeId(insertForm.getEmployeeId());
		}

		if (insertForm.getAffiliationCd().isEmpty()) {
			// 所属部署:必須
			errorList.add(msgList.COMMSG0001("affiliationCd"));
		} else {
			empInfo.setAffiliationCd(insertForm.getAffiliationCd());
		}

		if (insertForm.getPositionCd().isEmpty()) {
			// 役職:必須
			errorList.add(msgList.COMMSG0001("positionCd"));
		} else {
			empInfo.setPositionCd(insertForm.getPositionCd());
		}

		if (insertForm.getEmployeeNm().isEmpty()) {
			// 社員名:必須
			errorList.add(msgList.COMMSG0001("employeeNm"));
		} else if (insertForm.getEmployeeNm().length() > FIXED_MAX_EMPNM) {
			// 社員名:桁数
			errorList.add(msgList.COMMSG0002("employeeNm", String.format(MSG_FORMAT_PARAM2, FIXED_MAX_EMPNM)));
		} else {
			empInfo.setEmployeeNm(insertForm.getEmployeeNm());
		}

		try {
			if (!((int) insertForm.getGender() == MALE || (int) insertForm.getGender() == FEMALE
					|| (int) insertForm.getGender() == OTHER)) {
				// 性別:必須
				errorList.add(msgList.COMMSG0001("gender"));
			} else {
				empInfo.setGender(insertForm.getGender());
			}
		} catch (Exception ex) {
		}

		try {
			if (insertForm.getBirthday().isEmpty()) {
				// 生年月日:必須
				errorList.add(msgList.COMMSG0001("birthday"));
			} else {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				empInfo.setBirthday(format.parse(insertForm.getBirthday()));
			}
		} catch (Exception ex) {
			// 生年月日:書式
			errorList.add(msgList.COMMSG0002("birthday", String.format(MSG_PARAM1, "")));
		}

		try {
			if (insertForm.getBaseSalary().isEmpty()) {
				// 基本給料:必須
				errorList.add(msgList.COMMSG0001("baseSalary"));
			} else {
				BigDecimal decimal = new BigDecimal(insertForm.getBaseSalary());
				empInfo.setBaseSalary(decimal);
			}
		} catch (Exception ex) {
			// 基本給料:書式
			errorList.add(msgList.COMMSG0002("baseSalary", String.format(MSG_PARAM2, "")));
		}

		empInfo.setForeignNationality(insertForm.getForeignNationality());
		empInfo.setMemo(insertForm.getMemo());

		scrn0002Form.setEmployeeInfo(empInfo);
		scrn0002Form.setErrorList(errorList);
		return scrn0002Form;
	}

}
