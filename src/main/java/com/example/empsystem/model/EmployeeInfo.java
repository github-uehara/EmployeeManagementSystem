package com.example.empsystem.model;

import java.math.BigDecimal;
import java.util.Date;

import com.example.empsystem.common.MessageList;

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

	private String employeeId;
	private String affiliationCd;
	private String positionCd;
	private String employeeNm;
	private int gender;
	private Date birthday;
	private Boolean foreignNationality;
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
