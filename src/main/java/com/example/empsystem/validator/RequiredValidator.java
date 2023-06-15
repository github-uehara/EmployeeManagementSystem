package com.example.empsystem.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, Object> {
	/**
	 * 対応する日本語を返却するMapリスト <br>
	 * メッセージの国際化が出来たため、現在は不使用
	 */
	Map<String, String> map = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("employeeId", "社員ID");
			put("affiliationCd", "所属部署");
			put("positionCd", "役職");
			put("employeeNm", "社員名");
			put("gender", "性別");
			put("birthday", "生年月日");
			put("foreignNationality", "外国籍");
			put("baseSalary", "基本給料");
			put("memo", "メモ");

			put("AffiliationList", "所属管理");
			put("AffiliationCd", "所属コード");
			put("PositionList", "役職管理");
			put("PositionCd", "役職コード");
		}
	};

	private String field;

	/**
	 * 初期情報
	 */
	@Override
	public void initialize(Required constraintAnnotation) {
		this.field = constraintAnnotation.field();
	}

	/**
	 * 検証
	 */
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
		Object value = beanWrapper.getWrappedInstance();

		if (value.equals("")) {
			context.disableDefaultConstraintViolation();
			// メッセージを置き換える

			String newMessage = String.format("%sは必須です。", map.get(field));
			context.buildConstraintViolationWithTemplate(newMessage).addConstraintViolation();
			return false;
		}

		return true;
	}
}
