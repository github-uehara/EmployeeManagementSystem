package com.example.empsystem.model.DO;

import java.util.Map;

/**
 * 部署マスタ情報を管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class AffiliationDO {

	public String affiliationCd;
	public String managementCd;
	public String brunchCd;
	public String groupCd;
	public String managementNm;
	public String brunchNm;
	public String groupNm;
	public String managementEmployeeId;
	public String affiliationNm;

	public AffiliationDO(Map<String, Object> result) {
		this.affiliationCd = (String) result.get("affiliation_cd");
		this.managementCd = (String) result.get("management_cd");
		this.brunchCd = (String) result.get("brunch_cd");
		this.groupCd = (String) result.get("group_cd");
		this.managementNm = (String) result.get("management_nm");
		this.brunchNm = (String) result.get("brunch_nm");
		this.groupNm = (String) result.get("group_nm");
		this.managementEmployeeId = (String) result.get("management_employee_id");
	}

	public String getAffiliationCd() {
		return affiliationCd;
	}

	public void setAffiliationCd(String affiliationCd) {
		this.affiliationCd = affiliationCd;
	}

	public String getManagementCd() {
		return managementCd;
	}

	public void setManagementCd(String managementCd) {
		this.managementCd = managementCd;
	}

	public String getBrunchCd() {
		return brunchCd;
	}

	public void setBrunchCd(String brunchCd) {
		this.brunchCd = brunchCd;
	}

	public String getGroupCd() {
		return groupCd;
	}

	public void setGroupCd(String groupCd) {
		this.groupCd = groupCd;
	}

	public String getManagementNm() {
		return managementNm;
	}

	public void setManagementNm(String managementNm) {
		this.managementNm = managementNm;
	}

	public String getBrunchNm() {
		return brunchNm;
	}

	public void setBrunchNm(String brunchNm) {
		this.brunchNm = brunchNm;
	}

	public String getGroupNm() {
		return groupNm;
	}

	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
	}

	public String getManagementEmployeeId() {
		return managementEmployeeId;
	}

	public void setManagementEmployeeId(String managementEmployeeId) {
		this.managementEmployeeId = managementEmployeeId;
	}

	public String getAffiliationNm() {
		return affiliationNm;
	}

	public void setAffiliationNm(String affiliationNm) {
		this.affiliationNm = affiliationNm;
	}

}
