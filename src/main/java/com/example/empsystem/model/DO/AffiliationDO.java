package com.example.empsystem.model.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部署マスタ情報管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Entity
@Table(name = "m_affiliation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffiliationDO {

	@Column(name = "affiliation_cd")
	public String affiliationCd;

	@Column(name = "management_cd")
	public String managementCd;

	@Column(name = "brunch_cd")
	public String brunchCd;

	@Column(name = "group_cd")
	public String groupCd;

	@Column(name = "management_nm")
	public String managementNm;

	@Column(name = "brunch_nm")
	public String brunchNm;

	@Column(name = "group_nm")
	public String groupNm;

	@Column(name = "management_employee_id")
	public String managementEmployeeId;

	public String affiliationNm;

}
