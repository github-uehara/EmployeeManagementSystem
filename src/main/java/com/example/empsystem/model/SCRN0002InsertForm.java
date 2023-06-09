package com.example.empsystem.model;

import com.example.empsystem.validator.Required;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新用フォーム
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class SCRN0002InsertForm {

	@Required(field = "employeeId")
	@Size(min = 8, max = 8)
	private String employeeId;

	@Required(field = "affiliationCd")
	private String affiliationCd;

	@Required(field = "positionCd")
	private String positionCd;

	@Required(field = "employeeNm")
	@Size(min = 1, max = 32)
	private String employeeNm;

	@Required(field = "gender")
	private int gender;

	@Required(field = "birthday")
	private String birthday;

	private Boolean foreignNationality;

	@Required(field = "baseSalary")
	private String baseSalary;

	private String memo;

}
