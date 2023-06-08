package com.example.empsystem.model;

/**
 * 更新用フォーム
 * 
 * @author DC-PCN1139
 *
 */
public class SCRN0002InsertForm {

	private String employeeId;
	private String affiliationCd;
	private String positionCd;
	private String employeeNm;
	private int gender;
	private String birthday;
	private Boolean foreignNationality;
	private String baseSalary;
	private String memo;

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

	public String getEmployeeNm() {
		return employeeNm;
	}

	public void setEmployeeNm(String employeeNm) {
		this.employeeNm = employeeNm;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Boolean getForeignNationality() {
		return foreignNationality;
	}

	public void setForeignNationality(Boolean foreignNationality) {
		this.foreignNationality = foreignNationality;
	}

	public String getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "SCRN0002InsertForm [employeeId=" + employeeId + ", affiliationCd=" + affiliationCd + ", positionCd="
				+ positionCd + ", employeeNm=" + employeeNm + ", gender=" + gender + ", birthday=" + birthday
				+ ", foreignNationality=" + foreignNationality + ", baseSalary=" + baseSalary + ", memo=" + memo + "]";
	}

}
