package com.example.empsystem.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.empsystem.common.MessageList;
import com.example.empsystem.helper.Interface.EV0001Helper;
import com.example.empsystem.model.SCRN0001Form;
import com.example.empsystem.model.SessionScopeModel;

/**
 * EV0001Helperを実装するクラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV0001HelperImpl implements EV0001Helper {

	final String MSG_PARAM = "%d文字";
	final int FIXED_EMP_ID_LENGTH = 8;
	final int NOT_EXIST_ERROR_SIZE = 0;

	private final SessionScopeModel session;

	/**
	 * コンストラクタ
	 * 
	 * @param session
	 */
	public EV0001HelperImpl(SessionScopeModel session) {
		this.session = session;
	}

	/**
	 * 初期表示
	 */
	@Override
	public SCRN0001Form init() {
		SCRN0001Form model = new SCRN0001Form();

		return model;
	}

	/**
	 * 社員ID入力チェック
	 */
	@Override
	public SCRN0001Form confirmEmployeeId(SCRN0001Form scrn0001form) {
		SCRN0001Form form = new SCRN0001Form();
		MessageList msgList = new MessageList();

		String empId = scrn0001form.getEmployeeId();
		List<String> errorMsg = new ArrayList<String>();

		if (empId.isEmpty()) {
			errorMsg.add(msgList.COMMSG0001("employeeId"));
		}

		if (empId.length() != FIXED_EMP_ID_LENGTH) {
			errorMsg.add(msgList.COMMSG0002("employeeId", String.format(MSG_PARAM, FIXED_EMP_ID_LENGTH)));
		}

		// エラーメッセージがなければ、セッションに社員IDを設定する
		if (errorMsg.size() == NOT_EXIST_ERROR_SIZE) {
			session.setEmployeeId(empId);
		} else {
			form.setErrorMsg(errorMsg);
		}

		return form;
	}

}
