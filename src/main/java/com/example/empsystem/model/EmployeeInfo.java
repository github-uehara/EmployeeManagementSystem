package com.example.empsystem.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.empsystem.common.MessageList;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 社員情報管理モデル
 * 
 * @author DC-PCN1139
 *
 */
@Getter
@Setter
public class EmployeeInfo {

	final int FIXED_GENDER_MALE = 1;

	private MessageList msgList = new MessageList();

	@NotEmpty
	@Size(min = 8, max = 8)
	private String employeeId;

	@NotEmpty
	private String affiliationCd;

	@NotEmpty
	private String positionCd;

	@NotEmpty
	@Size(min = 2, max = 32)
	private String employeeNm;

	private int gender;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private Boolean foreignNationality;

	@NotNull
	@Digits(integer = 5, fraction = 2)
	private BigDecimal baseSalary;

	private String memo;

	public EmployeeInfo() {
		this.employeeId = new String();
		this.affiliationCd = new String();
		this.positionCd = new String();
		this.employeeNm = new String();
		this.gender = FIXED_GENDER_MALE;
		this.birthday = null;
		this.foreignNationality = false;
		this.baseSalary = null;
		this.memo = new String();
	}

}
