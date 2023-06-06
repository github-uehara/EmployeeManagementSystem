package com.example.empsystem.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

/**
 * 社員情報を管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class EmployeeInfo {

	final int FIXED_GENDER_MALE = 1;

	private String employeeId;
	private String affiliationCd;
	private String positionCd;
	private String employeeName;
	private int gender;
	private DateTime birthday;
	private Boolean foreignNationality;
	private BigDecimal BaseSalary;
	private String memo;

	/**
	 * コンストラクタ（引数なし）
	 */
	public EmployeeInfo() {
		this.employeeId = new String();
		this.affiliationCd = new String();
		this.positionCd = new String();
		this.employeeName = new String();
		this.gender = FIXED_GENDER_MALE;
		this.birthday = null;
		this.foreignNationality = false;
		this.BaseSalary = null;
		this.memo = new String();
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAffiliationCd() {
		return affiliationCd;
	}

	public void setAffiliationCd(String affiliationCd) {
		this.affiliationCd = affiliationCd;
	}

	public String getPositionCd() {
		return positionCd;
	}

	public void setPositionCd(String positionCd) {
		this.positionCd = positionCd;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public Boolean getForeignNationality() {
		return foreignNationality;
	}

	public void setForeignNationality(Boolean foreignNationality) {
		this.foreignNationality = foreignNationality;
	}

	public BigDecimal getBaseSalary() {
		return BaseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		BaseSalary = baseSalary;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
