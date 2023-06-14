package com.example.empsystem.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * SCRN0001Form管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class SCRN0001Form {

	@NotEmpty
	@Size(min = 8, max = 8)
	private String employeeId;
	private List<String> result;

	/**
	 * コンストラクタ（引数なし）
	 */
	public SCRN0001Form() {
		this.employeeId = new String();
		this.result = new ArrayList<>();
	}

}
