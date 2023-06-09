package com.example.empsystem.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 共通のメッセージリストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class MessageList {

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

	/**
	 * メッセージID : EV00020001
	 */
	public String EV00020001 = "既に登録済みの社員番号です。";

	/**
	 * メッセージID : EV00030001
	 */
	public String EV00030001 = "指定した社員IDでは、社員情報が照会できませんでした。";

	/**
	 * カテゴリ : 共通 <br>
	 * メッセージID : COMMSG0001 <br>
	 * メッセージ : {0}は必須です。
	 * 
	 * @param param1
	 * @return
	 */
	public String COMMSG0001(String param1) {
		String formatParam = map.get(param1);
		return String.format("%sは必須です。", formatParam);
	}

	/**
	 * カテゴリ : 共通 <br>
	 * メッセージID : COMMSG0002 <br>
	 * メッセージ : {0}は{1}で入力してください。
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public String COMMSG0002(String param1, String param2) {
		String formatParam = map.get(param1);
		return String.format("%sは%sで入力してください。", formatParam, param2);
	}

	/**
	 * カテゴリ : マスタ <br>
	 * メッセージID : DBMST00001 <br>
	 * メッセージ : {0}マスタに存在しない{1}を指定しています。
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public String DBMST00001(String param1, String param2) {
		String formatParam1 = map.get(param1);
		String formatParam2 = map.get(param2);
		return String.format("%sマスタに存在しない%sを指定しています。", formatParam1, formatParam2);
	}
}
