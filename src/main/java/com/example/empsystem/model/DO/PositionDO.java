package com.example.empsystem.model.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 役職マスタ情報管理クラス
 * 
 * @author DC-PCN1139
 *
 */
@Entity
@Table(name = "m_position")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDO {

	@Column(name = "position_cd")
	public String positionCd;

	@Column(name = "grand_cd")
	public String grandCd;

	@Column(name = "rank_cd")
	public String rankCd;

	@Column(name = "position_nm")
	public String positionNm;

}
