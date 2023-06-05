package com.example.empsystem.helper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.empsystem.common.MessageList;
import com.example.empsystem.model.SCRN0001Model;
import com.example.empsystem.model.SessionScopeModel;

/**
 * EV0001Helperを実装するクラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV0001HelperImpl implements EV0001Helper {

	final String MSG_PARAM1 = "社員ID";
	final String MSG_PARAM2 = "%d文字";
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
	public SCRN0001Model init() {
		SCRN0001Model model = new SCRN0001Model(new String());

		return model;
	}

	/**
	 * 社員ID入力チェック
	 */
	@Override
	public SCRN0001Model confirmEmployeeId(SCRN0001Model htmlModel) {
		SCRN0001Model model = new SCRN0001Model();
		MessageList msgList = new MessageList();

		String empId = htmlModel.getEmployeeId();
		ArrayList<String> errorMsg = new ArrayList<String>();

		if (empId.isEmpty()) {
			errorMsg.add(msgList.COMMSG0001(MSG_PARAM1));
		}

		if (empId.length() != FIXED_EMP_ID_LENGTH) {
			errorMsg.add(msgList.COMMSG0002(MSG_PARAM1, String.format(MSG_PARAM2, FIXED_EMP_ID_LENGTH)));
		}

		// エラーメッセージがなければ、セッションに社員IDを設定する
		if (errorMsg.size() == NOT_EXIST_ERROR_SIZE) {
			session.setEmpId(empId);
		} else {
			model.setErrorMsg(errorMsg);
		}

		return model;
	}

}
