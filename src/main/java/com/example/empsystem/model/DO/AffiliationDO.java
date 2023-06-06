package com.example.empsystem.model.DO;

import java.util.Map;

/**
 * 部署情報（全件）を管理するクラス
 * 
 * @author DC-PCN1139
 *
 */
public class AffiliationDO {

	public String AffiliationCd;
	public String ManagementCd;
	public String BrunchCd;
	public String GroupCd;
	public String ManagementNm;
	public String BrunchNm;
	public String GroupNm;
	public String ManagementEmployeeId;
	public String AffiliationNm;
	
	public AffiliationDO(Map<String, Object> result) {
		this.AffiliationCd = (String) result.get("affiliation_cd");
		this.ManagementCd = (String) result.get("management_cd");
		this.BrunchCd = (String) result.get("brunch_cd");
		this.GroupCd = (String) result.get("group_cd");
		this.ManagementNm = (String) result.get("management_nm");
		this.BrunchNm = (String) result.get("brunch_nm");
		this.GroupNm = (String) result.get("group_nm");
		this.ManagementEmployeeId = (String) result.get("management_employee_id");
	}

	public String getAffiliationCd() {
		return AffiliationCd;
	}

	public void setAffiliationCd(String affiliationCd) {
		AffiliationCd = affiliationCd;
	}

	public String getManagementCd() {
		return ManagementCd;
	}

	public void setManagementCd(String managementCd) {
		ManagementCd = managementCd;
	}

	public String getBrunchCd() {
		return BrunchCd;
	}

	public void setBrunchCd(String brunchCd) {
		BrunchCd = brunchCd;
	}

	public String getGroupCd() {
		return GroupCd;
	}

	public void setGroupCd(String groupCd) {
		GroupCd = groupCd;
	}

	public String getManagementNm() {
		return ManagementNm;
	}

	public void setManagementNm(String managementNm) {
		ManagementNm = managementNm;
	}

	public String getBrunchNm() {
		return BrunchNm;
	}

	public void setBrunchNm(String brunchNm) {
		BrunchNm = brunchNm;
	}

	public String getGroupNm() {
		return GroupNm;
	}

	public void setGroupNm(String groupNm) {
		GroupNm = groupNm;
	}

	public String getManagementEmployeeId() {
		return ManagementEmployeeId;
	}

	public void setManagementEmployeeId(String managementEmployeeId) {
		ManagementEmployeeId = managementEmployeeId;
	}

	public String getAffiliationNm() {
		return AffiliationNm;
	}

	public void setAffiliationNm(String affiliationNm) {
		AffiliationNm = affiliationNm;
	}

}
