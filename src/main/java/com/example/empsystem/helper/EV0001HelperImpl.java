package com.example.empsystem.helper;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.example.empsystem.helper.Interface.EV0001Helper;
import com.example.empsystem.model.SCRN0001Form;
import com.example.empsystem.model.SessionScopeModel;

/**
 * EV0001Helper実装クラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV0001HelperImpl implements EV0001Helper {

	private MessageSource messageSource;
	private SessionScopeModel session;

	/**
	 * コンストラクタ
	 */
	public EV0001HelperImpl(MessageSource messageSource, SessionScopeModel session) {
		this.messageSource = messageSource;
		this.session = session;
	}

	/**
	 * 初期表示
	 */
	@Override
	public SCRN0001Form init() {
		return new SCRN0001Form();
	}

	/**
	 * 社員照会・更新
	 * 
	 * @param form
	 * @param result
	 * @return
	 */
	@Override
	public SCRN0001Form confirmUpdate(SCRN0001Form form, BindingResult result) {

		// バリデーションチェックエラーがあれば、日本語のエラーメッセージを設定する
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				form.getResult().add(messageSource.getMessage(error, Locale.JAPANESE));
			}
		} else {
			session.set_MOD_EMPLOYEE_ID(form.getEmployeeId());
		}

		return form;
	}

}
