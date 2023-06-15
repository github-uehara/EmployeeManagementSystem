package com.example.empsystem.logic;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.empsystem.logic.Interface.EV8002Logic;
import com.example.empsystem.model.AffiliationList;
import com.example.empsystem.model.DO.AffiliationDO;

/**
 * EV8002Logic実装クラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV8002LogicImpl implements EV8002Logic {

	private final JdbcTemplate jdbcTemplate;
	private ModelMapper modelMapper = new ModelMapper();

	public EV8002LogicImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 部署マスタ情報全件取得
	 * 
	 * @return
	 */
	@Override
	public List<AffiliationDO> findAll() {
		String sql = "SELECT * FROM m_affiliation";

		RowMapper<AffiliationDO> rowMapper = new BeanPropertyRowMapper<AffiliationDO>(AffiliationDO.class);
		List<AffiliationDO> results = jdbcTemplate.query(sql, rowMapper);

		for (AffiliationDO affiliation : results) {
			String affiliationNm = (String) affiliation.getManagementNm();

			if (!(affiliation.getBrunchCd().equals("00"))) {
				affiliationNm += " - " + affiliation.getBrunchNm();
			}

			if (!(affiliation.getGroupCd().equals("00"))) {
				affiliationNm += " - " + affiliation.getGroupNm();
			}

			affiliation.setAffiliationNm(affiliationNm);
		}

		return results;
	}

	/**
	 * 部署マスタ情報をセッション用のモデルにBeanマッピングする
	 * 
	 * @param results
	 * @return
	 */
	@Override
	public List<AffiliationList> converAffiliationList(List<AffiliationDO> results) {
		List<AffiliationList> lists = new ArrayList<AffiliationList>();

		for (AffiliationDO result : results) {
			lists.add(modelMapper.map(result, AffiliationList.class));
		}

		return lists;
	}

}
