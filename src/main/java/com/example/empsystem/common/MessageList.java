package com.example.empsystem.common;

/**
 * 共通のメッセージリストを管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class MessageList {

	/**
	 * カテゴリ : 共通 <br>
	 * メッセージID : COMMSG0001 <br>
	 * メッセージ : {0}は必須です。
	 * 
	 * @param param1
	 * @return
	 */
	public String COMMSG0001(String param1) {
		return String.format("%sは必須です。", param1);
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
		return String.format("%sは%sで入力してください。", param1, param2);
	}
}
